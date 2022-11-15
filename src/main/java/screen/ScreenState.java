package screen;

import chara.Snowman;
import main.Game;

import java.awt.event.MouseEvent;

public class ScreenState {

    protected Game game;

    public ScreenState(Game game){
        this.game = game;
    }

    public boolean isIn(MouseEvent e, Snowman snowman){
        return snowman.getBounds().contains(e.getX(),e.getY());
    }
}
