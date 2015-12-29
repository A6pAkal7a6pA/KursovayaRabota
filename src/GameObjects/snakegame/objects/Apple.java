package GameObjects.snakegame.objects;

import gm.snakegame.SnakeGame;

public class Apple {
    public int posX;
    public int posY;

    SnakeGame main;

    public Apple(int startX, int startY){
        posX = startX;
        posY = startY;
    }

    public void  setRandomPosition() {
        posX = (int) (Math.random()*main.WIDTH);
        posY = (int) (Math.random()*main.WIDTH);


    }
}
