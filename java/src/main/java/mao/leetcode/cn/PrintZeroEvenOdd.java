package mao.leetcode.cn;

import java.util.function.IntConsumer;

//https://leetcode-cn.com/problems/print-zero-even-odd/
public class PrintZeroEvenOdd {
	
	public static void main(String args[]) {
		final ZeroEvenOdd z = new ZeroEvenOdd(6);
		final PrintNumber p = new PrintNumber();
		
		Thread t1 = new Thread(new Runnable(){

			public void run() {
				try {
					z.zero(p);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}});

		Thread t2 = new Thread(new Runnable(){

			public void run() {
				try {
					z.even(p);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}});
		
		Thread t3 = new Thread(new Runnable(){

			public void run() {
				try {
					z.odd(p);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}});
		
		t1.setName("zero");
		t1.start();
		
		t2.setName("even");
		t2.start();
		
		t3.setName("odd");
		t3.start();
	}
	
}

class PrintNumber implements IntConsumer {

	public void accept(int value) {
		System.out.println(Thread.currentThread().getName() + "-" + value);
	}
	
}

class ZeroEvenOdd {
    private int n;
    private int i = 1;
    private final Object mutex = new Object();
    private int zeroFlag = 1;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
    	synchronized (mutex) {
        	while (i <= n) {
        		if (zeroFlag == 1) {
        			printNumber.accept(0);
        			zeroFlag = 0;
        			mutex.notifyAll();
        		} else {
        			mutex.wait(5);
        		}
        	} //end while
    	} //end synchronized
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
    	synchronized (mutex) {
        	while (i <= n) {
        		if (zeroFlag == 0 && (i % 2 > 0 || i == 1)) {
        			printNumber.accept(i);
        			zeroFlag = 1;
        			i++;
        			mutex.notifyAll();
        		} else {
        			mutex.wait(5);
        		}
        	} //end while
    	} //end synchronized
        
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
    	synchronized (mutex) {
        	while (i <= n) {
        		if (zeroFlag == 0 && (i % 2 == 0)) {
        			printNumber.accept(i);
        			zeroFlag = 1;
        			i++;
        			mutex.notifyAll();
        		} else {
        			mutex.wait(5);
        		}
        	} //end while
    	} //end synchronized
        
    }
}
