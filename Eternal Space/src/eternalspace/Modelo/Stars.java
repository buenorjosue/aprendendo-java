package eternalspace.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

public class Stars {

    private Image imagem;
    private int x, y;
    private int largura, altura;
    boolean isVisivel;//Quando o tiro chegar no limite ou bater no inimigo sumir

    //private static final int LARGURA = 938;
    private static int VELOCIDADE = 4;//velocidade do tiro

    public Stars(int x, int y) {//x e y da posição do jogador
        this.x = x;
        this.y = y;
        isVisivel = true;
    }

    public void load() {
        ImageIcon referencia = new ImageIcon("res\\star.png");
        imagem = referencia.getImage();

        this.largura = getImagem().getWidth(null);
        this.altura = getImagem().getHeight(null);
    }

    public void update() {
        if (this.x < 0) {
            this.x = largura;
            Random a = new Random();
            int m = a.nextInt(500);
            this.x = m + 1024;
            Random r = new Random();
            int n = r.nextInt(768);
            this.y = n;
        } else {
            this.x -= getVELOCIDADE();
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isIsVisivel() {
        return isVisivel;
    }

    public void setIsVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int aVELOCIDADE) {
        VELOCIDADE = aVELOCIDADE;
    }

    public Image getImagem() {
        return imagem;
    }

}
