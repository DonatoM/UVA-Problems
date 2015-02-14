import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while((line = in.readLine()) != null){
			String[] tokens = line.split(" ");
			int list_length = Integer.parseInt(tokens[0]);
			int cost = 0;
			
			if(list_length == 0)	break;
			
			String[] number_list = in.readLine().split(" ");
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			
			for(int i = 0; i < list_length; i++){
				numbers.add(Integer.parseInt(number_list[i]));
			}
			
			while(numbers.size() >= 2){
				Collections.sort(numbers);
				int short_sum = numbers.get(0) + numbers.get(1);
				numbers.remove(0);
				numbers.remove(0);
				numbers.add(0,short_sum);
				cost += numbers.get(0);
			}
			
			System.out.println(cost);
		}
	}
}

