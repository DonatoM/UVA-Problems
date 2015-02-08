package assignment_01;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> ananagrams = new ArrayList<String>();
		String regexManySpaces = "\\s+";
		String line;
		
		while((line = in.readLine()) != null){
			if(line.charAt(0) == '#') break;
			String filteredLine = line.trim().replaceAll(regexManySpaces, " ");
			String[] row = filteredLine.split(regexManySpaces);
			for(int i = 0; i < row.length; i++){
				words.add(row[i]);
			}
		}
		
		for(String word : words){
			int counter = 0;
			char[] w1 = word.toLowerCase().toCharArray();
			Arrays.sort(w1);
			for(String element: words){
				char[] w2 = element.toLowerCase().toCharArray();
			    Arrays.sort(w2);
			    if(Arrays.equals(w1,w2)) counter++;
			}
			if(counter == 1) ananagrams.add(word);
		}
		
		Collections.sort(ananagrams);
		for(String ananagram : ananagrams){
			System.out.println(ananagram);
		}
	}
}
