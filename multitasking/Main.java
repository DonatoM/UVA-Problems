import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		Boolean conflict = false;
		boolean[] calendar = new boolean[1000000];
		
		
		while((line = in.readLine()) != null){
			String[] tokens = line.split(" ");
			
			int non_repetitive = Integer.parseInt(tokens[0]);
			int repetitive = Integer.parseInt(tokens[1]);
			
			if((non_repetitive == 0) && (repetitive == 0)) break;
			
			for(int i = 0; i < non_repetitive; i++){
				String[] row = in.readLine().split(" ");
				int start = Integer.parseInt(row[0]), end = Integer.parseInt(row[1]);
				for(int j = start; j < end; j++){
					if(calendar[j] == true){
						conflict = true; 
						break;
					}
					calendar[j] = true;
				}
			}
			
			for(int i = 0; i < repetitive; i++){
				String[] row = in.readLine().split(" ");
				int start = Integer.parseInt(row[0]), end = Integer.parseInt(row[1]), counter = Integer.parseInt(row[2]);
				while(start < 1000000){
					if(end > 1000000) end = 1000000;
					for(int j = start; j < end; j++){
						if(calendar[j] == true){
							conflict = true; 
							break;
						}
						calendar[j] = true;
					}
					start += counter;
					end += counter;
				}
			}
			
			if(conflict) System.out.println("CONFLICT");
			else System.out.println("NO CONFLICT");
			Arrays.fill(calendar,false);
			conflict = false;
		}
		
	}
}

