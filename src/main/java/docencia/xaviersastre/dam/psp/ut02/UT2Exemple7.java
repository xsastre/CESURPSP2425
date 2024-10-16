package docencia.xaviersastre.dam.psp.ut02;

class CounterThread extends Thread {
    String name;
    public CounterThread(String name) {
        super();
        this.name = name;
    }
    public void run() {
        int count=0;
        while (true) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 1000)
                count = 0;
            System.out.println(name+":"+count++);
        }
    }
}
public class UT2Exemple7 {
    public static void main(String[] args) {
        CounterThread thread1 = new CounterThread("thread1");
        thread1.setPriority(10);
        CounterThread thread2 = new CounterThread("thread2");
        thread2.setPriority(1);
        thread2.start();
        thread1.start();
    }
}
