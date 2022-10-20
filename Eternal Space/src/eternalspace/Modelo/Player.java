package eternalspace.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Player implements ActionListener {

    private int x, y;
    private int dx, dy;
    private Image imagem;
    private int altura, largura;
    private List<Tiro> tiros;   //tiros são imprevisiveis então criamos uma lista para alocar infinitos tiros 
    private boolean isVisivel;
    private boolean isTurbo;
    private Timer timer;

    public Player() {
        this.x = 100;
        this.y = 100;//definindo a coordenada que o player vai estar
        isVisivel = true;
        isTurbo = false;

        tiros = new ArrayList<Tiro>();

        timer = new Timer(3000, this);//velocidade do jogo
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isIsTurbo() == true) {
            turbo();
            setIsTurbo(false);
        }

        if (isIsTurbo() == false) {
            load();
        }
    }

    public void load() {//metodo para carregar a imagem do player no jogo
        ImageIcon referencia = new ImageIcon("res\\nave2.png");
        imagem = referencia.getImage();

        altura = getImagem().getHeight(null);
        largura = getImagem().getWidth(null);
    }

    public void update() {//metodo para fazer com que a imagem se mova
        x += dx;
        y += dy;
    }

    public void tiro() {
        this.getTiros().add(new Tiro((int) (x + (largura / 1.5)), y + (altura / 4)));
    }

    public void turbo() {
        setIsTurbo(true);
        ImageIcon referencia = new ImageIcon("res\\turbo.png");
        imagem = referencia.getImage();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, (int) (largura / 2.5), (int) (altura / 2.5));
    }

    public void keyPressed(KeyEvent tecla) {//detecção de tecla apertada
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_SHIFT) {//aciona o turbo
            turbo();
        }

        if (codigo == KeyEvent.VK_SPACE) {//da o tiro
            if (isTurbo == false) {
                tiro();
            }
        }

        if (codigo == KeyEvent.VK_UP) {//para mover para cima
            dy = -3;
        }

        if (codigo == KeyEvent.VK_DOWN) {//para mover para baixo
            dy = 3;
        }

        if (codigo == KeyEvent.VK_LEFT) {//mover para esquerda
            dx = -3;
        }

        if (codigo == KeyEvent.VK_RIGHT) {//mover para direita
            dx = 3;
        }
    }

    public void keyRealease(KeyEvent tecla) {//detecção de tecla apertada
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (codigo == KeyEvent.VK_DOWN) {
            dy = 0;
        }

        if (codigo == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (codigo == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }

    public List<Tiro> getTiros() {
        return tiros;
    }

    public boolean isIsVisivel() {
        return isVisivel;
    }

    public void setIsVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public boolean isIsTurbo() {
        return isTurbo;
    }

    public void setIsTurbo(boolean isTurbo) {
        this.isTurbo = isTurbo;
    }

}
