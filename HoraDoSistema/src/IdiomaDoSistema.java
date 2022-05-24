import java.util.Locale;

public class IdiomaDoSistema {
    public static void main(String[] args) {
        Locale idioma = Locale.getDefault();
        System.out.print("O seu sistema está em: ");
        System.out.print(idioma.getDisplayLanguage());
    }
}
