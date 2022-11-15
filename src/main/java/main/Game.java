package main;

import screen.Playx;

import java.awt.*;

public class Game implements Runnable{

    private GameWindow gameWindow;
    private GamePainter gamePainter;
    private Thread gameThread;
    private final int FPS = 60;
    private final int UPS = 60;

    private Playx playx;

    public Game() {
        initClasses();

        gamePainter = new GamePainter(this);
        gameWindow = new GameWindow(gamePainter);
        gamePainter.setFocusable(true);
        gamePainter.requestFocus();

        startGameLoop();
    }


    public void render(Graphics2D g2) {
        playx.draw(g2);
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    private void initClasses() {
        playx = new Playx(this);
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS;
        double timePerUpdate = 1000000000.0 / UPS;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaUpdates = 0;
        double deltaFrames = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaUpdates += (currentTime - previousTime) / timePerUpdate;
            deltaFrames += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaUpdates >= 1) {
                update();
                updates++;
                deltaUpdates--;
            }

            if (deltaFrames >= 1) {
                gamePainter.repaint();
                frames++;
                deltaFrames--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;

            }
        }
    }

    public void update() {
        playx.update();
    }

    public Playx getPlayx() {
        return playx;
    }
}
