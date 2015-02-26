package proxy;

import java.util.List;

/**
 * Created by wandong.cwd on 2014/12/11.
 */
public class BookFacadeImpl implements BookFacade {

    @Override
    public void addBook(List<Book> books) {
        System.out.println("增加图书方法。。。");
    }

}
