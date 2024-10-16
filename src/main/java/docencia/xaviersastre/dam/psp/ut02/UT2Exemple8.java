package docencia.xaviersastre.dam.psp.ut02;
public class UT2Exemple8 extends Thread {
    public void run() {
System.out.println("Dins del fil:" + this.getName() +
        ", prioritat: "+this.getPriority() +
        " ID: " + this.getId() );
    }
    //
    public static void main(String[] args) {
        UT2Exemple8 h = null;
        for (int i=0; i < 3; i++) {
            h = new UT2Exemple8();  //crear fil
            h.setName("FIL" + i);   //posam nom al fil
            h.setPriority(i + 1);   //posam prioritat
            h.start();              //iniciar fil
            System.out.println("Informació del " +
                    h.getName() + ": " + h.toString());
        }
            System.out.println("3 FILS CREATS...");
    }   // main
}       // clase
