package axj.ap.entity.temple;


import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.valid.an.Required;

@AMenu({@AMenu.Menu("寺庙信息管理"), @AMenu.Menu("佛像列表")})
@AEntity
public class TBuddha {
    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @Required
    @ALa("佛像名称")
    @AEdit(group = AEdit.List)
    private String funcName;

    //此处地址就是佛像对应的一套图片的地址
    @ALa("佛像图片库")
    @AEdit(group = AEdit.List)
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
