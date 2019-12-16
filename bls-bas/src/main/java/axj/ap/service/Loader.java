package axj.ap.service;

import axj.ap.dao.ArticleDao;
import axj.ap.dao.CityDao;
import axj.ap.dao.ScriptureDao;
import axj.ap.dao.TempleDao;
import axj.ap.entity.TArticle;
import axj.ap.entity.TCity;
import axj.ap.entity.TEntity;
import axj.ap.entity.TScripture;

import java.util.List;

public class Loader {
    public static List<TCity> getCity() {
        return CityDao.getCity();
    }

    public static List<TArticle> getAllArticle(){
        return ArticleDao.getAllArticle();
    }

    public static List<TArticle> getArticleById(String id){
        return ArticleDao.getArticleById(id);
    }

    public static List<TScripture> getAllScripture(){
        return ScriptureDao.getAllScripture();
    }

    public static List<TScripture> getScriptureById(String id){
        return ScriptureDao.getScriptureById(id);
    }


}
