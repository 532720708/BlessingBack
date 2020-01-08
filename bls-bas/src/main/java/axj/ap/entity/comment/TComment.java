package axj.ap.entity.comment;

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
    private String id;

    @Required
    @ALa("用户id")
    @AEdit(group = AEdit.List)
    private Integer userId;

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
    @ALa("评论对象类型")
    @AEdit(group = AEdit.List)
    @JSONField(serialize = false)
    @AClass(TCommentType.class)
    private int cmtType;

    @Required
    @ALa("评论对象id")
    @AEdit(group = AEdit.List)
    private Integer cmtObjId;

    @Required
    @ALa("发表时间")
    @AEdit(group = AEdit.List, type = "dateTime")
    private Integer timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCmtType() {
        return cmtType;
    }

    public void setCmtType(int cmtType) {
        this.cmtType = cmtType;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getCmtObjId() {
        return cmtObjId;
    }

    public void setCmtObjId(Integer cmtObjId) {
        this.cmtObjId = cmtObjId;
    }
}
