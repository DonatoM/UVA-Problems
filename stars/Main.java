import java.io.*;
import java.util.*;

public class Main {
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while((line = in.readLine()) != null){
			int number_of_stars = Integer.parseInt(line);
			int[] star_level_count = new int[number_of_stars];
			Fenwick ft = new Fenwick(32000);
			
			for(int i = 0; i < number_of_stars; i++){
				String[] coordinates = in.readLine().split(" ");
				int x_cordinate = Integer.parseInt(coordinates[0]) + 1;
				int star_level = ft.sumQuery(x_cordinate);
				ft.adjust(x_cordinate, 1);
				star_level_count[star_level] += 1;
			}
			
			for(int count: star_level_count)	System.out.println(count);
		}
	}
}

class Fenwick {
	public int[] table;

	public Fenwick(int maxN) {
		this.table = new int[maxN + 2];
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
