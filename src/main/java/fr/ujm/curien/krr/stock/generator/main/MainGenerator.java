package fr.ujm.curien.krr.stock.generator.main;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

import fr.ujm.curien.krr.stock.bean.Stock;
import fr.ujm.curien.krr.stock.processor.Generator;
import fr.ujm.curien.krr.stock.processor.Writer;

public class MainGenerator {
public static 	LinkedBlockingQueue<Stock> toStringQueue= new LinkedBlockingQueue<>(100);
public static void main(String[] args) throws IOException {

	
	System.out.println("enter data size : example 5 to generate ~= 200 triples");

	int datasize= Integer.parseInt(args[0]);

	new Generator("eBay", 14,datasize).start();
	new Generator("Paypal", 14,datasize).start();
	new Generator("Google",14,datasize).start();
//	new Generator("CAC", 80).start();
//	new Generator("GOOG", 56).start();
//	new Generator("HGT",54).start();
	Writer writer = new Writer();
	Thread th=new Thread(writer);
	th.setName("QPWriter");
	th.start();
}
}
