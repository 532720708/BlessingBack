package axj.ap.entity.media;

import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.crud.an.AHtml;
import axj.db.an.AColumn;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.db.an.ARefer;
import axj.valid.an.Required;

/**
 * 首页的文章
 */
@AEdit.EType(order = "id>")
@AMenu({@AMenu.Menu("多媒体信息管理"), @AMenu.Menu("文章列表")})
@AEntity
public class TArticle {

    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @Required
    @ALa("文章标题")
    @AColumn(len = 409600)
    @AEdit(group = AEdit.List)
    private String title;

    @ALa("文章内容")
    @Required
    @AHtml
    @AColumn(len = 409600)
    @AEdit(group = AEdit.List)
    private String content;

    @ALa("浏览量")
    @AEdit(group = AEdit.List)
    private Integer hot;

    @Required
    @ALa("文章分类")
    @AEdit(group = AEdit.List)
    @ARefer
    private TArticleCat articleCat;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public TArticleCat getArticleCat() {
        return articleCat;
    }

    public void setArticleCat(TArticleCat articleCat) {
        this.articleCat = articleCat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
