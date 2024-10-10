# OpenApi项目在线接口文档


**简介**:OpenApi项目在线接口文档


**HOST**:http://116.198.241.58:8080


**联系人**:King


**Version**:v1.0


**接口路径**:/v3/api-docs


[TOC]






# ip


## 获取IP信息


**接口地址**:`/api/ip/getIp.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取IP信息</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## 根据IP获取地址信息


**接口地址**:`/api/ip/getIpInfo.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>根据IP获取地址信息</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


# 历史上的今天api


## 获取历史上的今天


**接口地址**:`/api/todayInHistory/getTodayInHistory.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取历史上的今天</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## 获取历史上的指定日期的今天


**接口地址**:`/api/todayInHistory/getTodayInHistoryByDate.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取历史上的指定日期的今天</p>



**请求参数**:


| 参数名称 | 参数说明  | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | --------- | -------- | -------- | -------- | ------ |
| date     | 格式MM-DD | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


# 地址api


## 根据地址获取经纬度


**接口地址**:`/api/address/getLngLat.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明           | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | ------------------ | -------- | -------- | -------- | ------ |
| address  | 要获取经纬度的地址 | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


# 天气api


## 获取天气信息


**接口地址**:`/api/weather/getWeather.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取天气信息</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## 获取天气信息通过地址


**接口地址**:`/api/weather/getWeatherByAddress.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取天气信息通过地址</p>



**请求参数**:


| 参数名称 | 参数说明         | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | ---------------- | -------- | -------- | -------- | ------ |
| city     | 要获取天气的地址 | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## 获取今天天气信息


**接口地址**:`/api/weather/getWeatherToDay.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取今天天气信息</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## 获取今天天气信息通过地址


**接口地址**:`/api/weather/getWeatherToDayByAddress.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取今天天气信息通过地址</p>



**请求参数**:


| 参数名称 | 参数说明         | 请求类型 | 是否必须 | 数据类型 | schema |
| -------- | ---------------- | -------- | -------- | -------- | ------ |
| city     | 要获取天气的地址 | query    | true     | string   |        |


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


# 新闻api


## 疯狂星期四


**接口地址**:`/api/news/getKfc.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>疯狂星期四</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## 每日一句


**接口地址**:`/api/news/getMingYan.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>每日一句</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## 获取20条热点新闻


**接口地址**:`/api/news/getNews.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取20条热点新闻</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## getNewsBySize


**接口地址**:`/api/news/getNewsBySize.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明               | 请求类型 | 是否必须 | 数据类型       | schema |
| -------- | ---------------------- | -------- | -------- | -------------- | ------ |
| size     | 要获取的新闻数量最大50 | query    | true     | integer(int32) |        |


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## 今日小提示


**接口地址**:`/api/news/getWeekTips.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>今日小提示</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


# 热搜api


## 获取热搜


**接口地址**:`/api/hotnews/getAllHotNews.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取热搜</p>



**请求参数**:


| 参数名称 | 参数说明       | 请求类型 | 是否必须 | 数据类型       | schema |
| -------- | -------------- | -------- | -------- | -------------- | ------ |
| size     | 获取热搜的数量 | query    | true     | integer(int32) |        |


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## 获取百度热搜


**接口地址**:`/api/hotnews/getBaiduHotNews.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取百度热搜</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## 获取抖音热搜


**接口地址**:`/api/hotnews/getDouYinHotNews.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取抖音热搜</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## 获取热搜组合版


**接口地址**:`/api/hotnews/getHotNews.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取热搜组合版</p>



**请求参数**:


| 参数名称 | 参数说明       | 请求类型 | 是否必须 | 数据类型       | schema |
| -------- | -------------- | -------- | -------- | -------------- | ------ |
| size     | 获取热搜的数量 | query    | true     | integer(int32) |        |


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## 获取热搜词云图


**接口地址**:`/api/hotnews/getHotNewsWordCloud.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取热搜词云图</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## 获取热搜词云图


**接口地址**:`/api/hotnews/getHotNewsWordCloud.png`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取热搜词云图</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           |        |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


暂无


**响应示例**:

```javascript

```


## 获取微博热搜


**接口地址**:`/api/hotnews/getWeiboHotNews.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取微博热搜</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


# 返回模板


## ip信息模板


**接口地址**:`/api/returnModel/getIpVo.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>ip信息模板 </p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           | IpVo   |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


| 参数名称 | 参数说明 | 类型   | schema |
| -------- | -------- | ------ | ------ |
| ipv4     |          | string |        |
| ipv6     |          | string |        |


**响应示例**:

```javascript
{
	"ipv4": "",
	"ipv6": ""
}
```


## 地图信息模板


**接口地址**:`/api/returnModel/getMapVo.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>地图信息模板</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema   |
| ------ | ------------ | -------- |
| 200    | OK           | 地址信息 |
| 401    | Unauthorized |          |
| 403    | Forbidden    |          |
| 404    | Not Found    |          |


**响应参数**:


| 参数名称  | 参数说明 | 类型   | schema |
| --------- | -------- | ------ | ------ |
| detail    | 详细地址 | string |        |
| latitude  | 纬度     | string |        |
| longitude | 经度     | string |        |


**响应示例**:

```javascript
{
	"detail": "",
	"latitude": "",
	"longitude": ""
}
```


## 返回新闻模板


