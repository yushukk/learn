package ml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LinearRegression {
    /*
     * ѵ������ʾ����
     *   x0        x1        x2        y
        1.0       1.0       2.0       7.2
        1.0       2.0       1.0       4.9
        1.0       3.0       0.0       2.6
        1.0       4.0       1.0       6.3
        1.0       5.0      -1.0       1.0
        1.0       6.0       0.0       4.7
        1.0       7.0      -2.0      -0.6
        ע�⣡������x1��x2��y�������û�ʵ����������ݣ�x0��Ϊ���Ƶ������Ĺ�ʽͳһ���صز��ϵ�һ�С�
        x0,x1,x2�ǡ���������y�ǽ��

        h(x) = theta0 * x0 + theta1* x1 + theta2 * x2

        theta0,theta1,theta2 ����Ҫѵ�������Ĳ���

         �˳�����á��ݶ��½�����

     *
     */

    private double [][] trainData;//ѵ�����ݣ�һ��һ�����ݣ�ÿһ�����һ������Ϊ y
    private int row;//ѵ������  ����
    private int column;//ѵ������ ����

    private double [] theta;//����theta

    private double alpha;//ѵ������
    private int iteration;//��������

    public LinearRegression(String fileName)
    {
        int rowoffile=getRowNumber(fileName);//��ȡ����ѵ�������ı���   ����
        int columnoffile = getColumnNumber(fileName);//��ȡ����ѵ�������ı���   ����

        trainData = new double[rowoffile][columnoffile+1];//������Ҫע�⣬ΪʲôҪ+1����ΪΪ��ʹ�ù�ʽ���룬���Ǽ���һ������x0��x0�����1
        this.row=rowoffile;
        this.column=columnoffile+1;

        this.alpha = 0.001;//����Ĭ��Ϊ0.001
        this.iteration=100000;//��������Ĭ��Ϊ 100000

        theta = new double [column-1];//h(x)=theta0 * x0 + theta1* x1 + theta2 * x2 + .......
        initialize_theta();

        loadTrainDataFromFile(fileName,rowoffile,columnoffile);
    }
    public LinearRegression(String fileName,double alpha,int iteration)
    {
        int rowoffile=getRowNumber(fileName);//��ȡ����ѵ�������ı���   ����
        int columnoffile = getColumnNumber(fileName);//��ȡ����ѵ�������ı���   ����

        trainData = new double[rowoffile][columnoffile+1];//������Ҫע�⣬ΪʲôҪ+1����ΪΪ��ʹ�ù�ʽ���룬���Ǽ���һ������x0��x0�����1
        this.row=rowoffile;
        this.column=columnoffile+1;

        this.alpha = alpha;
        this.iteration=iteration;

        theta = new double [column-1];//h(x)=theta0 * x0 + theta1* x1 + theta2 * x2 + .......
        initialize_theta();

        loadTrainDataFromFile(fileName,rowoffile,columnoffile);
    }


    private int getRowNumber(String fileName)
    {
        int count =0;
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ( reader.readLine() != null)
                count++;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return count;

    }

    private int getColumnNumber(String fileName)
    {
        int count =0;
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = reader.readLine();
            if(tempString!=null)
                count = tempString.split(" ").length;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return count;
    }

    private void initialize_theta()//��theta��������ȫ����ʼ��Ϊ1.0
    {
        for(int i=0;i<theta.length;i++)
            theta[i]=1.0;
    }

    public void trainTheta()
    {
        int iteration = this.iteration;
        while( (iteration--)>0 )
        {
            //��ÿ��theta i �� ƫ����
            double [] partial_derivative = compute_partial_derivative();//ƫ����
            //����ÿ��theta
            for(int i =0; i< theta.length;i++)
                theta[i]-= alpha * partial_derivative[i];
        }
    }

    private double [] compute_partial_derivative()
    {
        double [] partial_derivative = new double[theta.length];
        for(int j =0;j<theta.length;j++)//��������ÿ��theta��ƫ����
        {
            partial_derivative[j]= compute_partial_derivative_for_theta(j);//�� theta i �� ƫ��
        }
        return partial_derivative;
    }
    private double compute_partial_derivative_for_theta(int j)
    {
        double sum=0.0;
        for(int i=0;i<row;i++)//���� ÿһ������
        {
            sum+=h_theta_x_i_minus_y_i_times_x_j_i(i,j);
        }
        return sum/row;
    }
    public double h_theta_x_i_minus_y_i_times_x_j_i(int i,int j)
    {
        double[] oneRow = getRow(i);//ȡһ�����ݣ�ǰ����feature�����һ����y
        double result = 0.0;

        for(int k=0;k< (oneRow.length-1);k++)
            result+=theta[k]*oneRow[k];
        result-=oneRow[oneRow.length-1];
        result*=oneRow[j];
        return result;
    }
    private double [] getRow(int i)//��ѵ��������ȡ����i�У�i=0��1��2������������row-1��
    {
        return trainData[i];
    }


    private void loadTrainDataFromFile(String fileName,int row, int column)
    {
        for(int i=0;i< row;i++)//trainData�ĵ�һ��ȫ����Ϊ1.0��feature x0��
            trainData[i][0]=1.0;

        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int counter = 0;
            while ( (counter<row) && (tempString = reader.readLine()) != null) {
                String [] tempData = tempString.split(" ");
                for(int i=0;i<column;i++)
                    trainData[counter][i+1]=Double.parseDouble(tempData[i]);
                counter++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public void printTrainData()
    {
        System.out.println("Train Data:\n");
        for(int i=0;i<column-1;i++)
            System.out.printf("%10s","x"+i+" ");
        System.out.printf("%10s","y"+" \n");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                System.out.printf("%10s",trainData[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printTheta()
    {
        for(double a:theta)
            System.out.print(a+" ");
    }

}