/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.meine.sortingvisualiser.helpers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Meine Toonen
 */
public class Visualiser extends JFrame {

    private final int DELAY = 100;

    private int[] data = null;
    private ColorHelper ch;

    private int min, max;

    private Image offScreenImage = null;
    private Graphics offScreenGraphics = null;
    private Image offScreenImageDrawed = null;
    private Graphics offScreenGraphicsDrawed = null;
    
    private int currentIndex, indexToCheckAgainst;
    private int number;
    public Visualiser(int[] data, int number) {
        super();
        this.data = data;
        this.number = number;
        OptionalInt highest = Arrays.stream(data).max();
        OptionalInt lowest = Arrays.stream(data).min();
        max = highest.getAsInt();
        min = lowest.getAsInt();
        this.ch = new ColorHelper(min, max);

    }

    public void init() {
        //Create and set up the window.
        JFrame frame = this;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 500, height = 500;
        frame.setSize(500, 500);
        frame.setLocation(width, number * height);
        //frame.pack();
        frame.setVisible(true);
    }

    public void setNewData(int[] data, int currentIndex, int indexToCheckAgainst) {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException ex) {
            Logger.getLogger(Visualiser.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.currentIndex = currentIndex;
        this.indexToCheckAgainst = indexToCheckAgainst;
        this.data = data;
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (offScreenImageDrawed == null) {
            // Double-buffer: clear the offscreen image.                
            offScreenImageDrawed = createImage(getWidth(), getHeight());
        }
        offScreenGraphicsDrawed = offScreenImageDrawed.getGraphics();
        offScreenGraphicsDrawed.setColor(Color.white);
        offScreenGraphicsDrawed.fillRect(0, 0, getWidth(), getHeight());
        /////////////////////
        // Paint Offscreen //
        /////////////////////
        renderOffScreen(offScreenImageDrawed.getGraphics());
        g.drawImage(offScreenImageDrawed, 0, 0, null);

    }

    public void renderOffScreen(final Graphics g) {
        int border = 100;

        double heightPerUnit = (this.getHeight() - border) / max;
        int widthPerBar = this.getWidth() / data.length;

        g.setColor(Color.red);
        super.paint(g);
        for (int i = 0; i < data.length; i++) {
            int value = data[i];
            paintBar(g, value, i, heightPerUnit, widthPerBar, currentIndex == i, indexToCheckAgainst == i);
        }
    }

    private void paintBar(Graphics g, int value, int index, double heightPerUnit, int widthPerBar, boolean isCurrent, boolean checkAgainst) {
        Graphics2D g2 = (Graphics2D) g;
        double d = (double) value / (double) max;
        Color c = ch.numberToColorPercentage(d);
        g2.setColor(c);
        g2.fillRect(index * widthPerBar + index, this.getHeight() - ((int) heightPerUnit * value), widthPerBar, (int) heightPerUnit * value);
        
        if (isCurrent) {
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(10));
            g2.drawRect(index * widthPerBar + index, this.getHeight() - ((int) heightPerUnit * value), widthPerBar, (int) heightPerUnit * value);
        }
        if (checkAgainst) {
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(10));
            g2.drawRect(index * widthPerBar + index, this.getHeight() - ((int) heightPerUnit * value), widthPerBar, (int) heightPerUnit * value);
        }
    }
}
