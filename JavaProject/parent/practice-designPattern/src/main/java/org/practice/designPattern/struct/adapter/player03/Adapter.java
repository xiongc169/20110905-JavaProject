package org.practice.designPattern.struct.adapter.player03;

/**
 * @author yoong
 *
 * @date 2018年6月12日
 *
 */
public class Adapter extends Source implements Target {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.practice.designPattern.struct.adapter.player03.Target#methodB()
	 */
	@Override
	public void methodB() {
		System.out.println("This is targetable methodB()");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.practice.designPattern.struct.adapter.player03.Target#methodC()
	 */
	@Override
	public void methodC() {
		System.out.println("This is targetable methodC()");

	}

}
