package axj.ap.dao;

import axj.ap.entity.TArticle;
import axj.db.OSess;

import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    public static List<TArticle> getAllArticle() {
        List<TArticle> articleList = new ArrayList<>();
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

    public static List<TArticle> getArticleById(String id) {
        List<TArticle> articleList = new ArrayList<>();
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
