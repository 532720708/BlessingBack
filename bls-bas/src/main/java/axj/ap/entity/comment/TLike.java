package axj.ap.entity.comment;

import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.db.an.AEntity;
import axj.db.an.AId;

@AMenu({@AMenu.Menu("评论信息管理"), @AMenu.Menu("点赞列表")})
@AEntity
public class TLike {
    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @ALa("点赞对象id")
    @AEdit(group = AEdit.List)
    private Integer typeId;

    @ALa("点赞对象类型")
    @AEdit(group = AEdit.List)
    private Integer type;

    @ALa("用户Id")
    @AEdit(group = AEdit.List)
    private Integer userId;

    @ALa("状态")
    @AEdit(group = AEdit.List)
    private Integer status;

    @ALa("最后更新时间")
    @AEdit(group = AEdit.List)
    private Integer timestamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }
}
