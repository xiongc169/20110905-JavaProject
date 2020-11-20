package org.practice.junior.book01.chap14.book02.chap0104;

public class PrimeTask implements Runnable {

    private long number;

    public PrimeTask(long number) {
        this.number = number;
    }

    public void run() {

        while (true) {
            if (isPrime(number)) {
                System.out.printf("Number %d is prime \n", number);
            }

            //primeThread.interrupt();//将线程的【中断标志】置为true，返回void类型；
            //Thread.currentThread().isInterrupted();//读取线程的【中断标志】，返回boolean类型；
            //boolean flag = Thread.interrupted();//静态方法，检查当前线程是否被中断，返回boolean类型，同时将线程的【中断标志】置为false；
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("PrimeTask has been interrupted \n");
                System.out.printf("Thread.interrupted() %s \n", Thread.interrupted());//若调用Thread.interrupted()，则Thread.currentThread().isInterrupted()为false；否则为true
                System.out.printf("Thread.currentThread().isInterrupted() %s \n", Thread.currentThread().isInterrupted());
                System.exit(0);
                // return;
            }
            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number >= 1 && number <= 2) {
            return true;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
