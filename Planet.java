/*
 * Donald Trowbridge
 * Final Project
 * 
 * This class extends Celestial object to define and create a planet. This planet
 * orbits a star object.
 *
 */

package innersolarsystem;

import java.awt.Color;
import java.lang.Math;

public class Planet extends CelestialObject implements Runnable
{
    private int degrees = 90;
    private int orbit;
    private Star star;
    
    //constructor
    public Planet(int r, int orbit, Color c,Star star)
    {
        super(star.getXCenter(),star.getYCenter(),r,c);
        this.orbit = orbit; //how far away from the star is the planet
        this.star = star; //the star obj the planet orbits.
    }
    
    public void run()
    {
        while(true)
        {
        try
        {
           Thread.sleep(this.orbit/3);//defines speed based on orbit distance
           degrees++;//increases to calculate change in x coor and y coor
           //sets new x coor of velocity using a trigonomic function to keep the accelaration constant
           x = star.getXCenter() + (int)(this.orbit * Math.sin(Math.toRadians(this.degrees)));
           //sets new y coor of velocity using a trigonomic function to keep the accelaration constant
           y = star.getYCenter() + (int)(this.orbit * Math.cos(Math.toRadians(this.degrees)));
           
        } 
        catch (InterruptedException ex)//the catcher wouldn't know what to do if it did catch something
        {
           
        }
        }
    }
    //returns distance away from the object it orbits.
    public int getOrbit()
    {
        return this.orbit;
    }
    @Override
    public int getXCenter()//returns x coordinate
    {
        int z = super.x + super.radius;
        return z;
    }
    @Override
    public int getYCenter()//returns y coordinate
    {
        int z = super.y + super.radius;
        return z;
    }
}
