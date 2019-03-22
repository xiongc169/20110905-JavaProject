package org.practice.primary.test;

public class App extends BaseB implements InterfaceA {

    public static void main(String[] args) {
		//编译不通过，对a的引用不明确
        //System.out.println((new App()).a);
    }

}
