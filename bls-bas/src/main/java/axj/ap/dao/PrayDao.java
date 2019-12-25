package axj.ap.dao;

import axj.ap.entity.interactive.TPray;
import axj.ap.entity.interactive.TPrayContent;
import axj.db.OSess;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PrayDao {

    public static void wish(TPray tPray) {
        OSess sess = OSess.source(null).openSess();
        try {
            OSess.Sor<TPray> sor = sess.insert(null, tPray);
            sor.update();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
    }

    public static void backWish(TPray tPray) {
        OSess sess = OSess.source(null).openSess();
        try {
//            sess.updateWhere(null, TPray.class, new String[]{"articlePrefList", "latest_log_time"},
//                    "jMemberId = ? ", new Object[]{articlePrefListMap.get(userId).toString(), 1567562648, userId.intValue()});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }

    }

    public static List<TPrayContent> getDefaultPrayContent() {
        List<TPrayContent> list = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            list = sess.getAdl().list(
                    TPrayContent.class, sess.conn(),
                    "select * from TPrayContent limit 5",
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return list;

    }

}
