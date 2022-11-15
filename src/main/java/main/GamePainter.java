package main;

import util.AssetLoader;
import util.MouseInputs;

import javax.swing.*;
import java.awt.*;


public class GamePainter extends JPanel {
    private MouseInputs mouseInputs;
    private Game game;

    public final static int GAME_WIDTH = 800;
    public final static int GAME_HEIGHT = 800;

    public GamePainter(Game game){
        mouseInputs = new MouseInputs(this);
        this.game = game;
        setPanelSize();
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
        game.render(g2);


        //stays at bottom
        g2.dispose();
    }

    public Game getGame() {
        return game;
    }
}
