package axj.ap.dao;

import axj.ap.entity.TCity;
import axj.ap.entity.temple.TEntity;
import axj.db.OSess;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TempleDao {
    public static List<TEntity> getAllTempleList() {
        List<TEntity> templeEntityList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            templeEntityList = sess.getAdl().list(
                    TEntity.class, sess.conn(),
                    "select * from TEntity",
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return templeEntityList;
    }

    public static List<TEntity> getTopTempleList(Integer num) {
        List<TEntity> templeEntityList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            templeEntityList = sess.getAdl().list(
                    TEntity.class, sess.conn(),
                    "select * from TEntity order by hot desc limit ?",
                    new Integer[]{num}
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return templeEntityList;
    }

    public static List<TEntity> getTempleListByP(Integer pid) {
        List<TEntity> templeEntityList = new CopyOnWriteArrayList<>();
        List<TCity> tCityList = new ArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            tCityList = sess.getAdl().list(
                    TCity.class, sess.conn(),
                    "SELECT cityname FROM `TCity` where id = ?",
                    new Integer[]{pid}
            );
            templeEntityList = sess.getAdl().list(
                    TEntity.class, sess.conn(),
                    "SELECT * FROM TEntity where province like ?",
                    new String[]{"%" + tCityList.get(0).getCityname() + "%"}
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return templeEntityList;
    }

    public static List<TEntity> getTempleListById(Integer id) {
        List<TEntity> templeEntityList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            templeEntityList = sess.getAdl().list(
                    TEntity.class, sess.conn(),
                    "select * from TEntity where id = ?",
                    new Integer[]{id}
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return templeEntityList;
    }
}
