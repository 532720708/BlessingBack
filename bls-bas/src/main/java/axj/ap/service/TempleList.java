package axj.ap.service;

import axj.ap.dao.TempleDao;
import axj.ap.entity.TEntity;

import java.util.List;

public class TempleList {
    public static List<TEntity> getAllTempleList() {
        return TempleDao.getAllTempleList();
    }

    public static List<TEntity> getTopTempleList(String num) {
        return TempleDao.getTopTempleList(num);
    }

    public static List<TEntity> getTempleListByP(String pid) {
        return TempleDao.getTempleListByP(pid);
    }

    public static List<TEntity> getTempleListById(String id) {
        return TempleDao.getTempleListById(id);
    }
}
