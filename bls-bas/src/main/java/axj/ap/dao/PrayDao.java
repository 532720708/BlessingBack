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
            sess.updateWhere(null, TPray.class, new String[]{"wishTime"},
                    "id = " + tPray.getId(), new Object[]{tPray.getWishTime()});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }

    }

    public static List<TPrayContent> getDefaultPrayContent(String id) {
        List<TPrayContent> list = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            list = sess.getAdl().list(
                    TPrayContent.class, sess.conn(),
                    "select * from TPrayContent where buddha = " + id + " limit 5",
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return list;

    }

    public static List<TPray> getPrayHistory(String userId) {
        List<TPray> list = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            list = sess.getAdl().list(
                    TPray.class, sess.conn(),
                    "select * from TPray where userId " + userId,
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
