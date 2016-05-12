package fr.ujm.curien.krr.stock.processor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import fr.ujm.curien.krr.stock.bean.Stock;
import fr.ujm.curien.krr.stock.generator.main.MainGenerator;

public class Writer implements Runnable {
	private BufferedWriter outputWriter, outputWriter1;

	public void run() {
	int	nbfile=0;
		// Initialize writer
		try {
			outputWriter = new BufferedWriter(new FileWriter(new File("stockdata.nt")));
			outputWriter1 = new BufferedWriter(new FileWriter(new File("epstockdata.P")));
		} catch (final IOException e) {
			//// logger.error("Cannot open output file for " + id, e);
			e.printStackTrace();
			System.out.println("Error in result writer ");
			System.exit(-1);
		}
		// R�cup�rer dans la queue
		// Ecrire
		while (true) {
			try {
				final Stock line = MainGenerator.toStringQueue.take();
				 
				if (line.id != "EOF") {
					writeLine(line);
					
				} else {
					nbfile++;
					if (nbfile == 3)
						break;
				}
			} catch (final InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		finish();
	}

	protected void writeLine(final Stock line) {
		try {
			outputWriter.write(line.toStringRDF());
			outputWriter.newLine();
			outputWriter1.write(line.toStringEP());
			outputWriter1.newLine();
		} catch (final IOException e) {
			// logger.error("Could not write new line for query processor " + id
			// + ", line content " + line, e);
		}
	}

	private void finish() {
		// Close writer
		try {
			outputWriter.close();
			outputWriter1.close();
		} catch (final IOException e) {
			// logger.error("Cannot property close the output file for query " +
			// id, e);
		}
	}

}
