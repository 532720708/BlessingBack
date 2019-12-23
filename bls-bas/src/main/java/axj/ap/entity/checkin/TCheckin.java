package axj.ap.entity.checkin;

import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.db.an.AEntity;
import axj.db.an.AId;

/**
 * 用户签到数据库 1-1记录
 */
@AMenu({@AMenu.Menu("签到信息管理"), @AMenu.Menu("用户签到记录")})
@AEntity
public class TCheckin {

    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @ALa("用户ID")
    private Integer userId;

    @ALa("签到时间")
    private Integer timestamp;

    @ALa("签号id")
    private Integer checkinId;

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

    public Integer getCheckinId() {
        return checkinId;
    }

    public void setCheckinId(Integer checkinId) {
        this.checkinId = checkinId;
    }
}
