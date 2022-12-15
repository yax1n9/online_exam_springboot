## 1. 登录

#### 1.1 请求方式

post

#### 1.2 url

/login

#### 1.3 请求参数

| 字段名   | 格式   | 必填 | 备注   |
| :------- | ------ | ---- | ------ |
| username | string | y    | 用户名 |
| password | string | y    | 密码   |



#### 1.4 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "登录成功！",
    "data": null
}
```

## 2. 注册

#### 2.1 请求方式

post

#### 2.2 url

/register

#### 2.3 请求参数

| 字段名   | 格式   | 必填 | 备注              |
| -------- | ------ | ---- | ----------------- |
| username | string | y    |                   |
| password | string | y    |                   |
| role     | int    | y    | 身份              |
| avatar   | string | n    | 头像文件名        |
| name     | string | n    | 姓名              |
| gender   | int    | n    | 性别 0：女；1：男 |
| tel      | string | n    | 电话              |



#### 2.4 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "注册成功！",
    "data": null
}
```

## 3. 分类（科目）

### 3.1 添加分类

#### 3.1.1 请求方式

post

#### 3.1.2 url

/subject

#### 3.1.3 请求参数

| 字段 | 格式   | 必填 | 备注     |
| ---- | ------ | ---- | -------- |
| name | string | y    | 科目名称 |

#### 3.1.4 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "添加成功！",
    "data": null
}
```

### 3.2 删除分类

#### 3.2.1 请求方式

delete

#### 3.2.2 url

/subject/#{subjectId}

#### 3.2.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "删除成功！",
    "data": null
}
```

### 3.3 修改分类

#### 3.3.1 请求方式

put

#### 3.3.2 url

/subject

#### 3.3.3 请求参数

| 字段      | 格式   | 必填 | 备注 |
| --------- | ------ | ---- | ---- |
| subjectId | int    | y    |      |
| name      | string | y    |      |

#### 3.3.4 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "修改成功！",
    "data": null
}
```

### 3.4 查询单条

#### 3.4.1 请求方式

get

#### 3.4.2 url

/subject/#{subjectId}

#### 3.4.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "查询成功！",
    "data": {
        "subjectId": 1,
        "name": "计算机网络",
        "isDelete": 0
    }
}
```

### 3.5 查询列表

#### 3.5.1 请求方式

get

#### 3.5.2 url

/subject

#### 3.5.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "查询成功！",
    "data": [
        {
            "subjectId": 1,
            "name": "计算机网络",
            "isDelete": 0
        },
        {
            "subjectId": 3,
            "name": "web前端开发",
            "isDelete": 0
        }
    ]
}
```

### 3.6 分页条件查询

#### 3.6.1 请求方式

get

#### 3.6.2 url

/subject/#{currentPage}/#{pageSize}?name=xxx

#### 3.6.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "查询成功！",
    "data": {
        "records": [
            {
                "subjectId": 1,
                "name": "计算机网络",
                "isDelete": 0
            },
            {
                "subjectId": 3,
                "name": "web前端开发",
                "isDelete": 0
            }
        ],
        "total": 2,
        "size": 2,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "hitCount": false,
        "countId": null,
        "maxLimit": null,
        "searchCount": true,
        "pages": 1
    }
}
```

## 4. 单选题

### 4.1 添加单选题

#### 4.1.1 请求方式

post

#### 4.1.2 url

/singleChooses

#### 4.1.3 请求参数

| 字段       | 格式   | 必填 | 备注 |
| ---------- | ------ | ---- | ---- |
| title      | string | y    | 题目 |
| answerA    | string | y    |      |
| answerB    | string | y    |      |
| answerC    | string | n    |      |
| answerD    | string | n    |      |
| realAnswer | int    | y    |      |
| type       | int    | n    |      |

#### 4.1.4 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "添加成功！",
    "data": null
}
```

### 4.2 删除单选题

#### 4.2.1 请求方式

delete

#### 4.2.2 url

/singleChooses/#{singleChooseId}

#### 4.2.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "删除成功！",
    "data": null
}
```

### 4.3 修改单选题

#### 4.3.1 请求方式

put

#### 4.3.2 url

/singleChooses

#### 4.3.3 请求参数

