package axj.ap.api;

import axj.an.AEnv;
import axj.ap.bean.PrayBehavior;
import axj.ap.bean.Temple;
import axj.ap.service.PrayCommit;
import axj.ap.service.TempleList;
import axj.serv.an.AMapping;
import axj.serv.an.AServer;
import axj.serv.an.BBody;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AEnv
@AServer
@AMapping("api/dev")
@BBody
public class Api_Dev  {

    public List<Temple> getTempleList(String location){
        if(location != null)
            return TempleList.getTempleList(location);
        else
            return TempleList.getTempleList();
    }

    public void pray(String prayBehaviorString){
        PrayCommit.commit(prayBehaviorString);
    }

}
