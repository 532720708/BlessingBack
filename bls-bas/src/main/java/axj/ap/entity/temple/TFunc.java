package axj.ap.entity.temple;

import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.valid.an.Required;

/**
 * 祈愿功能表
 */
@AMenu({@AMenu.Menu("寺庙信息管理"), @AMenu.Menu("供奉类型")})
@AEntity
public class TFunc {

    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @Required
    @AEdit(group = AEdit.List)
    @ALa("名称")
    private String name;

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
}
