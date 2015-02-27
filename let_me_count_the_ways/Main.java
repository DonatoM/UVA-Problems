import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuilder answer = new StringBuilder();
		int[] coins = {1,5,10,25,50};
		long[] cashier = new long[30050];
		cashier[0] = 1;
				
		for(int i = 0; i < 5; i++){
			for(int j = coins[i]; j <= 30010; j++){
				cashier[j] += cashier[j - coins[i]];
			}
		}
		
		while(!(line = in.readLine()).isEmpty()){
			int index = Integer.parseInt(line);
			if(cashier[index] > 1) answer.append("There are " + cashier[index] + " ways to produce " + index + " cents change.\n");
			else if(cashier[index] == 1) answer.append("There is only 1 way to produce " + cashier[index] + " cents change.\n");
		}
		
		answer.setLength(answer.length() - 1);
		System.out.println(answer);
	}
}

