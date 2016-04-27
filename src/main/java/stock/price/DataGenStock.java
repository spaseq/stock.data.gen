package stock.price;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.jfree.data.time.Millisecond;

public class DataGenStock {

	private static final float MIN_PRICE = 0;
	private static final float MAX_PRICE = 20000;

	public static void main(String[] args) {
		List <String> nameList =Arrays.asList("GOOG", "IBM", "CAC 40", "VALEO", "NOKIA" );
	
		
		
		int x=0;
		float	oldprice;
		while (x<1000){
			if (x==0)
			{oldprice=127;}
			else{
				 int randomNum = 0 + (int)(Math.random() * 4); 
				 
				oldprice=getNextPrice(124);
				 final Millisecond now = new Millisecond();
				System.out.println("Name or Symbol "+ nameList.get(randomNum) +"  the price  "+oldprice+ " at "+now);}
			x++;
		}
	}

	public static float getNextPrice(float oldPrice)
	{
	    Random _random =  new Random();
		// Instead of a fixed volatility, pick a random volatility
	    // each time, between 2 and 10.
	    float volatility = _random.nextFloat() * 10 + 2;

	    float rnd = _random.nextFloat();

	    float changePercent = 2 * volatility * rnd;

	    if (changePercent > volatility) {
	        changePercent -= (2 * volatility);
	    }
	    float changeAmount = oldPrice * changePercent/100;
	    float newPrice = oldPrice + changeAmount;

	    // Add a ceiling and floor.
	    if (newPrice < MIN_PRICE) {
	        newPrice += Math.abs(changeAmount) * 2;
	    } else if (newPrice > MAX_PRICE) {
	        newPrice -= Math.abs(changeAmount) * 2;
	    }

	    return newPrice;

	}
	
}
