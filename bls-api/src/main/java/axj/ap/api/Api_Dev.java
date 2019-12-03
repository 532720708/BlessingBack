package axj.ap.api;

import axj.an.AEnv;
import axj.ap.Entity.TempleEntity;
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
        if(location != null)
            return TempleList.getTempleList(location);
        else
            return TempleList.getTempleList();
    }

    public void pray(String prayBehaviorString){
        PrayCommit.commit(prayBehaviorString);
    }

}
