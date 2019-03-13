/*
 * Donald Trowbridge
 * Final Project
 * 
 * This class defines Satellite, more commonly known as Moons,
 * to be created.
 * 
 */

package innersolarsystem;

import java.awt.Color;
import java.lang.Math;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Satellite extends CelestialObject implements Runnable
{
    private int degrees = 0;
    private int orbit; //distance from planet it orbits
    private Planet p; //planet it orbits
    private int pY; //planet Y coordinate when planet is created
    private int pZ; //planet X coordinate when planet is created.
    private ExecutorService exe = Executors.newCachedThreadPool();
    
    //constructor
    public Satellite(int r, int orbit, Color c,Planet planet)
    {
        super(planet.getXCenter(),planet.getYCenter(),r, c);
        this.orbit = orbit;
        this.p = planet;
        this.pY = planet.getYCenter();
        this.pZ = planet.getXCenter();
    }
    
    public void run()
    {
        while(true)
        {
        try
        {
           Thread.sleep(this.orbit/2);//speed of orbit
           degrees++;
           //sets new x coor of satellite using a trigonomic function to keep the velocity constant
           x = p.getXCenter() + (int)(this.orbit * Math.sin(Math.toRadians(this.degrees)));
           //sets new x coor of planet using a trigonomic function to keep the velocity constant
           y = p.getYCenter() + (int)(this.orbit * Math.cos(Math.toRadians(this.degrees)));
           
        } 
        catch (InterruptedException ex) 
        {
           
        }
        }
    }
}
