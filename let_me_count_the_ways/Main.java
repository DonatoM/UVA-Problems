import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuilder answer = new StringBuilder();
		int[] coins = {1,5,10,25,50};
		int size = coins.length;
		
		while(!(line = in.readLine()).isEmpty()){
			int value = Integer.parseInt(line);
			int ways = count(coins, size, value);
			if(ways > 1) answer.append("There are " + ways + " ways to produce " + value + " cents change.\n");
			else if(ways == 1) answer.append("There is only 1 way to produce " + value + " cents change.\n");
		}
		answer.setLength(answer.length() - 1);
		System.out.println(answer);
	}
	
	public static int count(int[] coins, int num_of_coins, int value){
		if (value == 0) return 1;
		if (value < 0) return 0;
		if (num_of_coins <= 0 && value >= 1) return 0;
		return count(coins, num_of_coins, value-coins[num_of_coins-1]) + count(coins, num_of_coins - 1, value);
	}
}
