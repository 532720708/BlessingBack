package axj.ap.service;

import axj.ap.dao.SearchDao;
import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Searcher {
    public static List<Object> getSearchResult(String str) {
        List<Object> result = new CopyOnWriteArrayList<>();
        System.out.println(JSON.toJSONString(SearchDao.getTemple(str)));
        result.add(SearchDao.getTemple(str));
        result.add(SearchDao.getScripture(str));
        return result;
    }
}
