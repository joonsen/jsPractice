package thread;

public class SyncEx {
	public static Bank b = new Bank();
	
	public SyncEx() {
		for(int i=0; i<100; i++) {
			OutThread ot = new OutThread();
			ot.start();
		}
	}
	
	public static void main(String[] args) {
		new SyncEx();
	}
	
	class OutThread extends Thread {
		public void run() {
			int amt = (int)(Math.random()*100);
			System.out.print(this.getName() + " ");
			b.output(this.getName(), amt);
			
		}
	}
}













