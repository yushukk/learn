package org.erik.ognl;

import org.apache.ibatis.ognl.*;
import org.junit.Test;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ³¾¶« on 2015/4/24.
 */
public class OgnlTest {
    @Test
    public void test01() throws ParseException, OgnlException {
        Node node= new OgnlParser(new StringReader("id!=null")).topLevelExpression();
        Map<String,Object> content = new HashMap<String, Object>();
        content.put("id",2);
        Object o = Ognl.getValue(node, 2);
        System.out.println(o);

    }
}