| 字段       | 格式   | 必填 | 备注 |
| ---------- | ------ | ---- | ---- |
| questionId | int    | y    |      |
| answerA    | string | n    |      |
| answerB    | string | n    |      |
| answerC    | string | n    |      |
| answerD    | string | n    |      |
| realAnswer | int    | n    |      |

#### 4.3.4 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "修改成功！",
    "data": null
}
```



### 4.4 查询单个单选题

#### 4.4.1 请求方式

get

#### 4.4.2 url

/singleChooses/#{singleChooseId}

#### 4.4.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "查询成功！",
    "data": {
        "questionId": 2,
        "subjectId": 1,
        "title": "HTTP协议通常使用什么协议进行传输（）",
        "answerA": "ARP",
        "answerB": "DHCP",
        "answerC": "UDP",
        "answerD": "TCP",
        "realAnswer": "4",
        "isDelete": 0,
        "type": 0
    }
}
```



### 4.5 查询单选题列表

#### 4.5.1 请求方式

get

#### 4.5.2 url

/singleChooses

#### 4.5.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "查询成功！",
    "data": [
        {
            "questionId": 1,
            "subjectId": 1,
            "title": "DNS 服务器和DHCP服务器的作用是（）",
            "answerA": "将IP地址翻译为计算机名，为客户机分配IP地址",
            "answerB": "将IP地址翻译为计算机名、解析计算机的MAC地址",
            "answerC": "将IP地址翻译为计算机名、解析计算机的MAC地址",
            "answerD": "将计算机名翻译为IP地址、解析计算机的MAC地址",
            "realAnswer": "3",
            "isDelete": 0,
            "type": 0
        },
        {
            "questionId": 2,
            "subjectId": 1,
            "title": "HTTP协议通常使用什么协议进行传输（）",
            "answerA": "ARP",
            "answerB": "DHCP",
            "answerC": "UDP",
            "answerD": "TCP",
            "realAnswer": "4",
            "isDelete": 0,
            "type": 0
        }
    ]
}
```



### 4.6 分页条件查询

#### 4.6.1 请求方式

get

#### 4.6.2 url

/singleChooses/#{currentPage}/#{pageSize}?title=???

#### 4.6.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "查询成功！",
    "data": {
        "records": [
            {
                "questionId": 1,
                "subjectId": 1,
                "title": "DNS 服务器和DHCP服务器的作用是（）",
                "answerA": "将IP地址翻译为计算机名，为客户机分配IP地址",
                "answerB": "将IP地址翻译为计算机名、解析计算机的MAC地址",
                "answerC": "将IP地址翻译为计算机名、解析计算机的MAC地址",
                "answerD": "将计算机名翻译为IP地址、解析计算机的MAC地址",
                "realAnswer": "3",
                "isDelete": 0,
                "type": 0
            },
            {
                "questionId": 3,
                "subjectId": 1,
                "title": "查看DNS缓存记录的命令（）",
                "answerA": "ipconfig/displaydns",
                "answerB": "nslookup",
                "answerC": "ipconfig/release",
                "answerD": "ipconfig/flushdns",
                "realAnswer": "1",
                "isDelete": 0,
                "type": 0
            },
            {
                "questionId": 7,
                "subjectId": 1,
                "title": "DNS服务器在名称解析过程中正确的查询顺序为（）",
                "answerA": "本地缓存记录→区域记录→转发域名服务器→根域名服务器",
                "answerB": "区域记录→本地缓存记录→转发域名服务器→根域名服务器",
                "answerC": "本地缓存记录→区域记录→根域名服务器→转发域名服务器",
                "answerD": "区域记录→本地缓存记录→根域名服务器→转发域名服务器",
                "realAnswer": "1",
                "isDelete": 0,
                "type": 0
            }
        ],
        "total": 3,
        "size": 5,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "hitCount": false,
        "countId": null,
        "maxLimit": null,
        "searchCount": true,
        "pages": 1
    }
}
```



## 5. 试卷设置

### 5.1 添加试卷设置

#### 5.1.1 请求方式

post

#### 5.1.2 url

/exams

#### 5.1.3 请求参数

