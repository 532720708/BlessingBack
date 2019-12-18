package axj.ap.entity;

import axj.an.ALa;
import axj.db.an.AEntity;
import axj.db.an.AId;

/**
 *
 */
@AEntity()
public class PrayBehavior {

    @ALa("行为编号")
    @AId(auto = true)
    private Integer id;

    @ALa("用户编号")
    private Integer userId;

    @ALa("寺庙名称")
    private String name;

    @ALa("祈愿类型")
    private String kind;

    @ALa("内容")
    private String content;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
