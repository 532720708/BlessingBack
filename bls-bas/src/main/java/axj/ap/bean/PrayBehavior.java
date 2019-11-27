package axj.ap.bean;

import axj.an.ALa;
import axj.db.an.AEntity;

/**
 *
 */
@AEntity()
public class PrayBehavior {

    @ALa("用户编号")
    private Integer userId;

    @ALa("类型")
    private String kind;

    @ALa("名称")
    private String name;

    @ALa("内容")
    private String content;

    @ALa("性别")
    private String gender;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
