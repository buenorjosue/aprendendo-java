package vetor03;

import java.util.Arrays;

public class Vetor03 {

    public static void main(String[] args) {
        int vet[] = {6, 3, 9, 1 ,4 , 5, 0};
        for(int valor: vet){
            System.out.print(valor + " ");
        }
        System.out.println("");
        int p = Arrays.binarySearch(vet, 1);
        System.out.println("Encontrei o 1 na posição[" + p + "]");
    }    
}
