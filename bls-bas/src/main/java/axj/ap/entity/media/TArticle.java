package axj.ap.entity.media;

import axj.an.ALa;
import axj.an.AMenu;
import axj.db.an.AColumn;
import axj.db.an.AEntity;
import axj.db.an.AId;

/**
 * 首页的文章
 */
@AMenu({@AMenu.Menu("多媒体信息管理"), @AMenu.Menu("首页文章")})
@AEntity
public class TArticle {

    @ALa("编号")
    @AId(auto = true)
    private Integer id;

    @ALa("寺院编号")
    private Integer templeId;

    @ALa("文章标题")
    @AColumn(len = 409600)
    private String title;

    @ALa("浏览量")
    private Integer hot;

    @ALa("文章内容")
    @AColumn(len = 409600)
    private String content;

    @ALa("来源类型")
    private String sourceType;


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

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
