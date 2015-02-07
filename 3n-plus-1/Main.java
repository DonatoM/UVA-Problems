import java.io.*;
import java.util.*;

public class Main {
	public static void main(String [] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while((line = in.readLine()) != null){
			
			String regexManySpaces = "\\s+";
			String filteredLine = line.trim().replaceAll(regexManySpaces, " ");
			String[] tokens = filteredLine.split(regexManySpaces);
			
			if (tokens.length == 2) {
			    long lower_bound = new Long(tokens[0]).longValue();
			    long upper_bound = new Long(tokens[1]).longValue();
			    boolean flag = false;
			    long holder = 0;
			    String result = "";
			    
			    if(upper_bound < lower_bound){
			    	holder = upper_bound;
			    	upper_bound = lower_bound;
			    	lower_bound = holder;
			    	flag = true;
			    }
			    
			    long max_cycle = 0, cycles = 0;
			    for(long number = lower_bound; number <= upper_bound; number++){
				cycles = cycle(number,0);
				if(cycles > max_cycle)
				 max_cycle = cycles;
				}
			    
			    if(flag == true){
			    	lower_bound = upper_bound;
			    	upper_bound = holder;
			    	flag = false;
			    }
				System.out.println(lower_bound + " " + upper_bound + " " + max_cycle);
			}
		}
	}
	
	public static long cycle(long number, long counter){
		if(number == 1){
			return counter + 1;
		}
		else if(number % 2 != 0){
			number = (3*number)+1;
			counter += 1;
			return cycle(number, counter);
		}
		else{
			number = number/2;
			counter += 1;
			return cycle(number,counter);
		}
	}
	
}
