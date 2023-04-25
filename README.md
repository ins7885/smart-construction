# intelligent-monitor-server

#### 介绍
监测平台管理系统后台

#### 前端部署
执行npm run build:prod


#### 后端部署说明
1,修改配置文件

application.yml

修改zkjd.profile参数路径为C盘

修改spring.profiles.active为druid

2,进行打包

执行install

3,加密操作

(1)执行XJarUtil中的main方法

(2)在生成的jar文件夹下,cmd执行go build xjar.go

(3)将生成的xjar.exe文件和jar文件放在同一目录下, 执行xjar.exe java -jar *.jar

