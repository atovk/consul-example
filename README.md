# consul 测试环境

## 1.安装 docker 

略

## 2.Consul

### 启动consul 集群

```bash

docker-compose docker-compose.yml

```

### 访问Consul服务控制台

http://localhost:8500


## 3.测试服务

### 将服务打包进docker 在consul网格下运行

> 可测试注册到Consul不不同的server上

```bash

docker run service-b-exp:latest

```

### 访问测试服务

```bash

curl http://server-ip:8088

```
