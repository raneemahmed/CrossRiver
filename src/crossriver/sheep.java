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

/**
 *
 * @author yarae
 */
public class sheep extends Harbivore{
        private int xf;
        private int yf;

    @Override
    public BufferedImage[] getImages() {
        BufferedImage img[] = new BufferedImage[2];;
     try {
         img[0] = ImageIO.read(new File("sheep.png"));
         img[1]= ImageIO.read(new File("sheepflip.png"));
     } catch (IOException ex) {
         Logger.getLogger(Plant.class.getName()).log(Level.SEVERE, null, ex);
     }
        

        return img;
    }
     @Override
    public double getWeight() {
       return 20.0;
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
        return xf; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getypos() {
       return yf; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setXf(int xf) {
            this.xf = xf;      
        
    }
    @Override
    public void setYf(int yf) {
         this.yf = yf; //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
}
