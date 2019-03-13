/*
 * Donald Trowbridge
 * Final Project
 * 
 * This class creates a gui and adds a solar system panel
 */

package innersolarsystem;

import javax.swing.JFrame;

public class SolarSystemGUI extends JFrame
{
    //constructor
    public SolarSystemGUI()
    {
        super("Solar System");
        //creates solar system panel obj
        SolarSystemPanel ssp = new SolarSystemPanel();
        //adds the solar system panel to the gui
        this.add(ssp);
        super.setBounds(0, 0, 1000, 1000);
        this.setVisible(true);
        //repaints panel as long as the gui is visible
        while(this.isVisible())
        {
            ssp.repaint();
        }
        //closes thread executor
        ssp.exe.shutdown();
    }
}
