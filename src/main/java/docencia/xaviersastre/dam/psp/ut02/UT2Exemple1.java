package docencia.xaviersastre.dam.psp.ut02;
class UT2Exemple1 implements Runnable {
    Thread t;
    UT2Exemple1 () {
        t = new Thread(this, "Nou Thread");
        System.out.println("Creat fil: " + t);
        t.start(); // Arrenca el nou fill d’execució. Executa run
    }
    public void run() {
        System.out.println("Hola des del fil creat!");
        System.out.println("Fil finalitzant.");
    }
}
class RunThread {
    public static void main(String args[]) {
        new UT2Exemple1(); // Crea un nou fil d’execució
        System.out.println("Hola des del fil principal!");
        System.out.println("Procés acabant.");
    }
}