**接口地址**:`/api/returnModel/getNewsModel.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>返回新闻模板</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema   |
| ------ | ------------ | -------- |
| 200    | OK           | 新闻模板 |
| 401    | Unauthorized |          |
| 403    | Forbidden    |          |
| 404    | Not Found    |          |


**响应参数**:


| 参数名称 | 参数说明     | 类型   | schema |
| -------- | ------------ | ------ | ------ |
| content  | 新闻内容     | string |        |
| img      | 新闻图片     | string |        |
| source   | 新闻来源     | string |        |
| time     | 新闻发布时间 | string |        |
| title    | 新闻标题     | string |        |
| url      | 新闻链接     | string |        |


**响应示例**:

```javascript
{
	"content": "",
	"img": "",
	"source": "",
	"time": "",
	"title": "",
	"url": ""
}
```


## getResultObj


**接口地址**:`/api/returnModel/getResultObj.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## 历史上的今天模板


**接口地址**:`/api/returnModel/getTodayInHistory.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>历史上的今天模板</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema           |
| ------ | ------------ | ---------------- |
| 200    | OK           | 历史上的今天信息 |
| 401    | Unauthorized |                  |
| 403    | Forbidden    |                  |
| 404    | Not Found    |                  |


**响应参数**:


| 参数名称 | 参数说明 | 类型   | schema |
| -------- | -------- | ------ | ------ |
| desc     | 描述     | string |        |
| festival | 节日     | string |        |
| link     | 链接     | string |        |
| title    | 标题     | string |        |
| year     | 年份     | string |        |


**响应示例**:

```javascript
{
	"desc": "",
	"festival": "",
	"link": "",
	"title": "",
	"year": ""
}
```


## 天气模板


**接口地址**:`/api/returnModel/getWeatherVo.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>天气模板</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema   |
| ------ | ------------ | -------- |
| 200    | OK           | 天气信息 |
| 401    | Unauthorized |          |
| 403    | Forbidden    |          |
| 404    | Not Found    |          |


**响应参数**:


| 参数名称                   | 参数说明     | 类型           | schema  |
| -------------------------- | ------------ | -------------- | ------- |
| city                       | 城市名称     | string         |         |
| list                       | 天气状况     | array          | Weather |
| &emsp;&emsp;airData        | 空气质量     | string         |         |
| &emsp;&emsp;airQuality     | 空气质量指数 | string         |         |
| &emsp;&emsp;city           | 城市         | string         |         |
| &emsp;&emsp;date           | 日期         | string         |         |
| &emsp;&emsp;dateLong       | 日期long     | integer(int64) |         |
| &emsp;&emsp;high           | 最高温度     | string         |         |
| &emsp;&emsp;humidity       | 湿度         | string         |         |
| &emsp;&emsp;lastUpdateTime | 上次更新时间 | string         |         |
| &emsp;&emsp;low            | 最低温度     | string         |         |
| &emsp;&emsp;moreData       | 预警信息     | string         |         |
| &emsp;&emsp;pm10           | PM10         | string         |         |
| &emsp;&emsp;pm25           | PM2.5        | string         |         |
| &emsp;&emsp;province       | 省份         | string         |         |
| &emsp;&emsp;temp           | 温度         | string         |         |
| &emsp;&emsp;weather        | 天气         | string         |         |
| &emsp;&emsp;weatherType    | 天气类型     | integer(int32) |         |
| &emsp;&emsp;wind           | 风力         | string         |         |
| &emsp;&emsp;windLevel      | 风力等级     | integer(int32) |         |


**响应示例**:

```javascript
{
	"city": "",
	"list": [
		{
			"airData": "",
			"airQuality": "",
			"city": "",
			"date": "",
			"dateLong": 0,
			"high": "",
			"humidity": "",
			"lastUpdateTime": "",
			"low": "",
			"moreData": "",
			"pm10": "",
			"pm25": "",
			"province": "",
			"temp": "",
			"weather": "",
			"weatherType": 0,
			"wind": "",
			"windLevel": 0
		}
	]
}
```


# 随机api


## 生成随机姓名


**接口地址**:`/api/random/getRandomName.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>生成随机姓名</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明         | schema |
| ------ | ------------ | ------ |
| 200    | OK           |        |
| 401    | Unauthorized |        |
| 403    | Forbidden    |        |
| 404    | Not Found    |        |


**响应参数**:


暂无


**响应示例**:

```javascript

```


## 生成随机字符串


**接口地址**:`/api/random/getRandomString.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>生成随机字符串</p>



**请求参数**:


| 参数名称    | 参数说明                                                | 请求类型 | 是否必须 | 数据类型 | schema |
| ----------- | ------------------------------------------------------- | -------- | -------- | -------- | ------ |
| isLowerCase | 是否有小写字母(a-z)                                     | query    | false    | boolean  |        |
| isNumber    | 是否有数字(0-9)                                         | query    | false    | boolean  |        |
| isOther     | 是否有其他符号(~!@#$%^&*()-+_=,.)                       | query    | false    | boolean  |        |
| isUpperCase | 是否有大写字母(A-Z)                                     | query    | false    | boolean  |        |
| length      | 随机字符串长度 须大于0小于1000 如果小于等于0 则默认为10 | query    | false    | string   |        |


**响应状态**:


| 状态码 | 说明         | schema     |
| ------ | ------------ | ---------- |
| 200    | OK           | 返回响应类 |
| 401    | Unauthorized |            |
| 403    | Forbidden    |            |
| 404    | Not Found    |            |


**响应参数**:


| 参数名称 | 参数说明     | 类型           | schema         |
| -------- | ------------ | -------------- | -------------- |
| code     | 解析接口状态 | integer(int32) | integer(int32) |
| count    | 解析数据长度 | integer(int32) | integer(int32) |
| data     | 解析数据列表 | object         |                |
| msg      | 解析提示文本 | string         |                |


**响应示例**:

```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```