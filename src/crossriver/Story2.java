/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossriver;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Israa Hassanin
 */
public class Story2 implements ICrossingStrategy {//, IRiverCrossingController {

 //   Gamepanel g;

    //story1animation gp=new story1animation(this);

    public Story2() {
        // this.g = gp;
    }
    int score = 0;

    @Override
    public boolean isValid(List<ICrosser> right, List<ICrosser> left, List<ICrosser> boatRiders) {
        /*  boolean valid = false;
         for (int i = 0; i < boatRiders.size(); i++) {
         ICrosser x = boatRiders.get(i);
         if (x.canSail()) {
         valid = true;
         break;
         }
         }
         if (valid == false) {
         return false;
         }
         if (left.size() == 3) {
         return false;
         } else if (left.size() == 2) {
         int diff=left.get(0).getEatingRank()-left.get(1).getEatingRank();
         if(diff==1 ||diff==-1)
         return false;
         }
         return false; */
        double weight=0;
        boolean valid = false;
        for (int i = 0; i < boatRiders.size(); i++) {
            ICrosser x = boatRiders.get(i);
            if (x.canSail()) {
                valid = true;

                break;
            }
       
        }
           if (valid == false) {
            JOptionPane.showMessageDialog(null, "farmer should steer the boat");
            return valid;//msg
        }
        for (int i = 0; i < boatRiders.size(); i++) {
                if (boatRiders.get(i) instanceof Farmer2) {
                 weight+=boatRiders.get(i).getWeight(); 
                }
                else if (boatRiders.get(i) instanceof Farmer3) {
                 weight+=boatRiders.get(i).getWeight(); 
                }
                else if (boatRiders.get(i) instanceof Farmer4) {
                 weight+=boatRiders.get(i).getWeight(); 
                }
                  else if (boatRiders.get(i) instanceof Farmer5) {
                 weight+=boatRiders.get(i).getWeight(); 
                }
                  else  if (boatRiders.get(i) instanceof Harbivore ) {
                 weight+=boatRiders.get(i).getWeight(); 
                }
                              
        }
        if (weight>100.0){
            JOptionPane.showMessageDialog(null, "The boat can't bear a load heavier than 100Kg");
            valid=false;
            return valid;
            
        }

            return valid;
        }
    
    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> c = new ArrayList<>();
      
        FarmerFactory F= new FarmerFactory();
        HarbivoreFactory H = new HarbivoreFactory();

        
        c.add(F.getFarmer("Farmer5"));
        c.add(F.getFarmer("Farmer2"));
        
        c.add(F.getFarmer("Farmer3"));
        c.add(F.getFarmer("Farmer4"));
        
        c.add(H.getHarbivoire("Goat"));

        return c;
    }

     @Override
    public String[] getInstructions() {
        String []inst=new String[7];
        inst[0]=" Story2:";
        inst[1]="Four farmers and their animal need to cross a river in a small boat. The weights of the";
        inst[2]=" farmers are 90 kg, 80 kg,60 kg and 40 kg respectively, and the weight of the animal is 20 kg.";
        inst[3]="Rules:";
        inst[4]="1. The boat cannot bear a load heavier than 100 kg.";
        inst[5]="2. All farmers can raft, while the animal cannot.";
        inst[6]="How can they all get to the other side with their animal?";

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
