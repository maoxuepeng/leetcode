package mao.leetcode.cn;

public class PrintInOrder {
	
	private final Object mutex = new Object();
	private int order = 2;
	
    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        synchronized (mutex) {
        	order --;
        	mutex.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
    	synchronized (mutex) {
        	while (true) {
        		if (order == 1) {
            		order --;
                    printSecond.run();
                    mutex.notifyAll();
                    break;
        		} else {
        			mutex.wait(100);
        		}
        	}
    	}
    }

    public void third(Runnable printThird) throws InterruptedException {
    	synchronized (mutex) {
        	while (true) {
        		if (order == 0) {
                    printThird.run();
                    mutex.notifyAll();
                    break;
        		} else {
        			mutex.wait(100);
        		}
        	}
    	}
    }
}
