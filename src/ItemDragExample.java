import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ItemDragExample extends JFrame {
    private JPanel panel;
    private JLabel item;

    private int xOffset, yOffset;

    public ItemDragExample() {
        setTitle("Item Drag Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        panel = new JPanel();
        panel.setLayout(null); // We'll use absolute positioning
        panel.setBackground(Color.WHITE);

        item = new JLabel("Item");
        item.setSize(50, 50);
        item.setLocation(100, 100);
        item.setOpaque(true);
        item.setBackground(Color.RED);

        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Calculate the offset from the top-left corner of the item
                xOffset = e.getX();
                yOffset = e.getY();
            }
        });

        item.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Update item position based on mouse movement
                int x = e.getXOnScreen() - xOffset;
                int y = e.getYOnScreen() - yOffset;
                item.setLocation(x, y);
            }
        });

        panel.add(item);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ItemDragExample();
    }
}