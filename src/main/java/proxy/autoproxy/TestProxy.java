package proxy.autoproxy;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;
import proxy.Book;
import proxy.BookFacade;
import proxy.BookFacadeImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wandong.cwd on 2014/12/11.
 */
public class TestProxy {

    public static void main(String[] args) throws Exception {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade dd = new BookFacadeImpl();
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
        List<Book> bookList = new ArrayList<Book>();
        bookProxy.addBook(bookList);
        System.out.println(Proxy.isProxyClass(bookProxy.getClass()));

        System.out.println(BookFacade.class.isInstance(dd));
        System.out.println(BookFacade.class.isInstance(bookProxy));

        System.out.println(bookProxy.getClass());

        System.out.println(bookProxy.getClass().getSuperclass());
        System.out.println(bookProxy.getClass().getSuperclass().getSuperclass());


        System.out.println(Proxy.isProxyClass(dd.getClass()));

        System.out.println(getJdkDynamicProxyTargetObject(bookProxy));


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

    private static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        Object  aa = h.get(proxy);

        Field target = aa.getClass().getDeclaredField("target");
        target.setAccessible(true);
        Object targetO = target.get(aa);

        return  targetO;

    }

}
