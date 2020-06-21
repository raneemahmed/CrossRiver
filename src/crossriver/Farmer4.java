/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossriver;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Israa Hassanin
 */
public class Farmer4 implements ICrosser {
private int xf;
private int yf;
    @Override
    public boolean canSail() {
        return true;
    }

    @Override
    public double getWeight() {
        return 40.0;
    }

    @Override
    public int getEatingRank() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BufferedImage[] getImages() {
        BufferedImage img[] = new BufferedImage[2];;
     try {
         img[0] = ImageIO.read(new File("farmergirl.png"));
         img[1]= ImageIO.read(new File("farmergirlflip.png"));
     } catch (IOException ex) {
         Logger.getLogger(Plant.class.getName()).log(Level.SEVERE, null, ex);
     }
        /*ImageIcon b[] = new ImageIcon[2];
        b[0] = new ImageIcon("farmergirl.png");
        b[1] = new ImageIcon("farmergirlflip.png");*/
        return img; 
    }

    @Override
    public ICrosser makeCopy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLabelToBeShown(String label) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLabelToBeShown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getxpos() {
        return xf;
    }

    @Override
    public int getypos() {
        return yf;
    }

    @Override
    public void setXf(int xf) {
         this.xf = xf;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setYf(int yf) {
         this.yf = yf;
    }
    
}
