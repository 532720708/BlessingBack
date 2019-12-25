package axj.ap.service;

import axj.ap.dao.PrayDao;
import axj.ap.entity.interactive.TPray;
import com.alibaba.fastjson.JSONObject;

public class Prayer {

    public static void commit(String str) {
        TPray TPray = new TPray();
        JSONObject jsonObject = JSONObject.parseObject(str);
        TPray.setUserId(jsonObject.getInteger("userId"));
        TPray.setPrayTime(jsonObject.getInteger("timestamp"));
//        prayBehavior.setBuddha();

        PrayDao.commit(TPray);
    }

//    public static void commit(String action) {
//        PrayBehavior prayBehavior = new PrayBehavior();
//
//        JSONObject jsonObject = JSONObject.parseObject(action);
//        prayBehavior.setUserId(jsonObject.getInteger("userId"));
//        prayBehavior.setKind(jsonObject.getString("kind"));
//        prayBehavior.setName(jsonObject.getString("name"));
//        prayBehavior.setContent(jsonObject.getString("content"));
//        prayBehavior.setGender(jsonObject.getString("gender"));
//
//        OSess sess = OSess.source(null).openSess();
//        try {
//            OSess.Sor<PrayBehavior> sor = sess.insert(null, prayBehavior);
//            sor.update();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            sess.close();
//        }
//    }
}
