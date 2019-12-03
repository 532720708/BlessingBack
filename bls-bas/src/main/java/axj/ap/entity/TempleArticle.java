package axj.ap.entity;

import axj.an.ALa;
import axj.db.an.AEntity;
import axj.db.an.AId;

@AEntity
public class TempleArticle  {

    @ALa("编号")
    @AId(auto = true)
    private Integer id;

    @ALa("寺院编号")
    private Integer templeId;

    @ALa("文章地址")
    private String articleURL;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTempleId() {
        return templeId;
    }

    public void setTempleId(Integer templeId) {
        this.templeId = templeId;
    }

    public String getArticleURL() {
        return articleURL;
    }

    public void setArticleURL(String articleURL) {
        this.articleURL = articleURL;
    }
}
