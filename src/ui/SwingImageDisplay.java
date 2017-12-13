package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import model.ImagePrincipal;

import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel implements MostrarImage {
    private ImagePrincipal currentImage;
    
    @Override
    public void paint(Graphics g){
        if(currentImage ==null) return;
        g.drawImage(imageOf(currentImage),0,0,null);
    }
    
    @Override
    public ImagePrincipal current() {
        return currentImage;
    }

    @Override
    public void show(ImagePrincipal image) {
        this.currentImage = image;
        this.repaint();
    }

    private BufferedImage imageOf(ImagePrincipal i) {
    try{
        return ImageIO.read(i.stream());
    }catch(java.io.IOException e){
        e.printStackTrace();
        return null;
        }
    }  
}
