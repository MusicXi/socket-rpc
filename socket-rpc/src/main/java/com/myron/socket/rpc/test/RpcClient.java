package com.myron.socket.rpc.test;


import com.myron.socket.rpc.client.RpcProxy;
import com.myron.socket.rpc.register.ServiceDiscovery;

/**
 *  负责导入（import）远程接口的代理实现  
 * @author lin.r.x
 *
 */
public class RpcClient {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object refer(Class serviceInterface) {
		return new RpcProxy().newProxyInstance(serviceInterface);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object refer(Class serviceInterface, String version) {
		return new RpcProxy().newProxyInstance(serviceInterface, version);
	}
	
	public static void main(String[] args) throws InterruptedException {
		RpcProxy proxy = new RpcProxy();
		ServiceDiscovery serviceDiscovery = new ServiceDiscovery("127.0.0.1", 2181);;
		proxy.setServiceDiscovery(serviceDiscovery);
		
		//像本地实现一样使用接口实现
		HelloService helloService = (HelloService) proxy.newProxyInstance(HelloService.class, "0.0.1");
		
		System.out.println(helloService.sayHi("jackddd"));
		System.out.println(helloService.plus(1, 2));	
		
		//测试Rpc调用异常情况
		try {
			helloService.makeError();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
