# micro-service
这是我的微服务学习工程
eureka 类似与dubbo中的zookeeper,服务注册中心,遵循的ap原则, 即服务可用
采用cs架构,有一个服务端,eureka server 作为服务注册的服务器,它是服务注册中心

什么是ap ?什么是cp?
简单来说就是ap服务高可用,cp数据一致性
``img``
springcloud-eureka的自我保护机制:
某时候某个服务不可用了,eureka不会立刻清理,依旧会对该服务的信息进行保存
宁可保留错误的服务信息, 也不盲目注销任务可能健康的服务实例
通过这种形式 来达到AP 的原则,服务的高可用
server:
    enable-self-preservation: false 这样可以禁用自我保护机制

更改配置中心实例地址为ip地址
eureka:
    instance:
      prefer-ip-address: true   #路径显示IP信息


eureka 高可用集群配置
本地配置 映射
c:windows/sysytem32/drivers/etc/hosts
文件
eureka-server7001 127.0.0.1
eureka-server7002 127.0.0.1
eureka-server7003 127.0.0.1
通过spring:profiles 来启动三个注册中心
注册进服务的实例 要在三个服务中心都进行注册

---
spring:
  profiles: eureka_server7001
  application:
    name: eureka-server7001
server:
  port: 7001
eureka:
  client:
    register-with-eureka: false #false表示不向服务中心注册自己,单注册中心要配置,
    fetch-registry: false #false 表示自己端就是注册中心,我的职责是维护服务实例,并不需要取检索服务
    service-url:
      defaultZone: http://eureka-server7003:7003/eureka/,http://eureka-server7002:7002/eureka/ #设置 与eureka server 交互的地址查询服务和注册服务
  instance:
    hostname: eureka-server7001  # eureka 服务端的实例名称



---
spring:
  profiles: eureka_server7002
  application:
    name: eureka-server7002
server:
  port: 7002
eureka:
  client:
    register-with-eureka: false #false表示不向服务中心注册自己,单注册中心要配置,
    fetch-registry: false #false 表示自己端就是注册中心,我的职责是维护服务实例,并不需要取检索服务
    service-url:
      defaultZone: http://eureka-server7001:7001/eureka/,http://eureka-server7003:7003/eureka/ #设置 与eureka server 交互的地址查询服务和注册服务
  instance:
    hostname: eureka-server7002  # eureka 服务端的实例名称

---   #多个配置之间一定要用 三个短横线隔开
spring:
  profiles: eureka_server7003
  application:
    name: eureka-server7003
server:
  port: 7003
eureka:
  client:
    register-with-eureka: false #false表示不向服务中心注册自己,单注册中心要配置,
    fetch-registry: false #false 表示自己端就是注册中心,我的职责是维护服务实例,并不需要取检索服务
    service-url:
      defaultZone: http://eureka-server7001:7001/eureka/,http://eureka-server7002:7002/eureka/ #设置 与eureka server 交互的地址查询服务和注册服务
  instance:
    hostname: eureka-server7003  # eureka 服务端的实例名称


**CAP原则**
传统的ACID
A(Atomicity)原子性
C(Consistency)一致性
I(Isolation)独立性
D(Durability)持久性

CAP
C:Consistency (强一致性)
A:Availability(可用性)
P:Partition tolerance(分区容错性)
 
 **Ribbon负载均衡**
 Ribbon是消费方客户端负载均衡
 client:
     fetch-registry: true
     register-with-eureka: true
     客户端这两个配置一定要分清楚状况是开和关
 集群负载均衡时, Ribbon是通过 application的名字拿到微服务的
 private static final String REST_URL_PREFIX = "http://microservicecloud-dept/";