package axj.ap.entity.interactive;

import axj.an.ALa;
import axj.an.AMenu;
import axj.ap.entity.temple.TBuddha;
import axj.ap.entity.temple.TEntity;
import axj.ap.entity.temple.TWorship;
import axj.crud.an.AEdit;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.db.an.ARefer;
import axj.valid.an.Required;

/**
 * 祈福编号
 */
@AMenu({@AMenu.Menu("互动信息管理"), @AMenu.Menu("用户祈福记录")})
@AEntity
public class PrayBehavior {

    @ALa("祈福编号")
    @AId(auto = true)
    private Integer id;

    @ALa("用户编号")
    @AEdit(group = AEdit.List)
    private Integer userId;

    @ALa("时间")
    @AEdit(group = AEdit.List)
    private Integer prayTime;

    @ALa("是否还愿")
    @AEdit(group = AEdit.List)
    private Integer wishTime;

    @Required
    @ALa("寺庙")
    @AEdit(group = AEdit.List)
    @ARefer
    private TEntity tEntity;

    @Required
    @ALa("佛像")
    @AEdit(group = AEdit.List)
    @ARefer
    private TBuddha tBuddha;

    @Required
    @ALa("供奉")
    @AEdit(group = AEdit.List)
    @ARefer
    private TWorship worship;

    public TEntity gettEntity() {
        return tEntity;
    }

    public void settEntity(TEntity tEntity) {
        this.tEntity = tEntity;
    }

    public TBuddha gettBuddha() {
        return tBuddha;
    }

    public void settBuddha(TBuddha tBuddha) {
        this.tBuddha = tBuddha;
    }

    public void setWorship(TWorship worship) {
        this.worship = worship;
    }

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

    public TWorship getWorship() {
        return worship;
    }
}
