package maven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by ³¾¶« on 2016/2/24.
 */
public class ExcludeJar {

    public static void main(String[] args) throws IOException {
        String dep = "";

        StringReader sr = new StringReader(dep);
        BufferedReader br = new BufferedReader(sr);
        String line ;
        int i = 0;
        while ((line = br.readLine())!=null){
            if(line.startsWith("[INFO] |  +-")){
                int a = line.indexOf("+-");
                int b = line.indexOf(":",0);
                int c = line.indexOf(":",b+1);
                System.out.println("<exclusion>");
                System.out.println("<groupId>"+line.substring(a+3,b)+"</groupId>");
                System.out.println("<artifactId>"+line.substring(b+1,c)+"</artifactId>");
                System.out.println("</exclusion>");
                i++;
            }
        }
        System.out.println("¹²ÅÅ³ý"+i+"¸öÒÀÀµ");
    }



}
