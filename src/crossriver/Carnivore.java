/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossriver;

import java.awt.image.BufferedImage;

/**
 *
 * @author Israa Hassanin
 */
public abstract class Carnivore implements ICrosser {

    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public int getEatingRank() {
        return 5;
    }

    @Override
    public abstract BufferedImage[] getImages();

}
