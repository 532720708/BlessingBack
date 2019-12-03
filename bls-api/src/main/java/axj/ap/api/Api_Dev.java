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

    public List<TempleEntity> getTempleList(String location){
        return TempleList.getTempleList();
    }

    public void pray(String prayBehaviorString){
        PrayCommit.commit(prayBehaviorString);
    }

}
