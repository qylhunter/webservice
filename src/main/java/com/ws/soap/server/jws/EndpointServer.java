package com.ws.soap.server.jws;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.xml.ws.Endpoint;


/**
 * 发布接口:使用ApplicationListener监听ContextRefreshedEvent事件。ContextRefreshedEvent就是在ApplicationContext被
 * 初始化（所有的bean被成功装载，后处理bean被检测或成功激活，所有的singleton bean被实例化，ApplicationContext容器已就绪可用）或刷新时，该事件被发布。
 */
@Configuration
public class EndpointServer implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Endpoint.publish("http://localhost:8088/service/helloJwsService", new HelloJwsServiceImpl());
        System.out.println("endpoint success!");
    }
}
