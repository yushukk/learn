package jvm;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLClassLoader;


public class Main {
    public static void main(String[] args) {

        URL[] urls = new URL[] {};
        MyClassLoader classLoader = new MyClassLoader(urls, null);

        /*try {
            classLoader.addJar(new File("d:\\Repositories\\Maven\\org\\erik\\utils\\1.0-SNAPSHOT\\utils-1.0-SNAPSHOT.jar").toURI().toURL());
            Class<?> clazz = classLoader.loadClass("org.erik.utils.JavaUtil");
            Method method = clazz.getDeclaredMethod("getVersion");
            String version = (String)method.invoke(null);
            System.out.println("java version: hehe" + version);
            classLoader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        try {
            classLoader.addJar(new File("D:\\code\\shaxiang_4\\freemall\\freemall-common\\target\\freemall-common-1.2.0-SNAPSHOT.jar").toURI().toURL());
            Class<?> clazz = classLoader.loadClass("com.tmall.freemall.common.shop.point.SyncShopPoint");
            Method method = clazz.getMethods()[0];
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type genericParameterType = genericParameterTypes[1];
            //Method method = clazz.getDeclaredMethod("getVersion");
            //String version = (String)method.invoke(null);
            //System.out.println("java version: hehe" + version);
            classLoader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    static class MyClassLoader extends URLClassLoader {

        public MyClassLoader(URL[] urls) {
            super(urls);
        }

        public MyClassLoader(URL[] urls, ClassLoader parent) {
            super(urls, parent);
        }

        public void addJar(URL url) {
            this.addURL(url);
        }

    }

}
