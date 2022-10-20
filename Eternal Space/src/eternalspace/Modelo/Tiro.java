package eternalspace.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Tiro {

    private Image imagem;
    private int x, y;
    private int largura, altura;
    private boolean isVisivel;//Quando o tiro chegar no limite ou bater no inimigo sumir

    private static final int LARGURA = 938;
    private static int VELOCIDADE = 5;//velocidade do tiro

    public Tiro(int x, int y) {//x e y da posição do jogador
        this.x = x;
        this.y = y;
        isVisivel = true;
    }

    public void load() {
        ImageIcon referencia = new ImageIcon("res\\tiro.png");
        imagem = referencia.getImage();

        this.largura = getImagem().getWidth(null);
        this.altura = getImagem().getHeight(null);
    }

    public void update() {
        this.x += getVELOCIDADE();
        if (this.getX() > LARGURA) {
            setIsVisivel(false);
        }
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y, (int) (largura/2.5),(int) (altura/2.5));
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
