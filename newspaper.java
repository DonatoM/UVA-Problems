import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while((line = in.readLine()) != null){
			int num_test = Integer.parseInt(line);
			for(int test_number = 0; test_number < num_test; test_number++){
				double total = 0.0;
				int char_w_values = Integer.parseInt(in.readLine());
				HashMap<Character,Double> char_and_values = new HashMap<Character,Double>();
				
				for(int num_values = 0; num_values < char_w_values; num_values++){
					line = in.readLine();
					String[] tokens = line.split(" ");
					char_and_values.put(tokens[0].charAt(0),Double.parseDouble(tokens[1]));
				}
				
				int num_of_lines = Integer.parseInt(in.readLine());
				
				for(int i = 0; i < num_of_lines; i++){
					line = in.readLine();
					for (char ch : line.toCharArray()){
				        if(char_and_values.containsKey(ch)){
				        	total += char_and_values.get(ch);
				        }  	
				    }
				}
				System.out.printf("%.2f$\n", total/100);
			}
		}
	}
}

