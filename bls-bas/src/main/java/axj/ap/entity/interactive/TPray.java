package axj.ap.entity.interactive;

import axj.an.AClass;
import axj.an.ALa;
import axj.an.AMenu;
import axj.ap.entity.temple.TBuddha;
import axj.ap.entity.temple.TEntity;
import axj.ap.entity.temple.TWorship;
import axj.crud.an.AEdit;
import axj.db.an.AColumn;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.valid.an.Required;

/**
 * 祈福编号
 */
@AMenu({@AMenu.Menu("互动信息管理"), @AMenu.Menu("用户祈福记录")})
@AEntity
public class TPray {

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
    @ALa("祈福内容")
    @AColumn(len = 409600)
    @AEdit(group = AEdit.List)
    private String content;

    @ALa("寺庙")
    @Required
    @AEdit(group = AEdit.List)
    @AClass(TEntity.class)
    private int tEntity;

    @ALa("佛像")
    @Required
    @AEdit(group = AEdit.List)
    @AClass(TBuddha.class)
    private int tBuddha;

    @Required
    @ALa("供奉")
    @AEdit(group = AEdit.List)
    @AClass(TWorship.class)
    private int[] worship;

    public int gettEntity() {
        return tEntity;
    }

    public void settEntity(int tEntity) {
        this.tEntity = tEntity;
    }

    public int gettBuddha() {
        return tBuddha;
    }

    public void settBuddha(int tBuddha) {
        this.tBuddha = tBuddha;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getEntity() {
        return tEntity;
    }

    public void setEntity(int tEntity) {
        this.tEntity = tEntity;
    }

    public int getBuddha() {
        return tBuddha;
    }

    public void setBuddha(int tBuddha) {
        this.tBuddha = tBuddha;
    }

    public void setWorship(int[] worship) {
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

    public int[] getWorship() {
        return worship;
    }
}
