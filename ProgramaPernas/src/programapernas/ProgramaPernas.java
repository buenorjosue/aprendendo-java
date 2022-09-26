package programapernas;

import java.util.Scanner;

public class ProgramaPernas {
    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in);
        System.out.print("Quantas Pernas??  ");
        int perna = Keyboard.nextInt();
        String tipo;
        System.out.print("Isso é um(a): ");      
        
        switch (perna){
            case 1:
                tipo = "Saci";
                break;
            case 2:
                tipo = "Bípede";
                break;
            case 4:
                tipo = "Quadrúpede";
                break;
            case 6, 8:
                tipo = "Aracnídeo";
                break;
            default:
                tipo = "ET";
        }
        System.out.println(tipo);
    } 
}
