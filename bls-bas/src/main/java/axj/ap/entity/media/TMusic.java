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
 * 梵音
 */
@AMenu({@AMenu.Menu("多媒体信息管理"), @AMenu.Menu("音乐列表")})
@AEntity
public class TMusic {

    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @Required
    @ALa("音乐名称")
    @AEdit(group = AEdit.List)
    private String name;

    @Required
    @ALa("封面图片")
    @AUploadImage
    @AUpload
    @AEdit(group = AEdit.List)
    private String cover;

    @Required
    @ALa("音乐文件")
    @AEdit(group = AEdit.List)
    @AUpload(exts = "mp3,wma,wav,ogg")
    private String address;

    @ALa("播放次数")
    @AEdit(group = AEdit.List)
    private Integer count;

    @Required
    @ALa("音乐分类")
    @AEdit(group = AEdit.List)
    @JSONField(serialize = false)
    @AClass(TMusicCat.class)
    private int[] musicCatId;

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

    public int[] getMusicCatId() {
        return musicCatId;
    }

    public void setMusicCatId(int[] musicCatId) {
        this.musicCatId = musicCatId;
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
