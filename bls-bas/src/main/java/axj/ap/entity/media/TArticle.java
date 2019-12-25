package axj.ap.entity.media;

import axj.an.AClass;
import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.crud.an.AHtml;
import axj.db.an.AColumn;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.valid.an.Required;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 首页的文章
 */
@AMenu({@AMenu.Menu("多媒体信息管理"), @AMenu.Menu("文章列表")})
@AEntity
public class TArticle {

    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @Required
    @ALa("文章标题")
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
    @JSONField(serialize = false)
    @AClass(TArticleCat.class)
    private int[] articleCatId;

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

    public int[] getArticleCatId() {
        return articleCatId;
    }

    public void setArticleCatId(int[] articleCatId) {
        this.articleCatId = articleCatId;
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
