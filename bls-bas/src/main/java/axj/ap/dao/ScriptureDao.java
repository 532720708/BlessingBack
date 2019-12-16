package axj.ap.dao;

import axj.ap.entity.TScripture;
import axj.db.OSess;

import java.util.ArrayList;
import java.util.List;

public class ScriptureDao {

    public static List<TScripture> getAllScripture() {
        List<TScripture> scriptureList = new ArrayList<>();
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

    public static List<TScripture> getScriptureById(String id) {
        List<TScripture> scriptureList = new ArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            scriptureList = sess.getAdl().list(
                    TScripture.class, sess.conn(),
                    "select * from TScripture where id = " + id,
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return scriptureList;
    }
}
