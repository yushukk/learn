package maven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by ³¾¶« on 2016/2/24.
 */
public class ExcludeSQL {

    public static void main(String[] args) throws IOException {
        String dep = "SELECT\n"
            + "\t\t\tdashboard.id,\n"
            + "\t\t\tdashboard.uid,\n"
            + "\t\t\tdashboard.title,\n"
            + "\t\t\tdashboard.slug,\n"
            + "\t\t\tdashboard_tag.term,\n"
            + "\t\t\tdashboard.is_folder,\n"
            + "\t\t\tdashboard.folder_id,\n"
            + "\t\t\tfolder.uid as folder_uid,\n"
            + "\t\t\tfolder.slug as folder_slug,\n"
            + "\t\t\tfolder.title as folder_title\n"
            + "\t\tFROM ( SELECT dashboard.id FROM dashboard  INNER JOIN star on star.dashboard_id = dashboard.id "
            + "WHERE  dashboard.org_id=? AND star.user_id=? ORDER BY dashboard.title LIMIT 4) as ids INNER JOIN "
            + "dashboard on ids.id = dashboard.id \n"
            + "\t\tLEFT OUTER JOIN dashboard folder on folder.id = dashboard.folder_id\n"
            + "\t\tLEFT OUTER JOIN dashboard_tag on dashboard.id = dashboard_tag.dashboard_id ORDER BY dashboard"
            + ".title ASC LIMIT 5000";

        StringReader sr = new StringReader(dep);
        BufferedReader br = new BufferedReader(sr);
        String line ;
        int i = 0;
        while ((line = br.readLine())!=null){
            if(line.startsWith("  `")){
                String name = line.substring(line.indexOf("`") + 1,line.indexOf("`",line.indexOf("`")+1) );
                line = line.substring(0,line.length() -1);
                System.out.print(line + " COMMENT '" + name + "',\n");
            }else{
                System.out.println(line);
            }
        }
    }



}
