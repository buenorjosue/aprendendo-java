import java.awt.*;

public class ResolucaoDoSistema {
    public static void main(String[] args) {
        Toolkit tk;
        tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        System.out.print("Sua resolução é de "+d.width);
        System.out.println(" X "+d.height);
    }
}