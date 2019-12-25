package axj.ap.service;

import axj.ap.entity.interactive.TPray;
import axj.db.OSess;

import java.util.ArrayList;
import java.util.List;

public class PrayHistory {
    public static List<TPray> getHistory(int userId) {
        List<TPray> historyList = new ArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            historyList = sess.getAdl().list(
                    TPray.class, sess.conn(),
                    "select * from praybehavior where userId = " + userId,
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return historyList;
    }
}
