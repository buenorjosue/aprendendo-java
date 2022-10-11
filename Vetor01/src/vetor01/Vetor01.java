package vetor01;

public class Vetor01 {

    public static void main(String[] args) {
       int n[] = {3,2,6,7,8,4};
       
        System.out.println("Valor de casas de N: " + n.length);
       for(int c = 0; c <=n.length-1; c++){
           System.out.println("Vetor na posição["+ c + "] Valor: " +n[c]);
       }
    }   
}
