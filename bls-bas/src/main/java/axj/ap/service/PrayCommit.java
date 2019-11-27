package axj.ap.service;

import axj.ap.bean.PrayBehavior;
import axj.db.OSess;

public class PrayCommit {
    public static void commit(PrayBehavior action){
        OSess sess = OSess.source(null).openSess();
        try{
            OSess.Sor<PrayBehavior> sor = sess.insert(null,action);
            sor.update();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sess.close();
        }

    }
}
