package axj.ap.entity.temple;

import axj.an.AClass;
import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.crud.an.AHtml;
import axj.crud.an.AUpload;
import axj.crud.upload.AUploadImage;
import axj.db.an.AColumn;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.valid.an.Required;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 寺庙实体
 */
@AMenu({@AMenu.Menu("寺庙信息管理"), @AMenu.Menu("寺庙列表")})
@AEntity
public class TEntity {

    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @ALa("名称")
    @AEdit(group = AEdit.List)
    private String name;

    @ALa("介绍")
    @AEdit(group = AEdit.List)
    @AHtml
    @AColumn(len = 409600)
    private String desc;

    @ALa("省")
    @AEdit(group = AEdit.List)
    private String province;

    @ALa("市")
    @AEdit(group = AEdit.List)
    private String city;

    @ALa("详细地址")
    @AEdit(group = AEdit.List)
    private String address;

    @ALa("主图")
    @AUploadImage
    @AUpload
    @AEdit(group = AEdit.List)
    private String mImg;

    @ALa("热度")
    @AEdit(group = AEdit.List)
    private Integer hot;

    @ALa("票价")
    @AEdit(group = AEdit.List)
    private Float price;

    @Required
    @ALa("佛像功能")
    @AEdit(group = AEdit.List)
    @JSONField(serialize = false)
    @AClass(TBuddha.class)
    private int[] func;

    @ALa("联系电话")
    @AEdit(group = AEdit.List)
    private String tel;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getmImg() {
        return mImg;
    }

    public void setmImg(String mImg) {
        this.mImg = mImg;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int[] getFunc() {
        return func;
    }

    public void setFunc(int[] func) {
        this.func = func;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
