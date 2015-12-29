package gm.snakegame;

import GameObjects.snakegame.objects.Apple;
import GameObjects.snakegame.objects.Snake;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.imageio.*;
import java.io.*;


@SuppressWarnings("serial")
public class SnakeGame extends JPanel implements ActionListener {
  //  Menu menu = new Menu();

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int SPEED = 5;
    public static int count = 0;
    public static Frame menuf;
    Apple a = new Apple((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT));
    Snake s = new Snake(10, 10, 9, 10);
    Timer t = new Timer(1000 / SPEED, this);

    Image img = null;
    public SnakeGame() {

        //while (button1)
        t.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
        try{
        img = ImageIO.read(new File ("plot.png"));
    } catch (IOException e) {
            e.printStackTrace();
        }
        }


    public void paint(Graphics g) {
        g.setColor(color(5, 50, 10));
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        g.setColor(color(255, 216, 0));
        g.drawImage(img, 20, 20, null);


        for (int xx = 0; xx <= WIDTH * SCALE; xx += SCALE) {
            g.drawLine(xx, 0, xx, HEIGHT * SCALE);
        }
        for (int yy = 0; yy <= HEIGHT * SCALE; yy += SCALE) {
            g.drawLine(0, yy, WIDTH * SCALE, yy);
        }

        for (int d = 0; d < s.length; d++) {
            g.setColor(color(20, 30, 150));
            g.fillRect(s.snakeX[d] * SCALE +1, s.snakeY[d] * SCALE + 1, SCALE - 1, SCALE - 1);
        }
        g.setColor(color(255, 0, 0));
        g.fillRect(a.posX * SCALE + 1, a.posY * SCALE + 1, SCALE - 1, SCALE - 1);
    }

    public Color color(int red, int green, int blue) {

        return new Color(red, green, blue);
    }

    public static void main(String[] args) {

        JFrame f = new JFrame();
        menuf = f;
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(WIDTH * SCALE + 7, HEIGHT * SCALE + 29);
        f.setLocationRelativeTo(null);
        f.add(new SnakeGame());
      //  f.add(new Menu());
        f.setTitle("SnakeGame");
        f.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        s.move();
        if ((s.snakeX[0] == a.posX) & (s.snakeY[0] == a.posY)) {
            a.setRandomPosition();
            s.length++;
            count++;
            // JFrame jf = (JFrame) this.getParent();
            menuf.setTitle("SnakeGame Максимальный счет: " + Integer.toString(count));

           // jf.add();
        }
        for (int k = 1; k < s.length; k++) {
            if ((s.snakeX[0] == a.posX) & (s.snakeY[0] == a.posY)) {
                a.setRandomPosition();

            }
            if ((s.snakeX[0] == a.posX) & (s.snakeY[0] == a.posY)) {
                a.setRandomPosition();
                s.length++;

            }
        }
        repaint();
    }

    private class Keyboard extends KeyAdapter {
        public void keyPressed(KeyEvent kEvt) {
            int key = kEvt.getKeyCode();

            if ((key == KeyEvent.VK_RIGHT) & s.direction != 2)
                s.direction = 0;


            if ((key == KeyEvent.VK_DOWN) & s.direction != 3)
                s.direction = 1;

            if ((key == KeyEvent.VK_LEFT) & s.direction != 0)
                s.direction = 2;
            if ((key == KeyEvent.VK_UP) & s.direction != 1)
                s.direction = 3;
            if ((key == KeyEvent.VK_ENTER))
                System.out.println("Hello World");

        }

    }
}
