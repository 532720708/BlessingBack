package axj.ap.dao;

import axj.ap.entity.media.TArticle;
import axj.ap.entity.media.TBuddhistArticle;
import axj.db.OSess;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArticleDao {
    public static List<TArticle> getArticle() {
        List<TArticle> articleList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            articleList = sess.getAdl().list(
                    TArticle.class, sess.conn(),
                    "select * from TArticle",
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return articleList;
    }

    public static List<TArticle> getArticle(Integer id) {
        List<TArticle> articleList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            articleList = sess.getAdl().list(
                    TArticle.class, sess.conn(),
                    "select * from TArticle where id = ?",
                    new Integer[]{id}
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return articleList;
    }

    public static List<TBuddhistArticle> getBuddhistArticle(int count) {
        List<TBuddhistArticle> tBuddhistArticles = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            tBuddhistArticles = sess.getAdl().list(
                    TBuddhistArticle.class, sess.conn(),
                    "select * from TBuddhistArticle limit ?",
                    new Integer[]{count}
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return tBuddhistArticles;
    }

    public static List<TBuddhistArticle> getBuddhistArticle() {
        List<TBuddhistArticle> tBuddhistArticles = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            tBuddhistArticles = sess.getAdl().list(
                    TBuddhistArticle.class, sess.conn(),
                    "select * from TBuddhistArticle",
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return tBuddhistArticles;
    }
}
