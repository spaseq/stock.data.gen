package fr.ujm.curien.krr.stock.fractal;
/*
 * 2D Fractal Terrain Generator
 * Generates terrain using the random midpoint displacement algorhythm.
 * Copyright (C) 2013 Dani Rodríguez <danirod@outlook.com>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;



/**
 * Fractal frame. This is the window that will render the frame and the fractal.
 * 
 * @author danirod
 */
public class FractalFrame extends JFrame
{
    private static final long serialVersionUID = 1L;
    
    private Fractal fractal;
    private String name;
    public FractalFrame(Fractal fractal, String name)
    {
        this.fractal = fractal;
        this.name=name;
        init();
      
    }
    
    private void init()
    {
        // initialize window size and position
        setPreferredSize(new Dimension(640, 360));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dim.getWidth() - getWidth()) / 4);
        int y = (int) ((dim.getHeight() - getHeight()) / 4);
        // note that we just divided by 4, that makes the screen to center 
        setLocation(x, y);
        
        setTitle(this.name);
        add(new FractalPanel(fractal)); // add the panel
        pack();
    }
}