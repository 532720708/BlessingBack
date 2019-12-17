package axj.ap.api;

import axj.an.AEnv;
import axj.ap.dao.Spider;
import axj.ap.entity.TArticle;
import axj.ap.entity.TCity;
import axj.ap.entity.TEntity;
import axj.ap.entity.TScripture;
import axj.ap.service.Loader;
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
public class Api_Dev {

    /**
     * http://127.0.0.1:8787/api/dev/spiderDemo/江苏省/南京市/
     *
     * @param sheng
     * @param shi
     * @param qu
     */
    public void spiderDemo(String sheng, String shi, String qu) {
        System.err.println("============================" + sheng);
        Spider.spiderDemo(sheng, shi, qu);
    }

    public void traverse() throws InterruptedException {
        Spider.traverse();
    }

    /**
     * 获得全部寺庙列表
     *
     * @return
     */
    public List<TEntity> getAllTempleList() {
        return TempleList.getAllTempleList();
    }

    /**
     * 获得热门寺庙列表
     *
     * @param num 需要获得的个数
     * @return
     */
    public List<TEntity> getTopTempleList(String num) {
        return TempleList.getTopTempleList(num);
    }

    /**
     * 根据省份获得寺庙列表
     *
     * @param pid 省份id
     * @return
     */
    public List<TEntity> getTempleListByP(String pid) {
        return TempleList.getTempleListByP(pid);
    }

    /**
     * 根据寺庙id获得寺庙
     *
     * @param id 寺庙id
     * @return
     */
    public List<TEntity> getTempleListById(String id) {
        return TempleList.getTempleListById(id);
    }

    /**
     * 加载城市
     *
     * @return
     */
    public List<TCity> getCity() {
        return Loader.getCity();
    }

    //获得文章
    public List<TArticle> getAllArticle() {
        return Loader.getAllArticle();
    }

    public List<TArticle> getArticleById(String id) {
        return Loader.getArticleById(id);
    }

    /*获得佛经*/
    public List<TScripture> getAllScripture() {
        return Loader.getAllScripture();
    }

    public List<TScripture> getScriptureById(String id) {
        return Loader.getScriptureById(id);
    }

    public void pray(String prayBehaviorString) {
        PrayCommit.commit(prayBehaviorString);
    }

}
