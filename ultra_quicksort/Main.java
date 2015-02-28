import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {        
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	String line;
    	
    	while((line = in.readLine()) != null){
    		int array_length = Integer.parseInt(line);
    		
    		if(array_length == 0)	break;
    		
    		int[] sequence = new int[array_length];
    		
    		for(int i = 0; i < array_length; i++)
    			sequence[i] = Integer.parseInt(in.readLine());
    		    		
    		int[] sorted = new int[sequence.length];
    		System.out.println(mergeSort(sequence, sorted, 0, sequence.length));
    	}
    }
	
    public static long mergeSort(int[] arr, int[] sorted, int min, int max) {
    	if (min == max - 1)
    		return 0;
    	
    	else {
	        int mid = (min + max)/2;
	        long invertions = mergeSort(arr, sorted, min, mid);
	        invertions += mergeSort(arr, sorted, mid, max);
	        invertions += merge(arr, sorted, min, mid, max);
	
	        return invertions;
        }
    }
    
    public static long merge(int[] arr, int[] sorted, int min, int mid, int max) {
        long invertions = 0;
        
        for(int left_sub_index = min, sorted_index = min, right_sub_index = mid; left_sub_index < max; left_sub_index++) {
        	if (right_sub_index >= max || sorted_index < mid && arr[sorted_index] <= arr[right_sub_index]) {
                sorted[left_sub_index] = arr[sorted_index++];
            }
        	else {
                sorted[left_sub_index]  = arr[right_sub_index++];
                invertions = invertions + (mid - sorted_index); 
            }
        }
        
        System.arraycopy(sorted, min, arr, min, max - min);
        
        return invertions;
    }
}
