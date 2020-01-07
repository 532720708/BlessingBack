package axj.ap.entity.media;

import axj.an.AClass;
import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.crud.an.AUpload;
import axj.crud.upload.AUploadImage;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.valid.an.Required;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 视频
 */
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
    @AEdit(group = AEdit.List)
    private String cover;

    @Required
    @ALa("视频地址")
    @AUpload(exts = "mp4,flv,ogg")
    @AEdit(group = AEdit.List)
    private String address;

    @ALa("播放次数")
    @AEdit(group = AEdit.List)
    private Integer count;

    @Required
    @ALa("音乐分类")
    @AEdit(group = AEdit.List)
    @JSONField(serialize = false)
    @AClass(TVideoCat.class)
    private int[] vedeoCatId;

    @Required
    @ALa("上传时间")
    @AEdit(group = AEdit.List, type = "dateTime")
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

    public int[] getVedeoCatId() {
        return vedeoCatId;
    }

    public void setVedeoCatId(int[] vedeoCatId) {
        this.vedeoCatId = vedeoCatId;
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
