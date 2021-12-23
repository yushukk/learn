package org.erik;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * Created by ³¾¶« on 2017/5/30.
 */
public class Test {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(".*?#(.*?)#.*");
        Matcher matcher = pattern.matcher("725677994#503686748943#f150aa93ab");
        String orderCode = null;
        if(matcher.find()){
            orderCode = matcher.group(1);
        }
        System.out.println(orderCode);
        ;

    }
}
