import java.io.*;
import java.util.*;

/**
 * No need to worry about where exactly to place a ScareCrow.
 * All you're trying to find out is whether or not one is needed there.
**/

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int number_of_tests = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < number_of_tests; i++){
			int field_size = Integer.parseInt(in.readLine());
			String field = in.readLine();
			int scarecrows = 0;
			
			for(int j = 0; j < field_size; j++){
				if(field.charAt(j) == '.'){
					scarecrows++;
					j+=2;
				}
			}
			answer.append("Case " + (i+1) + ": " + scarecrows + "\n");
		}
		answer.setLength(answer.length() - 1);
		System.out.println(answer);
	}
}

