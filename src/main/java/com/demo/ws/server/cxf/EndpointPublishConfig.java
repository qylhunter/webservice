package com.demo.ws.server.cxf;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;


/**
 * 发布接口：Hello和Hi的不同发布方式
 */
@Configuration
public class EndpointPublishConfig {
    @Bean
    public ServletRegistrationBean dispatcherServlet(){
        return new ServletRegistrationBean(new CXFServlet(),"/service/*");//发布服务名称
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus()
    {
        return  new SpringBus();
    }

    @Bean
    public Endpoint endpoint_hello() {
        EndpointImpl endpoint=new EndpointImpl(springBus(), new HelloCXFServiceImpl());//绑定要发布的服务
        endpoint.publish("/helloCxf"); //显示要发布的名称
        return endpoint;
    }
    //jdk-jws的发布方式需要使用其他容器及不同端口发布，否则会端口冲突，这里使用jetty，否则报Cannot find any registered HttpDestinationFactory from the Bus
    @Bean
    public Endpoint endpoint_hi() {
        return Endpoint.publish("http://localhost:8066/service/hiCxf?wsdl",new HiCXFServiceImpl()); //显示要发布的名称
    }
}
