package axj.ap.entity.media;

import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.crud.an.AUpload;
import axj.crud.upload.AUploadImage;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.db.an.ARefer;
import axj.valid.an.Required;

/**
 * 梵音
 */
@AEdit.EType(order = "id>")
@AMenu({@AMenu.Menu("多媒体信息管理"), @AMenu.Menu("音乐列表")})
@AEntity
public class TMusic {

    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @Required
    @ALa("音乐名称")
    private String name;

    @Required
    @ALa("封面地址")
    @AUploadImage
    @AUpload
    private String cover;

    @Required
    @ALa("音乐地址")
    @AEdit
    @AUpload(exts = "mp3,wma,wav,ogg")
    private String address;

    @ALa("播放次数")
    private Integer count;

    @Required
    @ALa("音乐分类")
    @AEdit(group = AEdit.List)
    @ARefer
    private Integer type;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
