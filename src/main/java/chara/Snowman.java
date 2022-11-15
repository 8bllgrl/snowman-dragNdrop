package chara;

import screen.Playx;
import screen.ScreenState;
import util.AssetLoader;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Snowman extends EntityBeing {
    private int width, height;
    private int headWidth, headHeight;
    private int bodyWidth, bodyHeight;
    private int x_head;
    private int y_head; // equals y + ...
    private int x_body;
    private int y_body; // equals y + ...
    private int x_difference = 35, y_difference = 100;
    public static final String SNOWMAN_HEAD_IMAGE = "/img/sm_head.png";
    public static final String SNOWMAN_BODY_IMAGE = "/img/sm_body.png";
    private BufferedImage head;
    private BufferedImage body;
    private Rectangle bounds;
    private int bounds_X, bounds_Y;
    private int bounds_w, bounds_h;
    private Color boundsColor;
    private Color boundsGreen = new Color(29, 220, 140, 147);
    private Color boundsRed= new Color(220, 29, 29, 147);
    private Color shadowColor = new Color(70, 70, 70, 50);
    private int shadowDifference;
    private Playx playx;
    private int movementSpeed;

    private boolean mouseOver, mousePressed;

    public Snowman(int x, int y, int width, int height, Playx playx) {
        super(x, y);
        loadSnowmanImages();

//        this.width = body.getWidth()/width;
//        this.height = body.getHeight()/height;

        this.width = width;
        this.height = height;

        this.headWidth = head.getWidth() / width;
        this.headHeight = head.getHeight() / height;
        this.bodyWidth = body.getWidth() / width;
        this.bodyHeight = body.getHeight() / height;

        bounds_X = x;
        bounds_Y = y - y_difference;
        bounds_w = bodyWidth;
        bounds_h = bodyHeight + (headHeight - x_difference)+10;
        initBounds();



        this.movementSpeed = 2;

        this.playx = playx;

    }

    public void update() {

        //if picked up

        updatePosition();
        updateBoundsPosition();

    }

    private void updateShadowPosition(){

    }

    private void updateBoundsPosition() {
        bounds.setBounds(bounds_X,bounds_Y,bounds_w,bounds_h);
    }

    public void updatePosition() {

        int xSpeed = 0;
        xSpeed += movementSpeed;


//        updateXPosition(xSpeed);

    }

    private void updateXPosition(int xSpeed) {

        //this method moves both at the same time.
        x += xSpeed;
        x_head += xSpeed;

    }

    public void render(Graphics2D g2) {
        drawShadowUnder(g2);

        g2.drawImage(body, x, y, bodyWidth, bodyHeight, null);
        g2.drawImage(head, x+x_difference, y-y_difference, headWidth, headHeight, null);

//        drawBoundsTest(g2);
    }

    private void drawShadowUnder(Graphics2D g2) {
        g2.setColor(shadowColor);
        g2.fillOval(x,y+bodyHeight+shadowDifference,bodyWidth,20);
    }

    private void drawBoundsTest(Graphics2D g2){

        if (mouseOver){
            setBoundsColor(boundsRed);
        } else {
            setBoundsColor(boundsGreen);
        }
        g2.setColor(boundsColor);
        g2.fillRect((int) bounds.getX(), (int) bounds.getY(), (int) bounds.getWidth(), (int) bounds.getHeight());

    }

    public void setBoundsColor(Color boundsColor) {
        this.boundsColor = boundsColor;
    }

    private void loadSnowmanImages() {
        head = AssetLoader.GetImageReader(SNOWMAN_HEAD_IMAGE);
        body = AssetLoader.GetImageReader(SNOWMAN_BODY_IMAGE);
        System.out.println("snowman image loaded");
    }

    private void initBounds() {
        bounds = new Rectangle(bounds_X,bounds_Y,bounds_w,bounds_h);
        setBoundsColor(boundsGreen);
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }
    public boolean isMouseOver() {
        return mouseOver;
    }

    public int getHeadWidth() {
        return headWidth;
    }

    public void setHeadWidth(int headWidth) {
        this.headWidth = headWidth;
    }

    public int getHeadHeight() {
        return headHeight;
    }

    public void setHeadHeight(int headHeight) {
        this.headHeight = headHeight;
    }

    public int getBodyWidth() {
        return bodyWidth;
    }

    public void setBodyWidth(int bodyWidth) {
        this.bodyWidth = bodyWidth;
    }

    public int getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(int bodyHeight) {
        this.bodyHeight = bodyHeight;
    }

    public int getX_head() {
        return x_head;
    }

    public void setX_head(int x_head) {
        this.x_head = x_head;
    }

    public int getY_head() {
        return y_head;
    }

    public void setY_head(int y_head) {
        this.y_head = y_head;
    }

    public int getX_difference() {
        return x_difference;
    }

    public void setX_difference(int x_difference) {
        this.x_difference = x_difference;
    }

    public int getY_difference() {
        return y_difference;
    }

    public void setY_difference(int y_difference) {
        this.y_difference = y_difference;
    }



    public Rectangle getBounds() {
        return bounds;
    }



    public void dragBounds(MouseEvent e, int cursorDifference_X, int cursorDifference_Y){
        bounds_X = e.getX()-cursorDifference_X;
        bounds_Y = e.getY()-25;
    }


    public void resetBools() {
        mouseOver = false;
        mousePressed = false;
    }




}
