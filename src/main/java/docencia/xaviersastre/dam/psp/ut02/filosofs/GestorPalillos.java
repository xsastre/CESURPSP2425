package docencia.xaviersastre.dam.psp.ut02.filosofs;

public class GestorPalillos {
    boolean palilloLliure[];
    public GestorPalillos(int numPalillos)
    {
        palilloLliure =new  boolean[numPalillos];
        for (int i=0; i<numPalillos; i++){
            palilloLliure[i]=true;
        }   //Fi for
    }       //Fi constructor
    public synchronized boolean intentarAgafarPalillos(int pos1, int pos2)
    {
        boolean sAconsegueix=false;
        if (
                (palilloLliure[pos1])
                        &&
                        (palilloLliure[pos2]) )
        {
            palilloLliure[pos1]=false;
            palilloLliure[pos2]=false;
            sAconsegueix=true;
        } //Fin del if
        return sAconsegueix;
    }

    public void alliberarPalillos(int pos1, int pos2)
    {
        palilloLliure[pos1]=true;
        palilloLliure[pos2]=true;
    }
}
