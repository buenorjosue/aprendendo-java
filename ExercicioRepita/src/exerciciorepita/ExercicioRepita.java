package exerciciorepita;
import javax.swing.JOptionPane;

public class ExercicioRepita {

    public static void main(String[] args) {
        int n, soma = 0, media;
        int par = 0, impar = 0, mcem = 0, cont = 0;
        do{
           n = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe um número: (Valor 0 interrompe!)"));
          if (n%2 == 0){
              par++;
          }
          else{
              impar++;
          }
          soma += n;
          cont++; 
          if (n > 100){
              mcem++;
          }
        }while(n != 0);
        par -= 1;
        media = soma/(cont-1);
        JOptionPane.showMessageDialog(null, "<html>Resultado final <br><hr>" + "Numero de pares foi: " + par + "<br>Numero de impares foi: " + impar + 
                "<br>Total de numeros digitados: " + cont + "<br>Acima de 100: " + mcem + "<br>A media dos valores foi: " + media + "</html>");
    }  
}
