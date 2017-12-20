package ml;

public class TestLinearRegression {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinearRegression m = new LinearRegression("D://data.txt",0.001,1000000);
        m.printTrainData();
        double v = m.h_theta_x_i_minus_y_i_times_x_j_i(0, 0);
        System.out.println(v);
//        m.trainTheta();
//        m.printTheta();
    }

}