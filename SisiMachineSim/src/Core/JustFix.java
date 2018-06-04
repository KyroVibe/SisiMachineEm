package Core;

public class JustFix implements Runnable {
	
	private Thread t;
	
	public void Start() {
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		try {
			t.sleep((long) 2.0);
		} catch (InterruptedException e) { }
		
		Main.inst.JankSolution();
		
		Stop();
	}
	
	public void Stop() {
		try {
			t.join();
		} catch (InterruptedException e) { }
	}

}
