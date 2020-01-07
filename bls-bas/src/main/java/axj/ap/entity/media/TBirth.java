package axj.ap.entity.media;

import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.crud.an.AUpload;
import axj.crud.upload.AUploadImage;
import axj.db.an.AId;
import axj.valid.an.Required;

@AMenu({@AMenu.Menu("多媒体信息管理"), @AMenu.Menu("诸佛圣诞日")})
public class TBirth {
    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @Required
    @ALa("诸佛名称")
    @AEdit(group = AEdit.List)
    private String name;

    @Required
    @ALa("诞辰")
    @AEdit(group = AEdit.List, type = "dateTime")
    private Integer timestamp;

    @Required
    @ALa("图片")
    @AUploadImage
    @AUpload
    @AEdit(group = AEdit.List)
    private String cover;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
