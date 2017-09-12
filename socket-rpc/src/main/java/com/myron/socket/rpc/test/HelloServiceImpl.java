package com.myron.socket.rpc.test;



public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHi(String name) {
		return "Hi, " + name;
	}

	@Override
	public int plus(int x, int y) {
		return x + y;
	}

	@Override
	public void makeError() throws Exception {
		try {
			int i = 1 / 0;		
			System.out.println(i);
		} catch (Exception e) {
			throw e;
		}
		
	}


	
	

}
