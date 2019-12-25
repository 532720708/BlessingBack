package axj.ap.service;

import axj.ap.dao.AdDao;
import axj.ap.dao.ArticleDao;
import axj.ap.dao.CityDao;
import axj.ap.dao.ScriptureDao;
import axj.ap.entity.TCity;
import axj.ap.entity.media.TAd;
import axj.ap.entity.media.TArticle;
import axj.ap.entity.media.TScripture;

import java.util.List;

public class Loader {
    public static List<TCity> getCity() {
        return CityDao.getCity();
    }

    public static List<TArticle> getArticle() {
        return ArticleDao.getArticle();
    }

    public static List<TArticle> getArticle(String id) {
        return ArticleDao.getArticle(id);
    }

    public static List<TScripture> getScripture() {
        return ScriptureDao.getScripture();
    }

    public static List<TScripture> getScripture(String id) {
        return ScriptureDao.getScripture(id);
    }

    public static List<TAd> getAd() {
        return AdDao.getAdList();
    }

    public static List<TAd> getAd(int num) {
        return AdDao.getAdList(num);
    }


}
