package mock;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 *
 * Created by ³¾¶« on 2017/10/2.
 */
public class TestMock {


    public static void main(String[] args) {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();

        verify(mockedList,times(2)).add("one");
        verify(mockedList).clear();

    }

}
