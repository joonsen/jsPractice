package thread;

public class Bank {
	int amt = 1000;
	public synchronized void output(String n, int a) {		//synchonize가 붙어있으면 method 자체를 한놈밖에 못들어와
		if(amt>=a) {
			try {
				Thread.sleep(100);
				amt -= a;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(n + " >>> ");
		System.out.printf("출금:%5d, 잔액:%5d\n",a,amt);
	}
	//잔여백신 예약 같은 상황에 동기화를 안해놓으면, 여분백신 100개에 예약자가 1000명인 재앙이 발생할수도 있음
	//금융과 관련된 프로그램은 욕먹는다고 해결되는게 아냐. 무조건 동기화 쓰레드에서 가장 중요한것은 동기화
	//상호협조적 동기화보단 상호배타적 동기화가 훨씬 많이쓰임
}
