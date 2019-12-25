package axj.ap.service;

import axj.ap.dao.PrayDao;
import axj.ap.entity.interactive.TPray;
import axj.ap.entity.interactive.TPrayContent;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class Prayer {

    public static void wish(String str) {
        TPray tPray = new TPray();
        JSONObject jsonObject = JSONObject.parseObject(str);
        tPray.setUserId(jsonObject.getInteger("userId"));
        tPray.setPrayTime(jsonObject.getInteger("timestamp"));
        tPray.settBuddha(jsonObject.getInteger("buddhaId"));
        tPray.setContent(jsonObject.getString("content"));
        //如果没有还愿就是0
        tPray.setWishTime(0);
        tPray.settEntity(jsonObject.getInteger("templeId"));
        tPray.setWorship(StringToInt(jsonObject.getString("worship").split(",")));
        PrayDao.wish(tPray);
    }

    public static void backWish(String str) {
        JSONArray jsonArray = JSONArray.parseArray(str);
        for (int i = 0; i < jsonArray.size(); i++) {
            TPray tPray = new TPray();
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            tPray.setId(jsonObject.getInteger("Id"));
            tPray.setWishTime(jsonObject.getInteger("timestamp"));
            PrayDao.backWish(tPray);
        }
    }

    public static int[] StringToInt(String[] arrs) {

        int[] ints = new int[arrs.length];
        for (int i = 0; i < arrs.length; i++) {
            ints[i] = Integer.parseInt(arrs[i]);
        }
        return ints;
    }

    public static List<TPrayContent> getDefaultPrayContent(String id) {
        return PrayDao.getDefaultPrayContent(id);
    }
}
