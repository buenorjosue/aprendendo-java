package eternalspace.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {

    private final Image fundo;
    private Player player;
    private Timer timer;
    private List<Enemy1> enemy1;
    private List<Stars> stars;
    private boolean emJogo;
    int killcount;


    public Fase() {

        setFocusable(true);
        setDoubleBuffered(true);//melhorar desempenho

        ImageIcon referencia = new ImageIcon("res\\bcg1.png");//recebe uma imagem que vai ser o fundo
        fundo = referencia.getImage();

        player = new Player();
        player.load();

        addKeyListener(new TecladoAdapter());

        timer = new Timer(5, this);//velocidade do jogo
        timer.start();

        inicializaInimigos();
        inicializaStars();
        emJogo = true;
    }

    public void inicializaInimigos() {
        int coordenadas[] = new int[20];//quantidade de inimigos
        enemy1 = new ArrayList<Enemy1>();

        for (int i = 0; i < coordenadas.length; i++) {
            int x = (int) (Math.random() * 8000 + 1024);//Escolhe um número aleatorio sempre que surgir um novo inimigo, gera aleatorio eles;
            int y = (int) (Math.random() * 450 + 30);
            enemy1.add(new Enemy1(x, y));
        }
    }

    public void inicializaStars() {
        int coordenadas[] = new int[5];//quantidade de estrelas
        stars = new ArrayList<Stars>();

        for (int i = 0; i < coordenadas.length; i++) {
            int x = (int) (Math.random() * 1024 + 0);//Escolhe um número aleatorio sempre que surgir um novo inimigo, gera aleatorio eles;
            int y = (int) (Math.random() * 768 + 0);
            stars.add(new Stars(x, y));
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        if (emJogo == true) {
            graficos.drawImage(fundo, 0, 0, null);//pintando o fundo da tela

            for (int u = 0; u < stars.size(); u++) {
                Stars q = stars.get(u);
                q.load();
                graficos.drawImage(q.getImagem(), q.getX(), q.getY(), this);
            }

            graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

            List<Tiro> tiros = player.getTiros();//pegando a lista e colocando na fase
            for (int i = 0; i < tiros.size(); i++) {
                Tiro m = tiros.get(i);
                m.load();
                graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
            }

            for (int o = 0; o < enemy1.size(); o++) {
                Enemy1 in = enemy1.get(o);
                in.load();
                graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
            }
        } else {
            ImageIcon fimJogo = new ImageIcon("res\\gameover.png");//inserindo a tela de gameover
            graficos.drawImage(fimJogo.getImage(), 0, 0, null);
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {//metodo que atualiza a tela enquanto a nave se mexe
        player.update();

        if (player.isIsTurbo() == true) {
            timer.setDelay(1);
        }

        if (player.isIsTurbo() == false) {
            timer.setDelay(5);
        }

        for (int u = 0; u < stars.size(); u++) {
            Stars on = stars.get(u);
            if (on.isVisivel) {
                on.update();
            } else {
                stars.remove(u);
            }
        }

        List<Tiro> tiros = player.getTiros();//pegando a lista e colocando na fase
        for (int i = 0; i < tiros.size(); i++) {
            Tiro m = tiros.get(i);
            if (m.isIsVisivel()) {
                m.update();
            } else {
                tiros.remove(i);
            }
        }

        for (int o = 0; o < enemy1.size(); o++) {
            Enemy1 in = enemy1.get(o);
            if (in.isIsVisivel()) {
                in.update();//inimigo vai andar
            } else {
                enemy1.remove(o);
            }
        }

        checarColisoes();
        repaint();
    }

    public void checarColisoes() {
        Rectangle formaNave = player.getBounds();
        Rectangle formaEnemy1;
        Rectangle formaTiro;

        for (int i = 0; i < enemy1.size(); i++) {
            Enemy1 tempEnemy1 = enemy1.get(i);
            formaEnemy1 = tempEnemy1.getBounds();
            if (formaNave.intersects(formaEnemy1)) {
                if (player.isIsTurbo() == true) {
                    tempEnemy1.setIsVisivel(false);
                } else {
                    player.setIsVisivel(false);
                    tempEnemy1.setIsVisivel(false);
                    emJogo = false;
                }
            }
        }

        List<Tiro> tiros = player.getTiros();
        for (int j = 0; j < tiros.size(); j++) {
            Tiro tempTiro = tiros.get(j);
            formaTiro = tempTiro.getBounds();
            for (int k = 0; k < enemy1.size(); k++) {
                Enemy1 tempEnemy1 = enemy1.get(k);
                formaEnemy1 = tempEnemy1.getBounds();
                if (formaTiro.intersects(formaEnemy1)) {
                    tempEnemy1.setIsVisivel(false);
                    tempTiro.setIsVisivel(false);
                    killcount++;
                }
            }
        }
    }

    private class TecladoAdapter extends KeyAdapter {//metodo de entrada de teclado

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyRealease(e);
        }
    }
}
