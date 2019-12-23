package axj.ap.service;

import axj.ap.dao.SearchDao;
import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Searcher {
    public static List<String> getSearchResult(String str) {
        List<String> result = new CopyOnWriteArrayList<>();
        result.add(JSON.toJSONString(SearchDao.getTemple(str)));
        result.add(JSON.toJSONString(SearchDao.getScripture(str)));
        return result;
    }
}
