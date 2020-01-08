package axj.ap.dao;

import axj.ap.entity.media.TScripture;
import axj.db.OSess;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ScriptureDao {

    public static List<TScripture> getScripture() {
        List<TScripture> scriptureList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            scriptureList = sess.getAdl().list(
                    TScripture.class, sess.conn(),
                    "select * from TScripture",
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return scriptureList;
    }

    public static List<TScripture> getScripture(Integer id) {
        List<TScripture> scriptureList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            scriptureList = sess.getAdl().list(
                    TScripture.class, sess.conn(),
                    "select * from TScripture where id = ?",
                    new Integer[]{id}
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return scriptureList;
    }
}
