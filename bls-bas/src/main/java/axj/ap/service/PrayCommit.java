package axj.ap.service;

import axj.ap.entity.PrayBehavior;
import axj.db.OSess;
import com.alibaba.fastjson.JSONObject;

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

    public static void commit(String action){
        PrayBehavior prayBehavior = new PrayBehavior();

        JSONObject jsonObject = JSONObject.parseObject(action);
        prayBehavior.setUserId(jsonObject.getInteger("userId"));
        prayBehavior.setKind(jsonObject.getString("kind"));
        prayBehavior.setName(jsonObject.getString("name"));
        prayBehavior.setContent(jsonObject.getString("content"));
        prayBehavior.setGender(jsonObject.getString("gender"));

        OSess sess = OSess.source(null).openSess();
        try{
            OSess.Sor<PrayBehavior> sor = sess.insert(null,prayBehavior);
            sor.update();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sess.close();
        }
    }
}
