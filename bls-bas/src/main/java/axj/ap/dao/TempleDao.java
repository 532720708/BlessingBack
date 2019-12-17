package axj.ap.dao;

import axj.ap.entity.TCity;
import axj.ap.entity.TEntity;
import axj.db.OSess;

import java.util.ArrayList;
import java.util.List;

public class TempleDao {
    public static List<TEntity> getAllTempleList() {
        List<TEntity> templeEntityList = new ArrayList<>();
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

    public static List<TEntity> getTopTempleList(String num) {
        List<TEntity> templeEntityList = new ArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            templeEntityList = sess.getAdl().list(
                    TEntity.class, sess.conn(),
                    "select * from TEntity order by hot desc limit " + num,
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return templeEntityList;
    }

    public static List<TEntity> getTempleListByP(String pid) {
        List<TEntity> templeEntityList = new ArrayList<>();
        List<TCity> tCityList = new ArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            tCityList = sess.getAdl().list(
                    TCity.class, sess.conn(),
                    "SELECT cityname FROM `TCity` where id = " + pid,
                    null
            );
            templeEntityList = sess.getAdl().list(
                    TEntity.class, sess.conn(),
                    "SELECT * FROM TEntity where province like '" + tCityList.get(0).getCityname() + "%'",
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return templeEntityList;
    }

    public static List<TEntity> getTempleListById(String id) {
        List<TEntity> templeEntityList = new ArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            templeEntityList = sess.getAdl().list(
                    TEntity.class, sess.conn(),
                    "select * from TEntity where id = " + id,
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return templeEntityList;
    }
}
