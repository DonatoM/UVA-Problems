import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		Scanner scanner =  new  Scanner(System.in);
		int[] coins = {1,5,10,25,50};
		long[] cashier = new long[30050];
		cashier[0] = 1;
				
		for(int i = 0; i < 5; i++){
			for(int j = coins[i]; j <= 30010; j++){
				cashier[j] += cashier[j - coins[i]];
			}
		}
		
		while(scanner.hasNextInt()){
			int index = scanner.nextInt();
			if(cashier[index] > 1) System.out.println("There are " + cashier[index] + " ways to produce " + index + " cents change.");
			else if(cashier[index] == 1) System.out.println("There is only 1 way to produce " + index + " cents change.");
		}
	}
}
