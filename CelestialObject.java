/*
 * Donald Trowbridge
 * Final Project
 * 
 * This is an abstract class that defines the attributes of all celestial bodies.
 * For the sake of this program all celestial bodies happen to be a circle.
 *
 */

package innersolarsystem;

import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;


public abstract class CelestialObject 
{
   protected Color color;
   protected int radius; //the radius of the object/circle.
   protected int x; //x coordinate
   protected int y; //y coordinate
   private int xcenter;
   private int ycenter;
   
   //constructor
    public CelestialObject(int x, int y, int r, Color c)
    {
        this.x = x;
        this.y = y;
        this.radius = r;
        this.color = c;
        this.xcenter = x + r; //sets center of object on x-axis
        this.ycenter = y + r; //sets center of object on y-axis
    }
    //draw method to create celestial body
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillOval(x, y, radius, radius);
    }
    /*method returns the x coordinate of what would be the center/core of celestial body
    * also used a the source of gravity and orbit of other celestial bodies
    */
    public int getXCenter()
    {
        return this.xcenter;
    }
    /*method returns the y coordinate of what would be the center/core of celestial body
    * also used a the source of gravity and orbit of other celestial bodies
    */
    public int getYCenter()
    {
        return this.ycenter;
    }
    
}
