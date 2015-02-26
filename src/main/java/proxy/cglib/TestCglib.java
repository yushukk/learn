package proxy.cglib;

import proxy.Book;
import proxy.BookFacadeImpl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wandong.cwd on 2014/12/11.
 */
public class TestCglib {

    public static void main(String[] args) {
        BookFacadeCglib cglib=new BookFacadeCglib();
        BookFacadeImpl bookCglib=(BookFacadeImpl)cglib.getInstance(new BookFacadeImpl());
        List<Book> bookList = new ArrayList<Book>();
        bookCglib.addBook(bookList);

        for(Method m:bookCglib.getClass().getMethods()){
            if("addBook".equals(m.getName())){
                Class aClass = (Class)(m.getGenericParameterTypes()[0]);
                System.out.println(aClass.getName());
            }
        }

    }
}
