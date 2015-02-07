import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException{
		String line;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		List[] num_to_indexes = new ArrayList[1000001];

        	for (int i = 0; i < 1000001; i++) {
            		num_to_indexes[i] = new ArrayList<Integer>();
        	}
        
		while((line = in.readLine()) != null){
			String[] tokens = line.split(" ");
			int array_length = Integer.parseInt(tokens[0]);
			int num_of_cases = Integer.parseInt(tokens[1]);
			
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			
			int x = 0;
			while (st.hasMoreTokens()) {
				num_to_indexes[Integer.parseInt(st.nextToken())].add(x);
			    x++;
			}
			
			int[] results = new int[num_of_cases];
			
			for(int i = 0; i < num_of_cases; i++){
				String[] test = in.readLine().split(" ");
				int index = Integer.parseInt(test[0]);
				int value = Integer.parseInt(test[1]);
				
				if(index > num_to_indexes[value].size())
					results[i] = 0;
				else
					results[i] = (Integer)num_to_indexes[value].get(index-1) + 1;
			}
			
			for (Integer element : results) {
			    System.out.println(element);
			}
		}
	}

}
