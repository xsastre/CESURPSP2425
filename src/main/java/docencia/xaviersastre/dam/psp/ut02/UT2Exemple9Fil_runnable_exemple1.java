package docencia.xaviersastre.dam.psp.ut02;
public class UT2Exemple9Fil_runnable_exemple1 {
	public static class elmeuRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("Print des del fil secundari");
		}
	}
	public static void main(String[] args) {
		Thread fil1=new Thread(new elmeuRunnable());
		fil1.start();
		System.out.println("Print des del fil principal");
	}
	

}
