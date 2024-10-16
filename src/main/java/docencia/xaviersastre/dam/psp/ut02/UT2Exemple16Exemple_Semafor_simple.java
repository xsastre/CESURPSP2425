package docencia.xaviersastre.dam.psp.ut02;

public class UT2Exemple16Exemple_Semafor_simple {
	private boolean signal = false;

	public synchronized void take() {
		this.signal = true;
		this.notify();
	}

	public synchronized void release() throws InterruptedException{
		while(!this.signal) wait();
		this.signal = false;
	}

}