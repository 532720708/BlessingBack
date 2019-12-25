package axj.ap.api;

import axj.an.AEnv;
import axj.ap.dao.Spider;
import axj.ap.entity.TCity;
import axj.ap.entity.media.TAd;
import axj.ap.entity.media.TArticle;
import axj.ap.entity.media.TScripture;
import axj.ap.entity.temple.TEntity;
import axj.ap.service.Loader;
import axj.ap.service.PrayCommit;
import axj.ap.service.Searcher;
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
     */
    public List<TEntity> getAllTempleList() {
        return TempleList.getAllTempleList();
    }

    /**
     * 获得热门寺庙列表
     *
     * @param num 需要获得的个数
     */
    public List<TEntity> getTopTempleList(String num) {
        return TempleList.getTopTempleList(num);
    }

    /**
     * 根据省份获得寺庙列表
     *
     * @param pid 省份id
     */
    public List<TEntity> getTempleListByP(String pid) {
        return TempleList.getTempleListByP(pid);
    }

    /**
     * 根据寺庙id获得寺庙
     *
     * @param id 寺庙id
     */
    public List<TEntity> getTempleListById(String id) {
        return TempleList.getTempleListById(id);
    }

    /**
     * 加载城市
     */
    public List<TCity> getCity() {
        return Loader.getCity();
    }

    /**
     * 获得文章
     */
    public List<TArticle> getArticle() {
        return Loader.getArticle();
    }

    public List<TArticle> getArticle(String id) {
        return Loader.getArticle(id);
    }

    /**
     * 获得佛经
     */
    public List<TScripture> getScripture() {
        return Loader.getScripture();
    }

    public List<TScripture> getScripture(String id) {
        return Loader.getScripture(id);
    }

    /**
     * 搜索
     *
     * @return List第一个是temple的JSON，第二个是佛经的JSON
     */
    public List<String> search(String str) {
        return Searcher.getSearchResult(str);
    }

    public void pray(String prayBehaviorString) {
        PrayCommit.commit(prayBehaviorString);
    }

    /**
     * 获得轮播广告
     *
     * @return
     */
    public List<TAd> getAd() {
        return Loader.getAd();
    }

    public List<TAd> getAd(int num) {
        return Loader.getAd(num);
    }

}
