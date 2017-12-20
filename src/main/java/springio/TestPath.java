package springio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ³¾¶« on 2016/1/27.
 */
public class TestPath {
    public static void main(String[] args) {

        Path path = Paths.get("/home/admin").normalize();
        System.out.println(path.toString());
        System.out.println(path.resolve("freemall"));


    }
}
