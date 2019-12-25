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
 * 视频
 */
@AEdit.EType(order = "id>")
@AMenu({@AMenu.Menu("多媒体信息管理"), @AMenu.Menu("视频列表")})
@AEntity
public class TVideo {

    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @Required
    @ALa("视频名称")
    @AEdit(group = AEdit.List)
    private String name;

    @Required
    @ALa("封面地址")
    @AUploadImage
    @AUpload
    private String cover;

    @Required
    @ALa("视频地址")
    @AEdit
    @AUpload(exts = "mp4,flv,ogg")
    private String address;

    @ALa("播放次数")
    @AEdit(group = AEdit.List)
    private Integer count;

    @Required
    @ALa("视频分类")
    @AEdit(group = AEdit.List)
    @ARefer
    private TVideoCat type;

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

    public TVideoCat getType() {
        return type;
    }

    public void setType(TVideoCat type) {
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
