###如何调用RPC接口
####http方式

#####请求地址
HostUrl + RpcUri

#####请求参数 
[para1, para2, ..., paraN]
````
通过json序列化后，通过postData 或着 ?<= 传值 
````
#####返回结果
 ````
[code, result, pushUri1, pushData1, pushUri2, pushUri2, ..., pushUriN, pushDataN]
以上结构的json序列化
 ````
字段 | 说明
----|----
code | 返回值1 为正常
result | code为1时为正常返回值，其他情况为错误详细对象
pushUri | 多返回状态时，推送Rpc的RpcUri
pushData | 多返回状态时，推送Rpc的Paras 一维数组结构

#####示例

```` 
HostUrl = "http://127.0.0.1:8787/api/"
Class Api_Test {
    //RpcUri = "Test/hello"
    int hello(string name, int type) {
        return type + name.length;
    }
}

调用一(只能用于测试，正式环境不支持)
get请求
Url: http://127.0.0.1:8787/api/Test/hello?<=['abc', 1]
返回字符串结果为 [1, 4]

调用二
post请求
Url: http://127.0.0.1:8787/api/Test/hello
PostData: ['abc', 2]
返回字符串结果为 [1, 5]
````

#####返回错误码
编号 |名称 | 说明
----|----|----
0 | IN_FAIL | 请求失败
200 | ON_SUCCESS | 处理成功
201 | ON_CODE | 处理Code
204 | ON_DELETED | 已删除
205 | ON_FAIL | 处理失败
220 | NO_USER | 没有用户
221 | NO_VALID | 验证失败
222 | ON_TIMEOUT | 处理超时
304 | ON_DENIED | 没有权限
400 | ON_ERROR | 处理出错
402 | NO_LOGIN | 用户未登陆
403 | ON_FORBIDDEN | 禁止访问
404 | IN_404 | 资源不存在
405 | NO_METHOD | 方法不被允许
437 | NO_PARAM | 缺少参数

