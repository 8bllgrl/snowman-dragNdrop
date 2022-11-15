package screen;

import chara.Snowman;
import main.Game;
import util.AssetLoader;
import util.Broadcaster;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Playx extends ScreenState implements ScreenStateMethods {

    private Snowman snowman;
    private BufferedImage bgImage;
    private String BG_IMAGE_ROUTE = "/img/bgimg.jpg";

    private int cursorDifference_X;
    private int cursorDifference_Y;


    public Playx(Game game) {
        super(game);

        cursorDifference_X = 100;
        cursorDifference_Y = 15;
        initClasses();
        loadBackgroundImage();

        //load background image


    }

    private void loadBackgroundImage(){
        bgImage = AssetLoader.GetImageReader(BG_IMAGE_ROUTE);
    }

    private void initClasses() {
        snowman = new Snowman(300,300,2,2,this);
    }

    @Override
    public void update() {

        snowman.update();

    }

    @Override
    public void draw(Graphics2D g2) {
        drawBackground(g2);
        snowman.render(g2);

    }

    private void drawBackground(Graphics2D g2) {
        g2.drawImage(bgImage,0,0,800,700,null);
        g2.setColor(new Color(126, 120, 175, 174));
        g2.fillRect(0,0,800,700);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (snowman.isMouseOver()){
            snowman.setY(e.getY()+cursorDifference_Y+15);
        }


    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (snowman.isMouseOver()){
            snowman.setX(e.getX()-cursorDifference_X);
            snowman.setY(e.getY()+cursorDifference_Y);
            snowman.dragBounds(e,cursorDifference_X,cursorDifference_Y);

        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println(e.getX() + " "+ e.getY());
        snowman.setMouseOver(false);

        if (isIn(e,snowman)){
            snowman.setMouseOver(true);
//            Broadcaster.jingleString();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void resetSnowmanBooleans(){
        snowman.resetBools();
    }

}
