package com.myron.socket.rpc.test;

/**
 * 顶顶顶顶
 * @author Administrator
 *
 */
public interface HelloService {
	String sayHi(String name);
	int plus(int x, int y);
	void makeError() throws Exception;
}
