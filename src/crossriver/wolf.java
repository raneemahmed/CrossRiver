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
public class wolf extends Carnivore{
      private int xf;
        private int yf;
    @Override
    public BufferedImage[] getImages() {
        BufferedImage img[] = new BufferedImage[2];;
     try {
         img[0] = ImageIO.read(new File("wolfflip.png"));
         img[1]= ImageIO.read(new File("wolf.png"));
     } catch (IOException ex) {
         Logger.getLogger(Plant.class.getName()).log(Level.SEVERE, null, ex);
     }
        

        return img;
    }


   @Override
    public double getWeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
/*public boolean contains(int x1,int y1)
   
{
    
//        if(x1>=x&&1<=x+100 && dim2>=80&&dim2<=180){
//
//}
    return false;
}*/

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
