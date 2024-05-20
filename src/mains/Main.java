package src.mains;

import java.awt.*;
import javax.swing.*;

import src.mains.panels.MainMenuPanel;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Michael vs Lalapan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1280, 720));
        frame.setResizable(false);

        // Load your image file and create an ImageIcon object
        ImageIcon icon = new ImageIcon("src/assets/icon.png");

        // Set the icon of the JFrameaaawaa
        frame.setIconImage(icon.getImage());

        frame.add(MainMenuPanel.getInstance());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}