| 字段               | 格式      | 必填 | 备注                            |
| ------------------ | --------- | ---- | ------------------------------- |
| title              | string    | y    |                                 |
| subjectId          | int       | y    | 分类Id                          |
| startTime          | timestamp | y    | 开始时间                        |
| endTime            | timestamp | y    | 结束时间                        |
| lastEnterTime      | int       | y    | 最晚进入时间（默认开始15min内） |
| shortestSubmitTime | int       | y    | 最短提交时间（默认开始15min后） |
| passLine           | int       | y    | 及格线（默认60%）               |
| cover              | string    | n    | 封面                            |



#### 5.1.4 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "添加成功！",
    "data": {
        "examId": 11
    }
}
```



### 5.2 删除试卷设置

#### 5.2.1 请求方式

delete

#### 5.2.2 url

/exams/#{examId}

#### 5.2.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "删除成功！",
    "data": null
}
```



### 5.3 修改试卷设置

#### 5.3.1 请求方式

put

#### 5.3.2 url

/exam

#### 5.3.3 请求参数

| 字段               | 格式      | 必填 | 备注                            |
| ------------------ | --------- | ---- | ------------------------------- |
| examId             | int       | y    |                                 |
| title              | string    | n    |                                 |
| subjectId          | int       | n    | 分类Id                          |
| startTime          | timestamp | n    | 开始时间                        |
| endTime            | timestamp | n    | 结束时间                        |
| lastEnterTime      | int       | n    | 最晚进入时间（默认开始15min内） |
| shortestSubmitTime | int       | n    | 最短提交时间（默认开始15min后） |
| passLine           | int       | n    | 及格线（默认60%）               |
| cover              | string    | n    | 封面                            |



#### 5.3.4 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "修改成功！",
    "data": null
}
```



### 5.4 查询单个试卷设置

#### 5.4.1 请求方式

get

#### 5.4.2 url

/exams/#{examId}

#### 5.4.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "查询成功！",
    "data": {
        "examId": 2,
        "title": "计算机网络期末考试（B）",
        "cover": "exam_cover_default.png",
        "subjectId": 1,
        "startTime": "2022-12-31T02:22:46.000+00:00",
        "endTime": "2022-12-31T04:22:46.000+00:00",
        "latestEnterTime": 15,
        "shortestSubmitTime": 15,
        "passLine": 60,
        "isDelete": 0,
        "isEnd": 0
    }
}
```



### 5.5 查询所有试卷设置

#### 5.5.1 请求方式

get

#### 5.5.2 url

/exams

#### 5.5.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "查询成功！",
    "data": [
        {
            "examId": 1,
            "title": "计算机网络期末考试（A）",
            "cover": "exam_cover_default.png",
            "subjectId": 1,
            "startTime": "2022-12-05T02:20:23.000+00:00",
            "endTime": "2022-12-31T02:20:23.000+00:00",
            "latestEnterTime": 15,
            "shortestSubmitTime": 15,
            "passLine": 60,
            "isDelete": 0,
            "isEnd": 0
        },
        {
            "examId": 2,
            "title": "计算机网络期末考试（B）",
            "cover": "exam_cover_default.png",
            "subjectId": 1,
            "startTime": "2022-12-31T02:22:46.000+00:00",
            "endTime": "2022-12-31T04:22:46.000+00:00",
            "latestEnterTime": 15,
            "shortestSubmitTime": 15,
            "passLine": 60,
            "isDelete": 0,
            "isEnd": 0
        }
    ]
}
```



### 5.6 分页条件查询试卷设置

#### 5.6.1 请求方式

get

#### 5.6.2 url

/exams/#{currentPage}/#{pageSize}?subjectId=2

#### 5.6.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "查询成功！",
    "data": {
        "records": [
            {
                "examId": 3,
                "title": "web前端",
                "cover": "exam_cover_default.png",
                "subjectId": 2,
                "startTime": "2022-12-12T09:39:13.000+00:00",
                "endTime": "2022-12-12T09:39:13.000+00:00",
                "latestEnterTime": 15,
                "shortestSubmitTime": 15,
                "passLine": 60,
                "isDelete": 0,
                "isEnd": 1
            }
        ],
        "total": 1,
        "size": 2,
        "current": 1,
        "orders": [],
        "optimizeCountSql": true,
        "hitCount": false,
        "countId": null,
        "maxLimit": null,
        "searchCount": true,
        "pages": 1
    }
}
```

