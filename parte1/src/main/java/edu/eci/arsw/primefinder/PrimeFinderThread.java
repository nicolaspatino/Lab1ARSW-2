package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread{

	
	int a,b;
        private boolean running,paused=false;
	
	private List<Integer> primes=new LinkedList<Integer>();
	
	public PrimeFinderThread(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	  @Override
	public void run(){
        	while (a<b) {
        		if (paused) {
        			try {
        				synchronized(this) {
        					wait();
        				}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
        		}
        		if(isPrime(a)) {
        			primes.add(a);
        			
        		}
        		a++;
        	}
            running=false;
	}
	
	boolean isPrime(int n) {
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

	public List<Integer> getPrimes() {
		return primes;
	}

	public boolean running() {
		return running;
	}
	public void pause() {
		paused=true;
	}
	public void Resume() {
		paused=false;
		synchronized(this) {
			this.notify();
		}
		
	}
	
	
	
	
}
