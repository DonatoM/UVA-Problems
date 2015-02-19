import java.io.*;
import java.util.*;

public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answers = new StringBuilder("");
		String line;
		int case_count = 1;
		
		while((line = in.readLine()) != null){
			String[] tokens = line.split(" ");
			int number_of_potentiometers = Integer.parseInt(tokens[0]);
			
			if(number_of_potentiometers == 0) break;
			
			answers.append("Case " + (case_count++) + ":\n" );			
			Fenwick ft = new Fenwick(number_of_potentiometers);
			
			for(int i = 1; i <= number_of_potentiometers; i++)	ft.set(i, Integer.parseInt(in.readLine()));
			
			while(!(line = in.readLine()).equals("END")){
				String[] row = line.split(" ");
				String action = row[0];
								
				if(action.equals("M")){
					int left_potentiometer = Integer.parseInt(row[1]);
					int right_potentiometer = Integer.parseInt(row[2]);
					int total = ft.sumQuery(left_potentiometer, right_potentiometer);
					answers.append(total + "\n");
				}
				else{
					int index = Integer.parseInt(row[1]);
					int value = Integer.parseInt(row[2]);
					ft.set(index, value);
				}
			}
			answers.append("\n");
		}
		System.out.print(answers.substring(0, answers.length() - 1));
	}
}

class Fenwick {
	public int[] table;

	public Fenwick(int maxN) {
		this.table = new int[maxN + 1];
	}
	
	public void set(int index, int value){
		int diff = value - getValue(index);
		adjust(index,diff);
	}

	public int sumQuery(int a, int b) {
		return sumQuery(b) - sumQuery(a - 1);
	}

	public int sumQuery(int k) {
		int ret = 0;
		while (k > 0) {
			ret += table[k];
			k &= k - 1;
		}
		return ret;
	}

	public void adjust(int i, int adj) {
		while (i < table.length) {
			table[i] += adj;
			i += (i & (-i));
		}
	}

	public int getValue(int i) {
		return sumQuery(i, i);
	}
}
