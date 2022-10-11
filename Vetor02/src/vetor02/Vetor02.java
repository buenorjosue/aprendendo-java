package vetor02;

import java.util.Arrays;

public class Vetor02 {

    public static void main(String[] args) {
        double vet[] = {2.5, 9, 3.75, -6.9};
        Arrays.sort(vet);
        for(double valor: vet){
            System.out.print(valor + " ");
        }
    }    
}
