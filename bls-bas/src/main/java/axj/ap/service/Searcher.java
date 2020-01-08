package axj.ap.service;

import axj.ap.dao.SearchDao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Searcher {
    public static List<Object> getSearchResult(String str) {
        List<Object> result = new CopyOnWriteArrayList<>();
        result.add(SearchDao.getTemple(str));
        result.add(SearchDao.getScripture(str));
        return result;
    }
}
