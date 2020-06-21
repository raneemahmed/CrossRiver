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
public class MoveLeft implements Command {

    public MoveLeft(Gamepanel g) {
        f = g;
    }
    Gamepanel f;

    @Override
    public void execute() {
        f.setX(f.getX() - 15); //To change body of generated methods, choose Tools | Templates.
    }

}
