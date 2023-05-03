package com.prospecta.problem2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.management.InvalidAttributeValueException;

public class CsvDemo {

	/*
	   1) How will you tackle the challenge above?
	  
     -->We can solve this problem in multiple ways To read csv file we can read using 
			Normal scanner 
			Bufferreader class
			CSV api

     --> Hear we need to read first csv file and by doing this we can get all the row and all 
         column by creating the function that gives the value at the particular positon we can directly calculate the value using formula and we can return the value where we can calculate the data in multiple ways


      2) What type of errors you would you check for?
      → It may possible that curtain problem comes in arithmetic operation  so for that we should handle this type of exception
      → it might be chance that problem writing syntax
      → it might also possible that input format in invalid

	 
	  3)  What type of errors you would you check for?How might a user break your code?
	  → by passing invalid input format 
      → by passing the row,  column which  values in not exist in table
      → or it may possible that curtain problem in given problem statement like both the value is depend on each other and it will never give any answer
      -> By passing invalid data types
	  
	  
	  
	  
	  
	 */
	
	
	
	public static void main(String[] args) throws InvalidAttributeValueException, IOException {
		// first problem  5+A1 so need first row and fist column
		int c1=  giveval(1,1)+5;
		System.out.println(c1);
		
		// second problem  A2 + B2 so need sencod row and first column+sencod row and second column
		int c2= giveval(2,1)+giveval(2,2);
		System.out.println(c2);
		
		// first problem  C2+B3 so need third row and second column
		int c3=  giveval(1,1)+c2;
		System.out.println(c3);

	}
	
	
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @return   it return the ans for number present at perticular row
	 * @throws IOException
	 * @throws InvalidAttributeValueException
	 */
	static int  giveval(int row,int col) throws IOException, InvalidAttributeValueException {
		  
		
		   Path f=Path.of("CsvDemo.csv");
		   List<String> ans=Files.readAllLines(f);
		   

		  //  try {
				
					   int actualRow=ans.size();
					   int actualCol=ans.get(0).split(",").length;
					   
					   if(row<0 || row>actualRow || col<0 || col>actualCol) {
						   throw new InvalidAttributeValueException("Not int a range");
					   }
					   
//					   System.out.println(actualRow+" d");
//					   System.out.println(actualCol+" f");
					  
					  // System.out.println("----------------");
					   
					   String charAns=ans.get(row-1).split(",")[col-1];
					  
					   return Integer.parseInt(charAns);
		  
//		    } catch (Exception e) {
//		    	   throw new InvalidAttributeValueException("Opps somethin is problem");
//			}
	}
	
	public static void csvreaderDemo() {
		   
	}
}
