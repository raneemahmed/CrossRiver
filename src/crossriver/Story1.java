/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Israa Hassanin
 */
public class Story1 implements ICrossingStrategy {//, IRiverCrossingController {


    public Story1() {
       
    }
      
   

    @Override
    public boolean isValid(List<ICrosser> right, List<ICrosser> left, List<ICrosser> boatRiders) {

        boolean valid = false;
        for (int i = 0; i < boatRiders.size(); i++) {
            ICrosser x = boatRiders.get(i);
            if (x.canSail()) {
                valid = true;
                System.out.println("checking riders" + valid);
                break;
            }
        }
        if (valid == false) {
            JOptionPane.showMessageDialog(null, "farmer should steer the boat");
            return false;//msg
        }
        if (left.size() == 3) {
            JOptionPane.showMessageDialog(null, "the carnivore will eat harbivore");
            return false;
        }

        if (left.size() == 2) {
            int diff = left.get(0).getEatingRank() - left.get(1).getEatingRank();
            if (diff == 1 || diff == -1) {
                JOptionPane.showMessageDialog(null, "you can't leave them together");                
                return false;
            }
        }

        if (right.size() == 2) {
            int diff2 = right.get(0).getEatingRank() - right.get(1).getEatingRank();
            if (diff2 == 1 || diff2 == -1) {
                JOptionPane.showMessageDialog(null, "you can't leave them together");
                return false;
            }
        }
        System.out.println("valid is "+valid);
        return valid;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> c = new ArrayList<>();
        //Factory f = new Factory();
        CarnivoreFactory C = new CarnivoreFactory();
        HarbivoreFactory H = new HarbivoreFactory();

        c.add(new Farmer());
        c.add(new Plant());
        Random r=new Random();
        int x=r.nextInt(2);
        if (x==0) {
            c.add(H.getHarbivoire("Goat"));
            c.add(C.getCarnivoire("Fox"));
        }
        else{
            c.add(H.getHarbivoire("sheep"));
            c.add(C.getCarnivoire("wolf"));
        
        }

        return c;
    }

    @Override
    public String[] getInstructions() {
        String []inst=new String[6];
        inst[0]="Story1:";
        inst[1]="“A farmer wants to cross a river and take with him a carnivorous, a herbivorous and plant.";
        inst[2]="Rules:";
        inst[3]="1. The farmer is the only one who can sail the boat. He can only take one passenger, in addition to himself.";
        inst[4]="2. You can not leave any two crossers on the same bank if they can harm(eat) each other";
        inst[5]= " How can the farmer get across the river with all the 2 animals and the plant without any losses?";
        return inst;
        
        
    //    throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public void newGame(ICrossingStrategy gameStrategy) {
//         window2 n=new window2();
//      n.setVisible(true);
//       
//       //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void resetGame() {
//       
//            g.getleftarr().clear();
//            g.getrightarr().clear();
//            g.getboatriders().clear();
//                getInitialCrossers();
//
//    }
//
//    @Override
//    public List<ICrosser> getCrossersOnRightBank() {
//        return g.getrightarr(); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<ICrosser> getCrossersOnLeftBank() {
//        return g.getleftarr(); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean isBoatOnTheLeftBank() {
//     return true;   //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int getNumberOfSails() {
//        score++;
//        return score;
//        //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
//      if (isValid (  g.getrightarr(), g.getleftarr(), g.getboatriders())==true) {
//       return true;
//      }
//      return false;
//        //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean canUndo() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean canRedo() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void undo() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void redo() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void saveGame() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void loadGame() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<List<ICrosser>> solveGame() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
