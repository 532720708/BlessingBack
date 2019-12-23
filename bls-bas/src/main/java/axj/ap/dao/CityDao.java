package axj.ap.dao;

import axj.ap.entity.TCity;
import axj.db.OSess;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CityDao {
    public static List<TCity> getCity() {
        List<TCity> cityList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            cityList = sess.getAdl().list(
                    TCity.class, sess.conn(),
                    "select * from TCity where pid = 1",
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return cityList;
    }
}
