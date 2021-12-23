package odps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class GroupSettingUtil {

    public static void main(String[] args) throws IOException {



        String groupByKeys = "seller_id,activity_id,item_id";
        String groupBySets = "(seller_id),\n"
            + "        (seller_id,activity_id),\n"
            + "        (seller_id,activity_id,item_id),\n"
            + "        (seller_id,item_id)";

        String[] groupByKeyArray = groupByKeys.replaceAll("\n| ","").split(",");
        int keyLength = groupByKeyArray.length;

        StringReader sr = new StringReader(groupBySets);
        BufferedReader br = new BufferedReader(sr);
        String line ;
        while ((line = br.readLine())!=null){
            int start = line.indexOf("(");
            int end = line.indexOf(")");
            if(start >= 0 && end >= 0){
                String set = line.substring(start,end +1);
                String key = line.substring(start+1,end);
                String[] keyArray = key.split(",");
                Set<String> keySet = new HashSet<String>(Arrays.asList(keyArray));

                long bit = 0;
                int i = 0;
                for (String s : groupByKeyArray) {
                    i++;
                    if(keySet.contains(s)){
                        bit = BitDataUtil.set(bit,keyLength-i,false);
                    }else{
                        bit = BitDataUtil.set(bit,keyLength-i,true);
                    }
                }
                System.out.println("when grouping_id = " + bit + " then '" + set + "'");
            }
        }



    }


}
