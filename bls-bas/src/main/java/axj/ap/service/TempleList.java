package axj.ap.service;

import axj.ap.Entity.TempleEntity;
import axj.db.OSess;

import java.util.ArrayList;
import java.util.List;

public class TempleList {
    public static List<TempleEntity> getTempleList() {
        List<TempleEntity> templeEntityList = new ArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try{
            templeEntityList = sess.getAdl().list(
                    TempleEntity.class,sess.conn(),
                    "select * from temple",
                    null
            );
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sess.close();
        }
        return templeEntityList;
    }

    public static List<TempleEntity> getTempleList(String location) {
        List<TempleEntity> templeEntityList = new ArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try{
            templeEntityList = sess.getAdl().list(
                    TempleEntity.class,sess.conn(),
                    "select * from temple where address like" + "'%" + location + "%'",
                    null
            );
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sess.close();
        }
        return templeEntityList;
    }
}
