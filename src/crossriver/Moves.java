/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossriver;

import java.util.List;

/**
 *
 * @author yarae
 */

public class Moves {
    List<ICrosser> leftList;
    List<ICrosser>rightList;
    List<ICrosser>boattList;
    boolean boatplace;

    public Moves(boolean boatplace) {
        this.boatplace = boatplace;
    }

    public List<ICrosser> getLeftList() {
        return leftList;
    }

    public void setLeftList(List<ICrosser> leftList) {
        this.leftList = leftList;
    }

    public List<ICrosser> getRightList() {
        return rightList;
    }

    public void setRightList(List<ICrosser> rightList) {
        this.rightList = rightList;
    }

    public List<ICrosser> getBoattList() {
        return boattList;
    }

    public void setBoattList(List<ICrosser> boattList) {
        this.boattList = boattList;
    }

    public boolean getBoatplace() {
        return boatplace;
    }

    public void setBoatplace(boolean boatplace) {
        this.boatplace = boatplace;
    }

    
    
}
