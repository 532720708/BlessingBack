package axj.ap.entity;

import axj.an.ALa;
import axj.db.an.AEntity;
import axj.db.an.AId;

@AEntity
public class TempleFunc  {

    @ALa("编号")
    @AId(auto = true)
    private Integer id;

    @ALa("祈愿功能名称")
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
