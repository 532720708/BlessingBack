package axj.ap.entity.interactive;

import axj.an.AClass;
import axj.an.ALa;
import axj.an.AMenu;
import axj.ap.entity.temple.TBuddha;
import axj.crud.an.AEdit;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.valid.an.Required;
import com.alibaba.fastjson.annotation.JSONField;

@AMenu({@AMenu.Menu("互动信息管理"), @AMenu.Menu("用户祈福快捷语")})
@AEntity
public class TPrayContent {

    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @Required
    @AEdit(group = AEdit.List)
    @ALa("名称")
    private String name;

    @Required
    @ALa("对应佛像")
    @AEdit(group = AEdit.List)
    @JSONField(serialize = false)
    @AClass(TBuddha.class)
    private int buddha;

    public int getBuddha() {
        return buddha;
    }

    public void setBuddha(int buddha) {
        this.buddha = buddha;
    }

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
