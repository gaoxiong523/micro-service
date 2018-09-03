# micro-service
这是我的微服务学习工程
eureka 类似与dubbo中的zookeeper,服务注册中心,遵循的ap原则, 即服务可用
采用cs架构,有一个服务端,eureka server 作为服务注册的服务器,它是服务注册中心

什么是ap ?什么是cp?
简单来说就是ap服务高可用,cp数据一致性
``img``
springcloud的自我保护机制

更改配置中心实例地址为ip地址
eureka:
    instance:
      prefer-ip-address: true   #路径显示IP信息
