package main;

import javax.swing.*;
import java.awt.*;

public class GameWindow {

    private JFrame jFrame;

    public GameWindow(GamePainter gamePainter){
        jFrame = new JFrame();

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePainter);

        jFrame.setResizable(false);
        jFrame.setPreferredSize(new Dimension(950, 740));
        jFrame.setSize(800, 700);
        jFrame.setTitle("2D Demo");

        jFrame.setBackground(Color.black);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
