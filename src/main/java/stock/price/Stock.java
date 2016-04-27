package stock.price;

import org.apache.commons.math3.util.Precision;

public class Stock {
	public String id="x";
 private  String company;
 private  double price;
 private double volume;
public Stock( String company, double price, double volume) {
	super();
	this.company = company;
	this.price = price;
	this.volume=volume;
}

public Stock( String company, double price, String xx, double volume) {
	super();
	this.id=xx;
	this.company = company;
	this.price = price;
	this.volume=volume;
}

public String toStringRDF() {
return	"<http://example/company#"+this.company +"> <http://example/volume> \""+Double.toString(Math.floor((this.volume) * 100) / 100 )+"\"^^<http://www.w3.org/2001/XMLSchema#double> .\n"
		+ "<http://example/company#"+this.company +"> <http://example/price> \""+Double.toString(Precision.round(this.price, 4) )+"\"^^<http://www.w3.org/2001/XMLSchema#double> .";
}
 
public String toStringEP() {
	// TODO Auto-generated method stub
	return "event(rdf("+this.company+",hasVolume,"+ Double.toString(Math.floor((this.volume) * 100) / 100 ) + ")) .\n"
			+ "event(rdf("+this.company+",hasStockPrice,"+ Double.toString(Precision.round(this.price, 4) ) + ")) .";
}


  
}
