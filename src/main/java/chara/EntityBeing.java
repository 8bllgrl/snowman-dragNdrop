package chara;

public abstract class EntityBeing {
    protected int x, y;
    protected int animationTick, animationIndex;

    public EntityBeing(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getAnimationIndex() {
        return animationIndex;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
