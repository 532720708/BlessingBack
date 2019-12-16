package axj.ap.api;

import axj.an.AEnv;
import axj.ap.entity.TempleEntity;
import axj.ap.service.PrayCommit;
import axj.ap.service.TempleList;
import axj.serv.an.AMapping;
import axj.serv.an.AServer;
import axj.serv.an.BBody;

import java.util.List;

@AEnv
@AServer
@AMapping("api/dev")
@BBody
public class Api_Dev  {

    /*获得全部寺庙列表*/
    public List<TempleEntity> getAllTempleList(){
        return TempleList.getTempleList();
    }

    /*获得热门寺庙列表*/
    public List<TempleEntity> getTopTempleList(int num){
        return TempleList.getTopTempleList(num);
    }

    /*根据省份获得寺庙列表*/
    public List<TempleEntity> getTempleListByP(int pid){
        return TempleList.getTempleListByP(pid);
    }

    /*根据寺庙id获得寺庙列表*/
    public List<TempleEntity> getTempleListById(Integer id){
        return TempleList.getTempleListById(id);
    }

    public void pray(String prayBehaviorString){
        PrayCommit.commit(prayBehaviorString);
    }

}
