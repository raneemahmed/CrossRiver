/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossriver;

import GameGuI.Gamepanel;

/**
 *
 * @author yarae
 */
public class MoveRight implements  Command{
    Gamepanel f;

    public MoveRight(Gamepanel g) {
        f=g;
    }
    
    @Override
    public void execute() {
       f.setX(f.getX()+15);
    }
    
}
