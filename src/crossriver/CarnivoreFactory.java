/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossriver;

/**
 *
 * @author Israa Hassanin
 */
public class CarnivoreFactory extends AbstractFactory {

    @Override
    public Carnivore getCarnivoire(String cname) {
        if (cname.equals("Fox")) {
            return new Fox();
        }
        else if (cname.equals("wolf")) {
            
            return new wolf();
        }
        return null;
    }

    @Override
    public Harbivore getHarbivoire(String hname) {
        return null;
    }

    @Override
    public ICrosser getFarmer(String fname) {
      return null; //To change body of generated methods, choose Tools | Templates.
    }

   



}