package axj.ap.entity;

import axj.an.ALa;
import axj.an.AMenu;
import axj.db.an.AEntity;

/**
 *
 */
@AEntity()
public class Pray {

    @ALa("编号")
    private Integer id;

    @ALa("类型")
    private String kind;

    @ALa("名称")
    private String name;

    @ALa("内容")
    private String content;

    @ALa("性别")
    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
