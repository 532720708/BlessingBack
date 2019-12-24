package axj.ap.entity;

import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.crud.an.AUpload;
import axj.crud.upload.AUploadImage;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.valid.an.Required;

@AMenu({@AMenu.Menu("轮播")})
@AEntity
public class TAd {
    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @Required
    @ALa("广告名称")
    private String name;

    @Required
    @ALa("广告图片")
    @AUploadImage
    @AUpload
    private String image;

    @Required
    @ALa("广告超链接")
    private String url;

    @Required
    @ALa("插入时间")
    private Integer timestamp;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }
}
