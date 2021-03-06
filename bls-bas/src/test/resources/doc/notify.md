###开放接口调用签名

支付完成后，平台会把相关支付结果及用户信息通过数据流的形式发送给商户，商户需要接收处理，并按文档规范返回应答。

####注意：
1、同样的通知可能会多次发送给商户系统。商户系统必须能够正确处理重复的通知。

2、后台通知交互时，如果微信收到商户的应答不符合规范或超时，微信会判定本次通知失败，重新发送通知，直到成功为止（在通知一直不成功的情况下，微信总共会发起10次通知，通知频率为15s/15s/30s/3m/10m/20m/30m/30m/30m/60m/3h/3h/3h/6h/6h - 总计 24h4m），但微信不保证通知最终一定能成功。

3、在订单状态不明或者没有收到支付结果通知的情况下，建议商户主动调用支付【查询订单API】确认订单状态。[订单查询](#proj/open/?u=O/orderQ)

####特别提醒：
1、商户系统对于支付结果通知的内容一定要做签名验证,并校验返回的订单金额是否与商户侧的订单金额一致，防止数据泄漏导致出现“假通知”，造成资金损失。

2、当收到通知进行处理时，首先检查对应业务数据的状态，判断该通知是否已经处理过，如果没有处理过再进行处理，如果处理过直接返回结果成功。在对业务数据进行状态检查和处理之前，要采用数据锁进行并发控制，以避免函数重入造成的数据混乱。

####通知参数
字段 | 类型 | 说明
----|----|----
id  | string | 平台订单号
oId | string | 商户订单号(和会员编号只会存在一个)
mId | int   | 会员编号(和商户订单号只会存在一个)
amount | int | 订单金额(单位分)
appId | int | 项目编号
payTime | int | 支付时间
sign | string | 签名

####返回字段
字段 | 类型 |说明
----|----|----
code | int | 1是成功
status | string | 应答状态(可以为空)

示例
```
{"code":1,"status":"ok"}
```

####签名算法
1、签名算法

第一步，设所有发送或者接收到的数据为集合M，将集合M内非空参数值的参数按照参数名ASCII码从小到大排序（字典序），使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串stringA。

特别注意以下重要规则：

◆ 参数名ASCII码从小到大排序（字典序）；
◆ 如果参数的值为空不参与签名；
◆ 参数名区分大小写；
◆ 验证调用返回或微信主动通知签名时，传送的sign参数不参与签名，将生成的签名与该sign值作校验。
◆ 微信接口可能增加字段，验证签名时必须支持增加的扩展字段

第二步，在stringA最后拼接上key得到stringSignTemp字符串，并对stringSignTemp进行MD5运算，再将得到的字符串所有字符转换为小写，得到sign值signValue。


假设传送的参数如下：

```
appid：	wxd930ea5d5a258f4f
mch_id：	10000100

device_info：	1000

body：	test

nonce_str：	ibuaiVcKdpRxkhJA
```

第一步：对参数按照key=value的格式，并按照参数名ASCII字典序排序如下：

```
stringA="appid=wxd930ea5d5a258f4f&body=test&device_info=1000&mch_id=10000100&nonce_str=ibuaiVcKdpRxkhJA";
```

第二步：拼接API密钥：

```
stringSignTemp=stringA+"&key=192006250b4c09247ec02edce69f6a2d" //注：key为商户平台设置的密钥key
sign=MD5(stringSignTemp).toLowerCase()="9A0A8659F005D6984697E2CA0A9CF3B7" //注：MD5签名方式
```