###开放接口资源下载

资源默认是ut8编码

中文乱码请下载后查看

服务端SDK资源下载

[rpc/java/open.java](./rpc/java/open.java)


服务端SDK使用示例

```

protected static final Logger LOGGER = LoggerFactory.getLogger(PlatformService.class);

    @AValue("plt.id")
    String appId = "1";

    @AValue("plt.secret")
    String appSecret = "l3A44xNwuZ8";

    @AValue("plt.host")
    String host = "http://139.224.149.225:38081/api/";

    open.Api_O rpcOpen;

        protected Object req(String uri, Object postData, Type retCls) {
            String json = null;
            Throwable ex = null;
            try {
                // 获取当前时间(秒时间戳)
                int time = UtContext.sTime();
                // 拼接访问地址和签名
                uri = host + uri + "?t=" + time + "&p=" + appId + "&s=" + KtEncry.md5Str(appSecret + ',' + time);
                // Json.Post请求返回String
                json = KtIo.toString(UtClient.reqJson(UtClient.conn(uri), postData, InputStream.class), null, KtIo.utf8());
                System.out.println(uri + "&<=[\"" + ((Object[]) postData)[0] + "\"]");
                // FastJson 读取返回结果
                JSONReader reader = new JSONReader(new StringReader(json));
                try {
                    reader.startArray();
                    int code = reader.readObject(int.class);
                    if (code == 1) {
                        // 正确的返回值
                        return reader.readObject(retCls);
                    }
    
                } finally {
                    try {
                        if (!reader.hasNext()) {
                            reader.endArray();
                        }
    
                        reader.close();
    
                    } catch (Throwable e) {
                        KtA.throwEx(e);
                    }
                }
    
            } catch (Throwable e) {
                ex = e;
            }
    
            // 记录访问错误日志
            LOGGER.error("req err " + uri + " \r\n" + json, ex);
            // 默认返回, null 转 int, boolean等
            return SBinder.ME.nullTo(retCls);
        }

    @AInject
    protected void init() {
        rpcOpen = new open.Api_O<Object>() {

            @Override
            protected <T> T _req(Object _at, String uri, Object[] paras, Class<T> retCls) {
                return req(uri, paras, retCls);
            }
        };
    }

```

#####项目和平台之间调用代码

#####$onMessage 平台对项目常用通知

方法 | 参数 | 说明
----|----|----
login|token|登录成功后,通知最新的token值

#####$postMessage 项目调用平台方法

方法 | 代码 |作用
----|----|----
login | $postMessage('login') | 调出登录页面
pay | $postMessage('pay', orderId) | 传入订单号,调出支付页面
 
####注册代码
````
// 平台通知
window.$onMessage = {
	login(token) {
		console.log('on Login')
		$root.token = token
	},
}

if (window.parent) {
	window.onmessage = function(e) {
		var e = e.data
		if (typeof(e) === 'string') {
			var i = e.indexOf(',')
			if (i > 0) {
				var d = e.substring(i + 1)
				e = $onMessage[e.substring(0, i)]
				if (e) {
					e(d)
				}

			} else {
				e = $onMessage[e]
				if (e) {
					e()
				}
			}
		}
	}

	window.$postMessage = function(method, data) {
		if (data) {
			method = method + ',' + data
		}

		window.parent.postMessage(method, '*')
	}

} else {
	window.$postMessage = function(method, data) {
		if (data) {
			method = method + ',' + data
		}

		uni.navigateTo({
			url: '/pages/transfer?t=' + encodeURIComponent(method)
		})
	}
}
````
