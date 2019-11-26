###开放接口调用签名

####http方式
####一般签名
url paras 需要添加 ?t={time}&p={appId}&s={sign}

参数 | 说明
----|----
time| 时间戳 和服务器时间误差需要在60秒以内
appId| 第三方应用编号
sign| 第三方应用 md5(appSecret + ',' + time) 小写
appSecret| 第三方应用密钥

测试地址 http://139.224.149.225:38081/api

测试应用编号 1

测试应用appSecret l3A44xNwuZ8


正式地址 http://plt.yiyiny.com/api

应用编号 和 密钥联系 平台对接人员

