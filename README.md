###webservice example
一、demo内容
```
soap
1、cxf框架开发
2、jdk-jws开发
注：主要在发布方式上使用的包及其实现方式

restful
1、restful ws开发

```
二、项目包
```
soap - cxf/jws
其中cxf的hello范例是使用标准的soap+xml格式；
其余的是返回字符串。

restful按照http+json格式

注意：soap接口和接口实现类，暴露接口按照标准的协议走，但是传的数据格式可以不是xml
```

三、使用jdk-jws和cxf框架开发（服务端）的区别（区别在发布使用的类上）：
```
1、关于服务端接口和接口实现类没有区别，具体可看HiCxfServiceImpl，经验证@WebService注解的两种书写方式都没问题，关键在于发布Endpoint上，使用的是哪个包的Endpoint：
根据示例可看出：
    1. jdk的方式对于服务端接口和接口实现类都只需注解@WebService标注即可；
    2. cxf方式，服务端接口和接口实现类都既需注解@WebService标注，也需写endpointInterface、targetNamespace等属性；

2、关于暴露接口环节：
区别在发布使用的类上（具体可看demo中EndpointPublishConfig类和EndpointServer类）
jdk import javax.xml.ws.Endpoint; - 这种方式需要配置另外一个端口，避免和网关端口冲突，并可选择运行在其他容器上,如jetty
cxf org.apache.cxf.jaxws.EndpointImpl;和一些拦截设置

注意：客户端的获取方式是没有区别的。
```
```
wsdl:
http://localhost:8099/service/helloCxf?wsdl
http://localhost:8066/service/hiCxf?wsdl
http://localhost:8088/service/helloJwsService?wsdl
```
前两段使用的是soap协议。

四、ws的分类：soap ws和restful ws
```
restful 风格像controller风格注解，主要是http+json
soap需要使用一些注解，主要是http+xml

```

