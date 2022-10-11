package testefuncao01;

public class TesteFuncao01 {
    
    static int soma(int a, int b){
        int s = a + b;
        return s;
    }

    public static void main(String[] args) {
       int sm = soma(4,2);
        System.out.println("A soma é: " + sm);
    }   
}
