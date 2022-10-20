package thread;

public class ThreadEx {

	public void test1() {
		System.out.println("thread 테스트 시작");
		T t1 = new T();
		T t2 = new T();
		T t3 = new T();
		t1.start();
		t2.start();
		t3.start();
		System.out.println("Thread 테스트 종료");
		
	}
	public void test2() {
		R r1 = new R();
		R r2 = new R();
		R r3 = new R();
		
		Thread t1 = new Thread(new R());
		Thread t2 = new Thread(new R());
		Thread t3 = new Thread(new R());
		System.out.println("[스레드 테스트 시작]");
		t1.start();
		t2.start();
		t3.start();
		System.out.println("[스레드 테스트 종료]");
	}
	public void test3() {	//daemon main thread가 종료되면 작업 thread는 그시점 무조건 종료되게끔..
		T t1 = new T();
		System.out.println("메인 스레드 시작...");
		t1.setDaemon(true);
		t1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("메인 스레드 종료...");
	}	//입출력과 관련된 스레드를 만들땐 setDaemon을 만들어주는게 안전.안그러면 usb를 뽑았는데도 작업thread가 종료가 안될수도
	
	public void test4() {//join 작업thread가 끝날때까지 main thread가 기다려줌
		System.out.println("메인스레드 시작");
		
		T t1 = new T();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("메인스레드 종료");
	}
	
	public static void main(String[] args) {
		new ThreadEx().test4();
	}
}

class T extends Thread{
	@Override
	public void run() {				//run method 재정의
		for(int i=0; i<200; i++) {
			System.out.print(this.getName() + " T ");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}	

class R implements Runnable{

	@Override
	public void run() {
		for(int i=1; i<=200; i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}	
	
}



















