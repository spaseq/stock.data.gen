package fr.ujm.curien.krr.stock.processor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.WindowConstants;

import fr.ujm.curien.krr.stock.bean.Stock;
import fr.ujm.curien.krr.stock.fractal.Fractal;
import fr.ujm.curien.krr.stock.generator.main.MainGenerator;

public class Generator extends Thread {
 double price;
 int datasize;
	public Generator(String str, double x, int datasize) {
		super(str);
		price=x;
		this.datasize=datasize;
		
	}

	@Override
	public void run() {
		 Fractal fractal = new Fractal();
		 fractal.name= getName();
	        Random rnd = new Random();
	        long seed = rnd.nextLong();
	        fractal.init(seed, 0, 0);
	        for(int i = 0; i < this.datasize; i++)
	            fractal.iterate();

			
		
	        double[] data = fractal.getValues();
                 for (int k=0; k < data.length;k++)
                 { double x= data[k]*10;
                	 try {
                		 MainGenerator.toStringQueue.put( new Stock(fractal.name, x+price, ThreadLocalRandom.current().nextDouble(1, 100)));
                	//	 TestGen.toStringQueue.put("event(rdf("+fractal.name+",hasStockPrice,"+ Double.toString(Math.floor((x+price) * 100) / 100 ) + "))");
						//TestGen.toStringQueue.put( "<http://example/company#"+fractal.name +"> <http://example/price> \""+Double.toString(Math.floor((x+price) * 100) / 100 )+"\"^^<http://www.w3.org/2001/XMLSchema#double>");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	 }
                 try {
                	 Stock eof=new Stock("finish", 1,"EOF",12);
					MainGenerator.toStringQueue.put(eof);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 
	//	fractal.name+ " "+ ((float) data[k]*10+87) 

	
	      //  FractalFrame ff = new FractalFrame(fractal, getName());
	       // ff.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        //ff.setVisible(true);
	        System.out.println("Test Finished for: " + getName());


}}
