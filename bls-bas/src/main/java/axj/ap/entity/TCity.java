package axj.ap.entity;

import axj.an.ALa;
import axj.crud.an.AEdit;
import axj.db.an.AEntity;
import axj.db.an.AId;

@AEntity
public class TCity {
    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @ALa("省份编号")
    private Integer pid;

    @ALa("城市名称")
    private String cityname;

    @ALa("类型")
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
