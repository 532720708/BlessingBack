package axj.ap.service;

import axj.ap.bean.PrayBehavior;
import axj.ap.bean.Temple;
import axj.db.OSess;

import java.util.ArrayList;
import java.util.List;

public class TempleList {
    public static List<Temple> getTempleList() {
        List<Temple> templeList = new ArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try{
            templeList = sess.getAdl().list(
                    Temple.class,sess.conn(),
                    "select * from temple",
                    null
            );
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sess.close();
        }
        return templeList;
    }

    public static List<Temple> getTempleList(String location) {
        List<Temple> templeList = new ArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try{
            templeList = sess.getAdl().list(
                    Temple.class,sess.conn(),
                    "select * from temple where address like" + "'%" + location + "%'",
                    null
            );
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sess.close();
        }
        return templeList;
    }
}
