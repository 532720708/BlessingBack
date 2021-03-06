package axj.ap.api;

import axj.an.AEnv;
import axj.ap.dao.Spider;
import axj.ap.entity.TCity;
import axj.ap.entity.interactive.TPray;
import axj.ap.entity.interactive.TPrayContent;
import axj.ap.entity.media.*;
import axj.ap.entity.temple.TEntity;
import axj.ap.service.Loader;
import axj.ap.service.Prayer;
import axj.ap.service.Searcher;
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
        return Loader.getAllTempleList();
    }

    /**
     * 获得热门寺庙列表
     *
     * @param num 需要获得的个数
     */
    public List<TEntity> getTopTempleList(String num) {
        return Loader.getTopTempleList(num);
    }

    /**
     * 根据省份获得寺庙列表
     *
     * @param pid 省份id
     */
    public List<TEntity> getTempleListByP(String pid) {
        return Loader.getTempleListByP(pid);
    }

    /**
     * 根据寺庙id获得寺庙
     *
     * @param id 寺庙id
     */
    public List<TEntity> getTempleListById(Integer id) {
        return Loader.getTempleListById(id);
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

    /**
     * 根据id获得文章
     *
     * @param id
     * @return
     */
    public List<TArticle> getArticle(Integer id) {
        return Loader.getArticle(id);
    }

    /**
     * 获得佛经
     */
    public List<TScripture> getScripture() {
        return Loader.getScripture();
    }

    /**
     * 根据id获得佛经
     *
     * @param id
     * @return
     */
    public List<TScripture> getScripture(Integer id) {
        return Loader.getScripture(id);
    }

    /**
     * 搜索
     *
     * @return List第一个是temple的JSON，第二个是佛经的JSON
     */
    public List<Object> search(String str) {
        return Searcher.getSearchResult(str);
    }

    /**
     * 获得轮播广告
     *
     * @return
     */
    public List<TAd> getAd() {
        return Loader.getAd();
    }

    /**
     * 根据数量获得轮播广告
     *
     * @param num
     * @return
     */
    public List<TAd> getAd(int num) {
        return Loader.getAd(num);
    }

    /**
     * 获得默认的祈福语
     *
     * @param buddhaId 佛像id
     * @param n        祈福语条数
     * @return
     */
    public List<TPrayContent> getDefaultPrayContent(Integer buddhaId, Integer n) {
        return Prayer.getDefaultPrayContent(buddhaId, n);
    }

    /**
     * 祈福
     *
     * @param str 祈祷行为JSON，带装了1个TPray的JSONObject，具体KV看wish()方法
     */
    public void wish(String str) {
        Prayer.wish(str);
    }

    /**
     * 还愿
     *
     * @param str 历史记录JSON,带装了多个JSONObject的JSONArray
     *            每个JSONObject只需带getPrayHistory的主键和timestamp
     *            具体KV看backWish()方法
     */
    public void backWish(String str) {
        Prayer.backWish(str);
    }


    /**
     * 获得用户pray记录
     *
     * @param userId
     * @return
     */
    public List<TPray> getPrayHistory(Integer userId) {
        return Loader.getPrayHistory(userId);
    }

    /**
     * 根据时间获得诸佛圣诞日
     *
     * @param timestamp 根据timestamp前后一个月选出n个
     * @return
     */
    public List<TBirth> getBirth(Integer timestamp, Integer n) {
        return Loader.getBirth(timestamp, n);
    }

    /**
     * 获得全部诸佛圣诞日
     *
     * @return
     */
    public List<TBirth> getBirth() {
        return Loader.getBirth();
    }

    /**
     * 根据时间获得佛学文章，用于首页轮播
     *
     * @param count
     * @return
     */
    public List<TBuddhistArticle> getBuddhistArticle(int count) {
        return Loader.getBuddhistArticle(count);
    }

    /**
     * 获得全部佛学文章
     *
     * @param
     * @return
     */
    public List<TBuddhistArticle> getBuddhistArticle() {
        return Loader.getBuddhistArticle();
    }

    /**
     * 获取评论
     *
     * @param cmtType  评论对象类型ID
     * @param cmtObjId 评论对象具体ID
     * @param need     是否需要跟回复 1要0不要
     * @return
     */
    public List<Object> getComment(String cmtType, String cmtObjId, Integer need) {
        return Loader.getCommentList(cmtType, cmtObjId, need);
    }

}
