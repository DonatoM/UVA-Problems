import java.io.*;
import java.util.*;

public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		List<List<Integer>> case_answers = new ArrayList<List<Integer>>();
		String line;
		
		while((line = in.readLine()) != null){
			ArrayList<Integer> answers = new ArrayList<Integer>();
			String[] tokens = line.split(" ");
			
			int number_of_potentiometers = Integer.parseInt(tokens[0]);
			
			if(number_of_potentiometers == 0) break;
			
			Integer[] potentiometers = new Integer[number_of_potentiometers+1];
			
			for(int i = 1; i < number_of_potentiometers+1; i++)	potentiometers[i] = Integer.parseInt(in.readLine());
			
			while(!(line = in.readLine()).equals("END")){
				String[] row = line.split(" ");
				String action = row[0];
								
				if(action.equals("M")){
					int total = 0;
					int left_potentiometer = Integer.parseInt(row[1]);
					int right_potentiometer = Integer.parseInt(row[2]);
					for(int i = left_potentiometer; i <= right_potentiometer; i++){
						total += potentiometers[i];
					}
					answers.add(total);
				}
				else{
					Integer index = Integer.parseInt(row[1]);
					Integer value = Integer.parseInt(row[2]);
					potentiometers[index] = value;
				}
			}
			case_answers.add(answers);
		}
		int case_count = 1;
		for(List<Integer> item: case_answers){
			System.out.println("Case " + case_count + ":");
			for(Integer value: item) System.out.println(value);
			System.out.println();
			case_count += 1;
		}
	}
}

