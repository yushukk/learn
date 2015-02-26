package proxy.autoproxy;

import proxy.Book;
import proxy.BookFacade;
import proxy.BookFacadeImpl;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wandong.cwd on 2014/12/11.
 */
public class TestProxy {

    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
        List<Book> bookList = new ArrayList<Book>();
        bookProxy.addBook(bookList);

        for(Method m:bookProxy.getClass().getMethods()){
            if("addBook".equals(m.getName())){
                Class aClass = (Class)(m.getGenericParameterTypes()[0]);
                System.out.println(aClass.getName());
            }
        }

        BookFacade bookFacade = new BookFacadeImpl();
        for(Method m:bookFacade.getClass().getMethods()){
            if("addBook".equals(m.getName())){
                ParameterizedType aClass = (ParameterizedType)(m.getGenericParameterTypes()[0]);
                System.out.println(aClass);
            }
        }

    }

}
