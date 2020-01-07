package axj.ap.entity.media;

import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.crud.an.AHtml;
import axj.db.an.AColumn;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.valid.an.Required;

@AMenu({@AMenu.Menu("多媒体信息管理"), @AMenu.Menu("佛教资讯")})
@AEntity
public class TBuddhistArticle {
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
    @ALa("发表时间")
    @AEdit(group = AEdit.List, type = "dateTime")
    private Integer timestamp;

    @Required
    @ALa("是否推荐")
    @AEdit(group = AEdit.List)
    private boolean recommend;

}
