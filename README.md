帮助文档地址：https://www.yuque.com/miyang.meyoung/luban
git地址：https://github.com/MeYoung/Luban_API_Test
## 优点

1. case分级（blocker，critical，normal，minor，trivial）
2. 数据驱动
3. 简化数据库交互
4. 参数化（多环境支持）
5. 对象对比、两个Json对比
6. 指定需要运行的case（冒烟，回归，全量等。。。）
7. 详细的测试报告，可以回溯每个case的历史执行记录，并报告展示每个请求请求
8. 支持任意次数的失败重跑
9. 支持多种并发方式，自由配置的并发数
10. 自由不受限，易扩展
11. 支持Dubbo RPC测试
12. 支持报告自动记录测试步骤
13. 等等

## 缺点

1. 上手难度相对较大



## 技术架构

- API调用框架：RestAssured、Dubbo
- Case管理：TestNG
- Json解析：fastjson、JsonPath
- Log打印：slf4j logback
- 持久层框架：Mybatis 、Mapper
- 测试报告：allure2
- CI：jenkins
工程

## 整体流程
![](https://raw.githubusercontent.com/MeYoung/notes_images/master/boostnote/20190814112556.png)

### Jenkins参数化构建
![](https://raw.githubusercontent.com/MeYoung/notes_images/master/boostnote/20190814112717.png)

### Run.xml配置
![](https://raw.githubusercontent.com/MeYoung/notes_images/master/boostnote/20190814112749.png)

### 前置条件
![](https://raw.githubusercontent.com/MeYoung/notes_images/master/boostnote/20190814112816.png)

### Case
![](https://raw.githubusercontent.com/MeYoung/notes_images/master/boostnote/20190814112914.png)

### 后置条件
![](https://raw.githubusercontent.com/MeYoung/notes_images/master/boostnote/20190814112944.png)

### 报告和邮件
![](https://raw.githubusercontent.com/MeYoung/notes_images/master/boostnote/20190814113031.png)
![](https://raw.githubusercontent.com/MeYoung/notes_images/master/boostnote/20190814113221.png)
![](https://raw.githubusercontent.com/MeYoung/notes_images/master/boostnote/20190814113253.png)
