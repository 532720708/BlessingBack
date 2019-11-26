####开放平台
1、第三方项目只需要对接平台sdk， 即可发布Android版，iOS版, 微信公众号网页， 微信小程序， H5+网页，
(支付宝小程序版,百度小程序版,头条小程序版) 等多个平台。

2、平台提供了统一的账户，统一订单支付，推送等开发接口方便和第三方项目对接
                                          

####开发项目入口添加
[入口地址](http://plt.test.yiyitop.com/plt-demo/#/)

自定义项目名称和入口链接，点击添加或扫码添加自定义项目，也可以点击或扫码删除项目

[平台demo项目参考](https://gitee.com/absir_admin/plt-demo)

####SDK提供方法

uniReady uni环境准备好了，安全调用
使用示例
```
uniReady(function() {
    $postMessage('login', 1)
})
```

uniConsole 打开vConsole调试， sdk提供vConsole，方便app上开发调试
使用示例
```
uniConsole()
```

####H5项目开发
h5项目需要引用js资源
[plt_sdk.js](http://plt.test.yiyitop.com/plt-demo/static/open.plt.0.1.js)

#####调用平台 方法
$postMessage(method, data)

第三方项目登录，也支持免登录账户互通机制，[请参考](#/proj/open?f=0_2)

方法 | 参数说明
----|----
$abAct | 最新支持回调逻辑方法， 简化项目接入难度，推荐使用
login| 调起登录
pay | 调用支付，参数平台订单号 [统一下单](#proj/open/?u=O/order) [支付通知](#/proj/open?f=0_4)
share | 调取分享， 传入json字符串(增加imageUrlB为显示图片) [参数参考](https://uniapp.dcloud.io/api/plugins/share?id=share) provider不传,回调为平台回调通知shareOk shareFail
shareReg | 调取分享注册， 传入share方法相似参数，改参数多一个reg注册属性
zhibo | 调取直播, 传入直播房间号
zhan | 调取直播, 传入直播编号(,直播房间名)
$uniAct | uni方法平台代理 传入代理方法名， 传入代理参数 (scanCodeP 为扫一扫增强， success 直接返回结果)
backPressOn | 监听backPress事件， 传入1或0 代表是否监听,  传入2 是系统默认监听， 执行history.back() 默认返回， 新sdk默认初始化状态是2
backHome | 返回首页
backProj | 退出项目
help | 客服页面， 传入参数为七鱼 自定义参数JSON序列化， 参考 JSON.stringify([{'index': 1,'key': 'tag','label': '测试标签','value': '测试值Test'}])


###平台SDK载入是异步，平台 初始化等待方法 需要用 uniReady回调

示例
```
uniReady(function() {
    console.log('平台SDK载入成功')
    
    // 可以获取当前平台账号登录状态
    $abAct('token', 0, function(err, token) {
              console.log("loginAct err = " + err)
              console.log("loginAct back = " + token)
              if(!token) {
                // 如果项目需要强制登录
                $abAct('login', 0, function(err, token) {
                // 通过返回token 判断用户是否执行登录， 强制登录， token无效可以再次调起该方法
                          console.log("loginAct err = " + err)
                          console.log("loginAct back = " + token)
                        })
              }
              
            })
    
})
```


```
$abAct 支持示例

        token回调 
        获取当前平台token
$abAct('token', 0, function(err, token) {
          console.log("loginAct err = " + err)
          console.log("loginAct back = " + token)
        })

        登录回调 
        参数传0平台不需要检测token失效，传1需要检测token失效
$abAct('login', 0, function(err, token) {
          console.log("loginAct err = " + err)
          console.log("loginAct back = " + token)
        })
        
        分享回调|分享邀请 参数同$postMessage share|shareReg 方法 特殊支持type参数 通过平台配置分享邀新引导页
$abAct('shareReg', JSON.stringify({}), function(err, succ) {
          console.log("shareReg err = " + err)
          console.log("shareReg back = " + token)
        })
        
        支付回调
$abAct('pay', res, function(err, succ) {
              console.log("pay err = " + err)
              console.log("pay back = " + token)
            })
            
        选择收货地址回调
        $abAct('address', 0, function(err, token) {
                      console.log("address err = " + err)
                      console.log("address back = " + token)
                    })
                    
         默认收货地址（定位）生鲜 外卖类           
         addrCurrAct() {
                            $abAct('addressCurr', 1, function(err, token) {
                              console.log("address err = " + err)
                              console.log("address back = " + JSON.stringify(token))
                            })
                          },
         
         默认收货地址（不定位）普通电商 快递发货类                    
         addrCurrAct2() {
                            $abAct('addressCurr', 2, function(err, token) {
                              console.log("address err = " + err)
                              console.log("address back = " + JSON.stringify(token))
                            })
                          },
                          
                          
        /**
                 * 上传资源 演示
                 */
                $abAct('upload', JSON.stringify({
                  // 1 只是视频 2 只是图片
                  type: 0,
                  // 二级分类（行业分类）
                  catId2: 0,
                  // 三级分类 （20个模块分类）
                  catId3: 0,
        
                }), function(err, article) {
                  console.log("upload err = " + err)
                  console.log("upload back = " + JSON.stringify(article))
                })                  

        // 全屏切换
        var self = this
        $abAct('fullScreen', self.fullScreen ? -1 : 1,
          function(err, topBar) {
            self.fullScreen = !self.fullScreen
            console.log('topBar = ' + topBar)
          })


```

```
定位api代理示例
$uniAct('getLocation', {
          altitude: true,
          success: function() {
            console.log('getLocation success')
          },
          fail: function() {
            console.log('getLocation fail')
          },
          complete: function() {
            console.log('getLocation complete')
          },
        })
```

```

调取分享注册使用示例

shareReg reg结构参数

    class DReg {
        // 邀请人编号（系统自动关联， 不需要指定）
        public int mmId;
        // 通知类型 (需要联系我们，注册后台通知地址获取)
        public String notify;
        // 参数 (用户注册成功，平台会回调给注册地址)
        public String para;
        // 登录跳转地址
        public String uri;
        // 注册完成引导下载 提示问题（只做客户端逻辑）
        public String appName;
    }
        
        
    
    
    $postMessage('shareReg', JSON.stringify({
        imageUri: 'xxx',
        title: 'xxx',
        xxxx...
        reg: {
            notify: 'yyshop', // 可不传 注册成功通知服务器类型
            para: 'xxx', // 可不传 注册成功通知服务器 透传参数
            uri: 'xxx', // 可不传 可不传， 绑定千人千面 注册成功后 跳转地址
            _uri: 'xxx', // 可不传， 不绑定千人千面， 注册成功后 临时跳转地址
        }
    }))
    
    
    注册服务通知 post.json请求 
    {
        id: 会员编号,
        para： 注册参数透传
    }
```


平台回调通知 注册方法
window.$onMessage = {
    method(data) {
        自定义处理
    }
}

示例
```
function(err, res) {
				// self.err_ += $postMessage
				// uni.navigateTo({
				// 	url: '/pages/transfer?t=pay,' + res
				// })
				if (res) {
					$postMessage('pay', res)
				}
			}
```

#####平台回调通知 注册方法 （全局， 项目只能注册一处回调）
window.$onMessage = {
    method(data) {
        自定义处理
    }
}

回调方法 | 参数说明
----|----
uniReady | uni环境准备完毕，通过window.$evn 和大平台的通讯最好在 uniReady后调用
login| 登录成功回调， 参数平台token [会员接口](#proj/open/?u=O/member) [平台授权查询接口](#proj/open/?u=O/oauth)
wxReady | 微信环境，准备完毕
shareOk | 分享成功
shareFail | 分享失败
onBackPress | 返回按钮点击通知
onHide | 项目隐藏
onShow | 项目显示


示例
```
// 自定义消息处理
window.$onMessage = {
	login(v) {
		console.log('login at ' + v)
		$root.token = v
	}
}
```

app上如何调试

打开调试地址 [demo](https://plt.test.yiyitop.com/plt-demo/#/)

1、扫码添加项目

2、扫码打开开发设置页面

3、打开vConsole



