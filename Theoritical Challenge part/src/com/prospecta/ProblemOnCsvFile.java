
package com.prospecta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProblemOnCsvFile {

	public static void main(String[] args) throws IOException {
		
	    // Read the input CSV file
		
	    BufferedReader reader = new BufferedReader(new FileReader("C:\\Desktop\\ProspectaInputFile.csv\\"));
	    String line;
	    List<String[]> lines = new ArrayList<>();
	    while ((line = reader.readLine()) != null) {
	      lines.add(line.split(", "));
	    }
	    reader.close();

	    // Evaluate the formulas and output the results to a new CSV file
	    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Desktop\\ProspectaOutputFile.csv\\"));
	    
	    for (String[] row : lines) 
	    {
		      for (int i = 0; i < row.length; i++) 
		      {
		        if (row[i].startsWith("=")) 
		        {
		          row[i] = String.valueOf(eval(row[i].substring(1)));
		        }
		      }
		      
		      writer.write(String.join(", ", row));
		      
		      writer.newLine();
	    }
	    
	    writer.close();
	  }

	  // Evaluates a formula and returns the result
	
	  private static int eval(String formula) 
	  {
		  
	    // Split the formula into individual terms
	    String[] terms = formula.split("\\+");

	    // Evaluate the formula by adding up the values of all the terms
	    
	    int result = 0;
	    for (String term : terms) 
	    {
	      if (Character.isDigit(term.charAt(0))) 
	      {
	        result += Integer.parseInt(term);
	      } else {
	        result += eval(term);
	      }
	    }
	    
	    return result;
	  }
}
