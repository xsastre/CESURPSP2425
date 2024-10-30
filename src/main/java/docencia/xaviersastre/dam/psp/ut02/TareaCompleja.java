package docencia.xaviersastre.dam.psp.ut02;

class TareaCompleja implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<100;i++){
            int a=i*3;
        }
        Thread hiloActual=Thread.currentThread();
        String miNombre=hiloActual.getName();
        System.out.println(
                "Finalizado el hilo"+miNombre);
    }
}