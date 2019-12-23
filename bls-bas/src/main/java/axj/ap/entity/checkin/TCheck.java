package axj.ap.entity.checkin;

import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.db.an.AEntity;
import axj.db.an.AId;

/**
 * 签到库
 */
@AMenu({@AMenu.Menu("签到信息管理"), @AMenu.Menu("签到库")})
@AEntity
public class TCheck {
    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @ALa("签到图片")
    private String image;

    @ALa("签到内容")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
