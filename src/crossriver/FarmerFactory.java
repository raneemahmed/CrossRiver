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
public class FarmerFactory extends AbstractFactory {

    @Override
    public Carnivore getCarnivoire(String cname) {
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Harbivore getHarbivoire(String hname) {
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICrosser getFarmer(String fname) {
       if (fname=="Farmer2"){
       return  new Farmer2(); 
       }
        if (fname=="Farmer3"){
       return  new Farmer3(); 
       }
         if (fname=="Farmer4"){
       return  new Farmer4(); 
       }
          if (fname=="Farmer5"){
       return  new Farmer5(); 
       }
       return null;
//To change body of generated methods, choose Tools | Templates.
    }
    
}
