package axj.ap.dao;

import axj.ap.entity.TempleEntity;
import axj.db.OSess;

import java.util.ArrayList;
import java.util.List;

public class TempleDao {
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

    public static List<TempleEntity> getTempleListByLoc(String location) {
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

    public static List<TempleEntity> getTempleListById(String id) {
        List<TempleEntity> templeEntityList = new ArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try{
            templeEntityList = sess.getAdl().list(
                    TempleEntity.class,sess.conn(),
                    "select * from temple where id = " + id,
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
