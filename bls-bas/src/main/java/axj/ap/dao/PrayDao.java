package axj.ap.dao;

import axj.ap.entity.interactive.TPray;
import axj.db.OSess;

public class PrayDao {

    public static void commit(TPray behavior) {
        OSess sess = OSess.source(null).openSess();
        try {
            OSess.Sor<TPray> sor = sess.insert(null, behavior);
            sor.update();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
    }
}
