package axj.ap.service;

import axj.ap.dao.*;
import axj.ap.entity.TCity;
import axj.ap.entity.interactive.TPray;
import axj.ap.entity.media.TAd;
import axj.ap.entity.media.TArticle;
import axj.ap.entity.media.TScripture;
import axj.ap.entity.temple.TEntity;

import java.util.List;

/**
 * 内容加载类
 */
public class Loader {

    public static List<TEntity> getAllTempleList() {
        return TempleDao.getAllTempleList();
    }

    public static List<TEntity> getTopTempleList(String num) {
        return TempleDao.getTopTempleList(num);
    }

    public static List<TEntity> getTempleListByP(String pid) {
        return TempleDao.getTempleListByP(pid);
    }

    public static List<TEntity> getTempleListById(String id) {
        return TempleDao.getTempleListById(id);
    }

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

    public static List<TPray> getPrayHistory(String userId) {
        return PrayDao.getPrayHistory(userId);
    }
}
