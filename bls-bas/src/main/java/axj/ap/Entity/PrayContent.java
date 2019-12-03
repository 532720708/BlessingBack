package axj.ap.Entity;

import axj.an.ALa;
import axj.db.an.AEntity;
import axj.db.an.AId;

@AEntity
public class PrayContent {

    @ALa("编号")
    @AId(auto = true)
    private Integer id;

    @ALa("祈愿内容")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
