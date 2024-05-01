package test1;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ImageTest extends JFrame{
    private ImageIcon image1;
    private JLabel label1;
    private ImageIcon image2;
    private JLabel label2;    

    public ImageTest(){
        setLayout(new FlowLayout());
        image1 = new ImageIcon(getClass().getResource("peashooter.png"));
    
        label1 = new JLabel(image1);
        add(label1);
    }
    
    public static void main(String[] args){
        ImageTest gui = new ImageTest();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.pack();
    }
    
        
}
