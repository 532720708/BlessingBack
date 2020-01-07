package axj.ap.entity.media;

import axj.an.AClass;
import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.valid.an.Required;
import com.alibaba.fastjson.annotation.JSONField;

@AMenu({@AMenu.Menu("多媒体信息管理"), @AMenu.Menu("评论列表")})
@AEntity
public class TComment {

    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @Required
    @ALa("用户id")
    @AEdit(group = AEdit.List)
    private Integer userId;

    @Required
    @ALa("发表时间")
    @AEdit(group = AEdit.List, type = "dateTime")
    private Integer timestamp;

    @Required
    @ALa("内容")
    @AEdit(group = AEdit.List)
    private String content;

    @Required
    @ALa("回复数")
    @AEdit(group = AEdit.List)
    private int commentCount;

    @Required
    @ALa("点赞数")
    @AEdit(group = AEdit.List)
    private int likeCount;

    @Required
    @ALa("评论对象")
    @AEdit(group = AEdit.List)
    @JSONField(serialize = false)
    @AClass(TCommentType.class)
    private int[] commentType;

}
