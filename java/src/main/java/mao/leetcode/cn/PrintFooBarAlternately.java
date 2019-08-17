package mao.leetcode.cn;

//https://leetcode-cn.com/problems/print-foobar-alternately
public class PrintFooBarAlternately {

}

class FooBar {
    private int n;
    private final Object mutex = new Object();
    private int flag = 0;
    
    public FooBar(int n) {
        this.n = n;
    }
    
    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
        	synchronized (mutex) {
            	while(true) {
            		if (flag == 0) {
                    	// printFoo.run() outputs "foo". Do not change or remove this line.
                    	printFoo.run();
                    	flag = 1;
                    	mutex.notifyAll();
                    	break;
            		} else {
            			mutex.wait(5);
            		}
            	}
        	}
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
        	synchronized (mutex) {
            	while(true) {
            		if (flag == 1) {
                        // printBar.run() outputs "bar". Do not change or remove this line.
                    	printBar.run();
                    	flag = 0;
                    	mutex.notifyAll();
                    	break;
            		} else {
            			mutex.wait(5);
            		}
            	}
        	}            
        }
    }
}
