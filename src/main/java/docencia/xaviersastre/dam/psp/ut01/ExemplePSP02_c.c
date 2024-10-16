#include <stdio.h> 
int main() {
    FILE* fitxer;
    fitxer = fopen("sortida.txt","wt");
    fputs("Aquest text està generat pel procés escrit en C", fitxer);
    fclose(fitxer);
    return 0;
}