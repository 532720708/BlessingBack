package axj.ap.dao;

import axj.ap.entity.media.TArticle;
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

    public static List<TArticle> getArticle(String id) {
        List<TArticle> articleList = new CopyOnWriteArrayList<>();
        OSess sess = OSess.source(null).openSess();
        try {
            articleList = sess.getAdl().list(
                    TArticle.class, sess.conn(),
                    "select * from TArticle where id = " + id,
                    null
            );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }
        return articleList;
    }
}
