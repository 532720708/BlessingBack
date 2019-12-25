package axj.ap.entity.interactive;

import axj.an.AClass;
import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.valid.an.Required;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户签到数据库 1-1记录
 */
@AMenu({@AMenu.Menu("互动信息管理"), @AMenu.Menu("用户签到记录")})
@AEntity
public class TCheckin {

    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @Required
    @ALa("用户ID")
    @AEdit(group = AEdit.List)
    private Integer userId;

    @Required
    @ALa("签到时间")
    @AEdit(group = AEdit.List)
    private Integer timestamp;

    @Required
    @ALa("签到库")
    @AEdit(group = AEdit.List)
    @JSONField(serialize = false)
    @AClass(TCheck.class)
    private int checkinId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public int getCheckinId() {
        return checkinId;
    }

    public void setCheckinId(int checkinId) {
        this.checkinId = checkinId;
    }
}
