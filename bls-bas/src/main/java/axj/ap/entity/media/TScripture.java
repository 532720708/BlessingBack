package axj.ap.entity.media;

import axj.an.ALa;
import axj.an.AMenu;
import axj.crud.an.AEdit;
import axj.crud.an.AHtml;
import axj.db.an.AColumn;
import axj.db.an.AEntity;
import axj.db.an.AId;
import axj.db.an.ARefer;
import axj.valid.an.Required;

/**
 * 佛经
 */
@AMenu({@AMenu.Menu("多媒体信息管理"), @AMenu.Menu("佛经列表")})
@AEntity
public class TScripture {

    @ALa("编号")
    @AId(auto = true)
    @AEdit(meta = "width:100")
    private Integer id;

    @Required
    @ALa("佛经名称")
    @AEdit(group = AEdit.List)
    private String name;

    @Required
    @ALa("原文")
    @AHtml
    @AColumn(len = 409600)
    private String original;

    @ALa("译文")
    @AHtml
    @AColumn(len = 409600)
    private String translation;

    @Required
    @ALa("佛经分类")
    @AEdit(group = AEdit.List)
    @ARefer
    private TVideoCat type;

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

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
