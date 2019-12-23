package axj.ap.entity.temple;

import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.db.an.AEntity;
import axj.db.an.AId;

/**
 * 祈愿功能表
 */
@AMenu({@AMenu.Menu("寺庙信息管理"), @AMenu.Menu("寺庙供奉列表")})
@AEntity
public class TFunc {

    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @ALa("供奉名称")
    private String funcName;

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
}
