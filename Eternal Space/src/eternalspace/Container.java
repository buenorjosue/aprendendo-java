package eternalspace;

import eternalspace.Modelo.Fase;
import javax.swing.JFrame;

public class Container extends JFrame {

    public Container() {
        add(new Fase());
        setTitle("Eternal Space");//titulo do jogo
        setSize(1024, 728); //tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//para fechar quando clicar no x
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Container();
    }
}
