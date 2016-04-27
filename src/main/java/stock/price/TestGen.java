package stock.price;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public class TestGen {
public static 	LinkedBlockingQueue<Stock> toStringQueue= new LinkedBlockingQueue<>(100);
public static void main(String[] args) throws IOException {
	System.out.println("enter data size example 10");

	int datasize= Integer.parseInt(args[0]);
	File file = new File("data.txt");

	// if file doesnt exists, then create it
	if (!file.exists()) {
		file.createNewFile();
	} 
	
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
