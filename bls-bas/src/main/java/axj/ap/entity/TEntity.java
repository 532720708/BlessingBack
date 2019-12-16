package axj.ap.entity;

import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.db.an.AColumn;
import axj.db.an.AEntity;
import axj.db.an.AId;

/**
 * @Classname Temple
 * @Description
 * @Date 2019/11/26 19:06
 * @Created by Yuan Huanghui
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
    private String title;

    @ALa("介绍")
    @AEdit(group = AEdit.List)
    @AColumn(len = 409600)
    private String desc;

    @ALa("省")
    @AEdit(group = AEdit.List)
//    @ALa("省")
//    @AEdit(group = AEdit.List)
//    @JSONField(serialize = false)
//    @AClass(Prov.class)
    private String province;


    @ALa("市")
    @AEdit(group = AEdit.List)
    private String city;

    @ALa("详细地址")
    @AEdit(group = AEdit.List)
    private String address;

    @ALa("主图")
    private String mImg;

    @ALa("热度")
    private Integer hot;

    @ALa("票价")
    private Float price;

    @ALa("功能")
    private String func;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }
}
