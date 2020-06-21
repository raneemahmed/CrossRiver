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
public class HarbivoreFactory extends AbstractFactory{

    @Override
    public Carnivore getCarnivoire(String cname) {
        return null;
    }

    @Override
    public Harbivore getHarbivoire(String hname) {
        if (hname.equals("Goat")) {
            return new Goat();
        }
        else if (hname.equals("sheep")) {
            
            return new sheep();
        }
        return null;
    }

    @Override
    public ICrosser getFarmer(String fname) {
        return null; //To change body of generated methods, choose Tools | Templates.
    }
    
}
