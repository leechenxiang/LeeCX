# LeeCX<br />
LeeCX 开源后台管理系统，前端基于bootstrap+jquery，扁平化风格，可支持移动端浏览器；后端基于springmvc+spring+mybatis<br />

### 主要功能：<br />
1、三层架构：使用SSM，即springmvc+spring+mybatis作为基本的架构<br />
2、数据源采用阿里巴巴Druid连接池，可以开启监控数据库访问性能，统计SQL执行的面板<br />
3、展现层： 使用spring mvc注解，api接口采用Restful风格<br />
4、持久层：使用mybatis持久化，提供逆向生成工程减少代码量；并且使用pagehelper作为分页插件<br />
5、日志采用slf4j+log4j进行日志管理<br />
6、使用SID（基于idworker）生成唯一主键，利于分库分表<br />
其他技术将会不间断更新并且引入...<br />

### 登录用户名以及密码：<br />
test/test<br />

### 开发环境：<br />
sts-eclipse, jdk8, tomcat7或8<br />

### 技术选型：<br />
1、核心框架：Spring Framework 4.3.3.RELEASE<br />
2、权限框架：Apache Shiro 1.3.2<br />
3、持久层框架：MyBatis 3.2.8 + pagehelper 4.1.3<br />
4、数据库连接池：阿里巴巴 Druid 1.1.0<br />
5、缓存：Redis/Jedis 2.8.0<br />
6、日志管理：SLF4J + Log4j<br />
7、前端框架/组件：Bootstrap + Jquery + Jquery Validate + jqGrid + sweetalert + blockUI + icheck<br />

### 更新历史：<br />
20170919 增加component子模块，实现redis供多工程公用；增加数据字典功能（录制的视频链接在底部）<br />


### 工程结构：<br />
``` lua
LeeCX
├── generatorSqlmapCustom：mybatis逆向生成工具
├── leecx-root：母工程，主要用于管理pom
├── leecx-common：统一工具类，包含统一的utils以及枚举等
└── leecx-mng：后台管理系统
     ├── leecx-mng-component：通用组件工程，目前只包含redis
     ├── leecx-mng-pojo：entity，包含pojo，bo以及vo
     ├── leecx-mng-mapper：mybitas的mapper.xml以及mapper.java文件
     ├── leecx-mng-service：service工程
     └── leecx-mng-web：web工程 (port:8080 可在pom中自由配置)
```

* 注意：sql脚本文件在 leecx-mng-web/src/main/resources/sql/leecx.sql <br />

扫一扫关注我们 加入QQ群（458372464）或者关注公众号获得更多技术咨询、技术交流、技术资源...<br />
![image](https://github.com/leechenxiang/LeeCX/raw/master/leecx-mng/leecx-mng-web/src/main/webapp/static/pages/img/center/qrcode-scan.png)


视频推荐 我们也致力于技术视频的录制，希望大家学到更多的技术...<br />
[《ssm redis 数据字典在J2EE中的多种应用与实现》](http://www.itzixi.com/course/detail.shtml?courseId=17092078Y3009WX4)<br />
[《使用新版支付宝接口实现第三方网关支付》](http://www.itzixi.com/course/detail.shtml?courseId=170818C4XS6SPG9P)<br />
[《SpringMVC 实现web端微信扫码支付(即时到账)》](http://www.itzixi.com/course/detail.shtml?courseId=1709029W0AFN7X1P)<br />
[《Linux - Java开发者所需要掌握的一门最基本的技能》](http://www.itzixi.com/course/detail.shtml?courseId=170802GTMYF0GYNC)<br />
[《LeeCX 开源后台管理系统 git+maven+ssm (不断更新)》](http://www.itzixi.com/course/detail.shtml?courseId=17091175XBRXMS14)<br />
[《插件推荐：mybatis-pagehelper + jqgrid 实现无刷新分页》](http://www.itzixi.com/course/detail.shtml?courseId=1709106XFPFRT4SW)<br />
录制中... 《shiro - 从入门到精通，结合实战》<br />
录制中... 《springboot - 从入门到精通，结合各类技术的整合与实战》<br />
