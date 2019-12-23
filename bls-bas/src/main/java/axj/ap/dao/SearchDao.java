package axj.ap.dao;

import axj.ap.entity.media.TScripture;
import axj.ap.entity.temple.TEntity;
import axj.db.OSess;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 搜索
 */
public class SearchDao {


    public static List<TScripture> getScripture(String str) {
        List<TScripture> scriptureList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            scriptureList = sess.getAdl().list(
                    TScripture.class, sess.conn(),
                    "select * from TScripture where name like " + str,
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return scriptureList;
    }

    public static List<TEntity> getTemple(String str) {
        List<TEntity> templeEntityList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            templeEntityList = sess.getAdl().list(
                    TEntity.class, sess.conn(),
                    "select * from TEntity where title like " + str,
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
