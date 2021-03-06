package ascension;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ImageMouseListener {


    public class ImagePane extends JPanel {

        private BufferedImage img;
        private Point imgPoint;

        public ImagePane() {
            try {
                img = ImageIO.read(new File("./img/Apprentice.jpg"));
                imgPoint = new Point(100, 100);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (img != null && imgPoint != null) {
                        Point me = e.getPoint();
                        Rectangle bounds = new Rectangle(imgPoint, new Dimension(img.getWidth(), img.getHeight()));
                        if (bounds.contains(me)) {
                            System.out.println("I was clicked!");
                        }
                    }
                }

            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null && imgPoint != null) {
                g.drawImage(img, imgPoint.x, imgPoint.y, this);
            }
        }

    }

}