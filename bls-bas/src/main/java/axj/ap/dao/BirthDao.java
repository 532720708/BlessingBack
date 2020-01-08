package axj.ap.dao;

import axj.ap.entity.media.TBirth;
import axj.db.OSess;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BirthDao {
    public static List<TBirth> getBirthList() {
        List<TBirth> birthList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            birthList = sess.getAdl().list(
                    TBirth.class, sess.conn(),
                    "select * from TBirth order by timestamp asc",
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return birthList;
    }

    public static List<TBirth> getBirthList(Integer timestamp, Integer n) {
        List<TBirth> birthList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            birthList = sess.getAdl().list(
                    TBirth.class, sess.conn(),
                    //TODO between
                    "select * from TBirth where " +
                            "timestamp > ? and timestamp < ? limit ? order by timestamp desc",
                    new Integer[]{(timestamp - 30 * 24 * 60 * 60),
                            (timestamp + 30 * 24 * 60 * 60),
                            n}

            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return birthList;
    }
}
