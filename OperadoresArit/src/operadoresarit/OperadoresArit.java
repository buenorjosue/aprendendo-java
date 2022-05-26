/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operadoresarit;

/**
 *
 * @author marci
 */
public class OperadoresArit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n1 = 3;
        int n2 = 5;
        float m = (n1 + n2)/2;
        System.out.println("A média é: " + m);
        
        int numero = 5;
        int valor = 5 + numero--;
        System.out.println(valor);
        System.out.println(numero);
        
        int x = 4;
        x *= 2;
        System.out.println(x);
        
        float v = 8.4f;
        int ar = (int) Math.round(v);
        System.out.println(ar);
        
        double ran = Math.random();
        int n = (int) (0 + ran *(100-0));
        System.out.println(n);
    }
    
}
