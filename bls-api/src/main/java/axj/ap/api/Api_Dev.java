package axj.ap.api;

import axj.an.AEnv;
import axj.serv.an.AMapping;
import axj.serv.an.AServer;
import axj.serv.an.BBody;

import java.util.HashMap;
import java.util.Map;

@AEnv
@AServer
@AMapping("api/dev")
@BBody
public class Api_Dev  {

    public Map<String, Object> bless(String text) {
        System.out.println("有了" + text);
        Map<String, Object> rMap = new HashMap<>();
        rMap.put("msg", "接收到了");
        rMap.put("msg1", "接收到了1");
        rMap.put("msg2", "接收到了2");

        return rMap;
    }

    public void none() {
        System.out.println("我是none");
    }
}
