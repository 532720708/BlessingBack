package axj.ap.entity;

import axj.an.ALa;
import axj.ap.api.People;
import axj.ap.bean.PrayBehavior;
import axj.ap.service.PrayCommit;
import axj.db.OSess;
import axj.db.an.AEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@AEntity
public class Prayer implements People {

    @ALa("用户编号")
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public void Pray() {

    }
}
