import java.io.*;
import java.util.*;


public class ProblemThree {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		HashMap<Integer,ArrayList<Integer>> num_to_indexes = new HashMap<Integer,ArrayList<Integer>>(1000000);
		
		
		while((line = in.readLine()) != null){
			String[] tokens = line.split(" ");
			int array_length = Integer.parseInt(tokens[0]);
			int num_of_cases = Integer.parseInt(tokens[1]);
			String[] numbers = in.readLine().split(" ");
		}
	}

}
