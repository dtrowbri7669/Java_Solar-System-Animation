/*
 * Donald Trowbridge
 * Final Project
 * 
 * This class creates a panel with stars, sun, and the 4 inner planets with
 * their natural satellites
 */

package innersolarsystem;

import javax.swing.JPanel;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.List;
import java.util.LinkedList;

public class SolarSystemPanel extends JPanel
{
    //creates an obj to cache and execute threads
    ExecutorService exe = Executors.newCachedThreadPool();
    private Color venusColor = new Color(180,92,0);
    //instantiate planets and satellites
    private Planet Earth;
    private Planet Mercury;
    private Planet Venus;
    private Planet Mars;
    private Satellite Moon;
    private Satellite Phobos;
    private Satellite Deimos;
    private Random rand = new Random();
    //holds planets and satellites
    private List<CelestialObject> objs = new LinkedList<CelestialObject>();
    //holds stars
    private List<Star> stars = new LinkedList<Star>();
    
    public SolarSystemPanel()
    {
        //create star
        Star sun = new Star(450, 450, 30, Color.YELLOW);
        //create the 4 inner planets
        Mercury = new Planet(7, 75, Color.RED, sun);
        Earth = new Planet(15, 250, Color.BLUE, sun);
        Venus = new Planet(13, 150, venusColor, sun);
        Mars = new Planet(9, 425, Color.RED, sun);
        //creates background stars
        createBackgroundStars(1550);
        //creates satelliets
        Moon = new Satellite(5, 50, Color.WHITE, Earth);
        Phobos = new Satellite(3, 20, Color.WHITE, Mars);
        Deimos = new Satellite(4, 35, Color.WHITE, Mars);
        
        stars.add(sun);//adds sun to stars list
        //adds planets and satellites to objs list
        objs.add(Mercury);
        objs.add(Earth);
        objs.add(Venus);
        objs.add(Mars);
        objs.add(Moon);
        objs.add(Phobos);
        objs.add(Deimos);
        //adds planets and satellites to thread cache for execution
        exe.execute(Earth);
        exe.execute(Moon);
        exe.execute(Mercury);
        exe.execute(Venus);
        exe.execute(Mars);
        exe.execute(Phobos);
        exe.execute(Deimos);
    }
    //draws all features of panel and all objects on the panel
    public void paint(Graphics g)
    {
        super.paint(g);
        super.setBackground(Color.BLACK);
        for(Star s: stars)
            s.draw(g);
        for(CelestialObject o: objs)
            o.draw(g);
        
    }
    
    //takes number to create star objects at random questions.
    public void createBackgroundStars(int number)
    {
        for(int i = 0; i < number; i++)
        {
            int y = rand.nextInt(1000);
            int z = rand.nextInt(1000);
            Star s = new Star(y,z,3,Color.WHITE);
            stars.add(s);
        }
    }
    
    
}
