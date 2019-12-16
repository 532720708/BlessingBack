package axj.ap.entity;


import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.db.an.AEntity;
import axj.db.an.AId;

/**
 * 每个寺庙的功能 1-1插入数据库
 */
@AMenu({@AMenu.Menu("寺庙信息管理"), @AMenu.Menu("寺庙功能列表")})
@AEntity
public class TIdFunc {

    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @ALa("寺庙id")
    @AEdit(group = AEdit.List)
    private Integer tempId;

    @ALa("功能id")
    @AEdit(group = AEdit.List)
    private Integer funcId;

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public Integer getFuncId() {
        return funcId;
    }

    public void setFuncId(Integer funcId) {
        this.funcId = funcId;
    }
}
