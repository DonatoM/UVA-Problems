import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int case_count = 1;
		
		while((line = in.readLine()) != null){
			String[] row = line.split(" ");
			int num_students = Integer.parseInt(row[0]), num_test_cases = Integer.parseInt(row[1]);
			
			if((num_students == 0 ) && (num_test_cases == 0)) break;
			
			UnionFind religions = new UnionFind(50000);
			int union_count = 0;
			
			for(int i = 0; i < num_test_cases; i++){
				String[] tokens = in.readLine().split(" ");
				int student_a = Integer.parseInt(tokens[0]), student_b = Integer.parseInt(tokens[1]);
				int student_a_set_root_val = religions.findSet(student_a), student_b_set_root_val = religions.findSet(student_b);
				
				if(student_a_set_root_val != student_b_set_root_val){
					religions.unionSet(student_a_set_root_val,student_b_set_root_val);
					union_count += 1;
				}
			}
			int total_religions = num_students - union_count;
			System.out.format("Case %s: %s\n",case_count,total_religions);
			union_count = 0;
			case_count += 1;
		}
	}
}


//	Taken from Competitive Programming 3 pg 54.
class UnionFind {
	
    static int[] parent, rank; 
  
    public UnionFind(int N) {   
        this.parent = new int[N];
        this.rank = new int[N];
        for(int i = 0; i < N; i++){
        	parent[i] = i;
        }
    }
    
    protected int findSet(int i){
    	if(parent[i] != i){
    		parent[i] = findSet(parent[i]);
    	}
    	return parent[i];
    }
    
    protected boolean isSameSet(int i, int j){
    	return findSet(i) == findSet(j);
    }
    
    protected void unionSet(int i, int j){
    	if(!isSameSet(i,j)){
    		int x = findSet(i), y = findSet(j);
    		if (rank[x] > rank[y]) parent[y] = x;
    		else {
    			parent[x] = y;
    			if (rank[x] == rank[y]) rank[y]++;
    		}
    	}
    }
}
