package axj.ap.dao;

import axj.ap.entity.TAd;
import axj.db.OSess;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AdDao {

    public static List<TAd> getAdList() {
        List<TAd> AdList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            AdList = sess.getAdl().list(
                    TAd.class, sess.conn(),
                    "select * from TAd by timestamp desc",
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return AdList;
    }

    public static List<TAd> getAdList(int num) {
        List<TAd> AdList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            AdList = sess.getAdl().list(
                    TAd.class, sess.conn(),
                    "select * from TAd by timestamp desc limit " + num,
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return AdList;
    }
}