## 6. 试卷题目

### 6.1 试卷添加题目

#### 6.1.1 请求方式

post

#### 6.1.2 url

/examQuestions

#### 6.1.3 请求参数

| 字段       | 格式 | 必填 | 备注                 |
| ---------- | ---- | ---- | -------------------- |
| questionId | int  | y    |                      |
| examId     | int  | y    |                      |
| score      | int  | n    | 题目在当前试卷的分数 |



#### 6.1.4 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "添加成功！",
    "data": null
}
```



### 6.2 试卷删除题目

#### 6.2.1 请求方式

delete

#### 6.2.2 url

/examQuestions/#{examQuestionId}

#### 6.2.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "删除成功！",
    "data": null
}
```



### 6.3 试卷修改题目

#### 6.3.1 请求方式

#### 6.3.2 url

#### 6.3.3 请求参数

| 字段       | 格式 | 必填 | 备注                 |
| ---------- | ---- | ---- | -------------------- |
| questionId | int  | n    |                      |
| examId     | int  | n    |                      |
| score      | int  | n    | 题目在当前试卷的分数 |



#### 6.3.4 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "修改成功！",
    "data": null
}
```



### 6.4 试卷查询单个题目

#### 6.4.1 请求方式

get

#### 6.4.2 url

/examQuestions/#{examQuestionId}

#### 6.4.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "查询成功！",
    "data": {
        "examQuestionId": 1,
        "questionId": 1,
        "examId": 1,
        "score": 3,
        "isDelete": 0
    }
}
```



### 6.5 试卷查询题目列表

#### 6.5.1 请求方式

get

#### 6.5.2 url

/examQuestions

#### 6.5.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "查询成功！",
    "data": [
        {
            "examQuestionId": 1,
            "questionId": 1,
            "examId": 1,
            "score": 3,
            "isDelete": 0
        },
        {
            "examQuestionId": 2,
            "questionId": 2,
            "examId": 1,
            "score": 3,
            "isDelete": 0
        },
        {
            "examQuestionId": 3,
            "questionId": 3,
            "examId": 1,
            "score": 3,
            "isDelete": 0
        },
        {
            "examQuestionId": 4,
            "questionId": 4,
            "examId": 1,
            "score": 3,
            "isDelete": 0
        }
    ]
}
```



### 6.6 分页条件查询试卷题目

#### 6.6.1 请求方式

get

#### 6.6.2 url

/examQuestions/2/5?examId=1

#### 6.6.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "查询成功！",
    "data": {
        "records": [
            {
                "examQuestionId": 6,
                "questionId": 6,
                "examId": 1,
                "score": 3,
                "isDelete": 0
            },
            {
                "examQuestionId": 7,
                "questionId": 7,
                "examId": 1,
                "score": 3,
                "isDelete": 0
            },
            {
                "examQuestionId": 8,
                "questionId": 8,
                "examId": 1,
                "score": 3,
                "isDelete": 0
            },
            {
                "examQuestionId": 9,
                "questionId": 9,
                "examId": 1,
                "score": 3,
                "isDelete": 0
            },
            {
                "examQuestionId": 10,
                "questionId": 10,
                "examId": 1,
                "score": 3,
                "isDelete": 0
            }
        ],
        "total": 11,
        "size": 5,
        "current": 2,
        "orders": [],
        "optimizeCountSql": true,
        "hitCount": false,
        "countId": null,
        "maxLimit": null,
        "searchCount": true,
        "pages": 3
    }
}
```

## 7. 是否正在进行

#### 7.1 请求方式

get

#### 7.2 url

/isExam/#{examId}

#### 7.3 返回值

```json
{
    "code": 701,
    "success": true,
    "message": "考试已经开始，不能进入！",
    "data": {
        "remainingTime": 0,
        "exam": false
    }
}
```



## 8. 文件

### 8.1 上传

#### 8.1.1 请求方式

post

#### 8.1.2 url

/files

#### 8.1.3 返回值

```json
{
    "code": 200,
    "success": true,
    "message": "查询成功！",
    "data": "exam_cover_default.png"
}
```



### 8.2 下载

#### 8.2.1 请求方式

get

#### 8.2.2 url

/files/#{fileName}

#### 8.2.3 返回值

目标图片
