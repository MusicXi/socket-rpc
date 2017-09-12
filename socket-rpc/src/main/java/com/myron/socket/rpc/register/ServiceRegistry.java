package com.myron.socket.rpc.register;

import java.io.IOException;

/**
 * 配置服务注册组件  
 * @author lin.r.x
 *
 */
public class ServiceRegistry {
	private String host;
	private Integer port;
	
	public ServiceRegistry(String host, Integer port) {
		super();
		this.host = host;
		this.port = port;
	}

	/**
	 * 注册服务
	 * @param interfaceName 服务名称
	 * @param serviceAddress RPC服务地址
	 * @throws IOException 
	 */
	public void register(String serviceName, String serverAddress) throws IOException {
		ZkClient  zkClient = new ZkClient(this.host, this.port);
		Message msg = new Message();
		String[] array = serviceName.split(":");

		if (array.length == 2) {
			msg.setInterfaceName(array[0]);
			msg.setVersion(array[1]);			
		} else {
			msg.setInterfaceName(array[0]);
			msg.setVersion(null);	
		}
		msg.setServiceAddress(serverAddress);
		msg.setType("register");
		zkClient.register(msg);
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
	
	

}
