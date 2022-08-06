# OpenApi项目在线接口文档


**简介**:OpenApi项目在线接口文档


**HOST**:http://localhost:8080


**联系人**:King


**Version**:v1.0


**接口路径**:/v3/api-docs


[TOC]






# ip


## 获取IP地址信息


**接口地址**:`/api/ip/getIpInfo.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取IP地址信息</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|返回响应类|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|解析接口状态|integer(int32)|integer(int32)|
|count|解析数据长度|integer(int32)|integer(int32)|
|data|解析数据列表|object||
|msg|解析提示文本|string||


**响应示例**:
```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


# 历史上的今天


## 获取历史上的今天


**接口地址**:`/api/todayInHistory/getTodayInHistory.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取历史上的今天</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|返回响应类|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|解析接口状态|integer(int32)|integer(int32)|
|count|解析数据长度|integer(int32)|integer(int32)|
|data|解析数据列表|object||
|msg|解析提示文本|string||


**响应示例**:
```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


## 获取历史上的指定日期的今天 格式MM-DD


**接口地址**:`/api/todayInHistory/getTodayInHistoryByDate.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取历史上的指定日期的今天  格式MM-DD</p>



**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|date|date|query|false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|返回响应类|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|解析接口状态|integer(int32)|integer(int32)|
|count|解析数据长度|integer(int32)|integer(int32)|
|data|解析数据列表|object||
|msg|解析提示文本|string||


**响应示例**:
```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


# 天气接口


## 获取天气信息


**接口地址**:`/api/weather/getWeather.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取天气信息</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|返回响应类|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|解析接口状态|integer(int32)|integer(int32)|
|count|解析数据长度|integer(int32)|integer(int32)|
|data|解析数据列表|object||
|msg|解析提示文本|string||


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


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|返回响应类|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|解析接口状态|integer(int32)|integer(int32)|
|count|解析数据长度|integer(int32)|integer(int32)|
|data|解析数据列表|object||
|msg|解析提示文本|string||


**响应示例**:
```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


# 新闻


## getNews


**接口地址**:`/api/news/getNews.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|返回响应类|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|解析接口状态|integer(int32)|integer(int32)|
|count|解析数据长度|integer(int32)|integer(int32)|
|data|解析数据列表|object||
|msg|解析提示文本|string||


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


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|size|size|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|返回响应类|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|解析接口状态|integer(int32)|integer(int32)|
|count|解析数据长度|integer(int32)|integer(int32)|
|data|解析数据列表|object||
|msg|解析提示文本|string||


**响应示例**:
```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```


# 热点新闻


## 获取百度热搜


**接口地址**:`/api/hotnews/getBaiduHotNews.do`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:<p>获取百度热搜</p>



**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|返回响应类|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|解析接口状态|integer(int32)|integer(int32)|
|count|解析数据长度|integer(int32)|integer(int32)|
|data|解析数据列表|object||
|msg|解析提示文本|string||


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


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|size|size|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|返回响应类|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|解析接口状态|integer(int32)|integer(int32)|
|count|解析数据长度|integer(int32)|integer(int32)|
|data|解析数据列表|object||
|msg|解析提示文本|string||


**响应示例**:
```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
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


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|返回响应类|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|解析接口状态|integer(int32)|integer(int32)|
|count|解析数据长度|integer(int32)|integer(int32)|
|data|解析数据列表|object||
|msg|解析提示文本|string||


**响应示例**:
```javascript
{
	"code": 0,
	"count": 0,
	"data": {},
	"msg": ""
}
```