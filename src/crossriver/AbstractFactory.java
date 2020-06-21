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
public  abstract class AbstractFactory {
    public abstract Carnivore getCarnivoire(String cname);

    public abstract Harbivore getHarbivoire(String hname);
    public abstract ICrosser getFarmer(String fname);

}
