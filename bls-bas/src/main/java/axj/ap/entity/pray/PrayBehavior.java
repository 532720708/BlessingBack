package axj.ap.entity.pray;

import axj.an.ALa;
import axj.an.AMenu;
import axj.db.an.AEntity;
import axj.db.an.AId;

/**
 * 祈福编号
 */
@AMenu({@AMenu.Menu("祈福管理"), @AMenu.Menu("用户祈福记录")})
@AEntity
public class PrayBehavior {

    @ALa("祈福编号")
    @AId(auto = true)
    private Integer id;

    @ALa("用户编号")
    private Integer userId;

    @ALa("寺庙Id")
    private Integer templeId;

    @ALa("佛像选择")
    private String buddhaType;

    //用JSON
    @ALa("供奉")
    private String worship;

    @ALa("时间")
    private Integer prayTime;

    @ALa("是否还愿")
    private Integer wishTime;

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

    public Integer getTempleId() {
        return templeId;
    }

    public void setTempleId(Integer templeId) {
        this.templeId = templeId;
    }

    public String getBuddhaType() {
        return buddhaType;
    }

    public void setBuddhaType(String buddhaType) {
        this.buddhaType = buddhaType;
    }

    public String getWorship() {
        return worship;
    }

    public void setWorship(String worship) {
        this.worship = worship;
    }

    public Integer getPrayTime() {
        return prayTime;
    }

    public void setPrayTime(Integer prayTime) {
        this.prayTime = prayTime;
    }

    public Integer getWishTime() {
        return wishTime;
    }

    public void setWishTime(Integer wishTime) {
        this.wishTime = wishTime;
    }
}
