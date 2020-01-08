package axj.ap.service;

import axj.ap.dao.*;
import axj.ap.entity.TCity;
import axj.ap.entity.comment.TComment;
import axj.ap.entity.interactive.TPray;
import axj.ap.entity.media.*;
import axj.ap.entity.temple.TEntity;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 内容加载类
 */
public class Loader {

    public static List<TEntity> getAllTempleList() {
        return TempleDao.getAllTempleList();
    }

    public static List<TEntity> getTopTempleList(String num) {
        return TempleDao.getTopTempleList(Integer.parseInt(num));
    }

    public static List<TEntity> getTempleListByP(String pid) {
        return TempleDao.getTempleListByP(Integer.parseInt(pid));
    }

    public static List<TEntity> getTempleListById(Integer id) {
        return TempleDao.getTempleListById(id);
    }

    public static List<TCity> getCity() {
        return CityDao.getCity();
    }

    public static List<TArticle> getArticle() {
        return ArticleDao.getArticle();
    }

    public static List<TArticle> getArticle(Integer id) {
        return ArticleDao.getArticle(id);
    }

    public static List<TScripture> getScripture() {
        return ScriptureDao.getScripture();
    }

    public static List<TScripture> getScripture(Integer id) {
        return ScriptureDao.getScripture(id);
    }

    public static List<TAd> getAd() {
        return AdDao.getAdList();
    }

    public static List<TAd> getAd(int num) {
        return AdDao.getAdList(num);
    }

    public static List<TPray> getPrayHistory(Integer userId) {
        return PrayDao.getPrayHistory(userId);
    }

    public static List<TBirth> getBirth(Integer timestamp, Integer n) {
        return BirthDao.getBirthList(timestamp, n);
    }

    public static List<TBirth> getBirth() {
        return BirthDao.getBirthList();
    }

    public static List<TBuddhistArticle> getBuddhistArticle(int count) {
        return ArticleDao.getBuddhistArticle(count);
    }

    public static List<TBuddhistArticle> getBuddhistArticle() {
        return ArticleDao.getBuddhistArticle();
    }


    public static List<Object> getCommentList(String cmtType, String cmtObjId, Integer need) {
        List<Object> result = new CopyOnWriteArrayList<>();
        List<TComment> commentList = CmtDao.getCommentList(cmtType, cmtObjId);
        result.add(commentList);
        if (need == 1) {
            String[] integers = new String[commentList.size()];
            for (int i = 0; i < commentList.size(); i++) {
                integers[i] = commentList.get(i).getId();
            }
            result.add(CmtDao.getReplicationList(integers));
        }
        return result;
    }
}
