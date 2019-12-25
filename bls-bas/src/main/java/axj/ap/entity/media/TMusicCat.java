package axj.ap.entity.media;


import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.valid.an.Required;

/**
 *
 */
@AMenu({@AMenu.Menu("多媒体信息管理"), @AMenu.Menu("音乐分类管理")})
@AEntity
public class TMusicCat {

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
