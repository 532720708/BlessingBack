package axj.ap.service;

import axj.ap.entity.TempleEntity;
import axj.ap.dao.TempleDao;

import java.util.List;

public class TempleList {
    public static List<TempleEntity> getTempleList() {
        return TempleDao.getTempleList();
    }

    public static List<TempleEntity> getTopTempleList(int num) {
        return TempleDao.getTopTempleList(num);
    }

    public static List<TempleEntity> getTempleListByP(int pid) {
        return TempleDao.getTempleListByP(pid);
    }

    public static List<TempleEntity> getTempleListByLoc(String location) {
        return TempleDao.getTempleListByLoc(location);
    }

    public static List<TempleEntity> getTempleListById(Integer id) {
        return TempleDao.getTempleListById(id);
    }
}
