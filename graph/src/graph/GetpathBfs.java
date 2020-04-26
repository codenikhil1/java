package graph;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue; 
import java.util.LinkedList;
public class GetpathBfs {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		 int graph[][] = new int[V][V];
	    for(int i=0;i<E;i++){
             int sv = s.nextInt();
             int ev = s.nextInt();
             
            graph[sv][ev]=1;
             graph[ev][sv]=1;
         }
        int sv = s.nextInt();
        int ev = s.nextInt();
        ArrayList<Integer> ans = getpath(graph,sv,ev);
		if(ans!=null){
            for(int i : ans){
            System.out.print(i+" ");
        }
        }
	}
    public static ArrayList<Integer> getpath(int[][] graph,int sv,int ev){
    boolean visited[] = new boolean[graph.length];
    return getpath(graph,sv,ev,visited);
    
}
public static ArrayList<Integer> getpath(int[][] graph,int sv,int ev,boolean[] visited){
    if(sv==ev && graph[sv][ev]==1){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(sv);
        return ans;
    }
    HashMap<Integer,Integer> map = new HashMap<>();
    ArrayList<Integer> smallAns = new ArrayList<Integer>();
    Queue<Integer> queue = new LinkedList<>();
    
    queue.add(sv);
    visited[sv] = true;
    
    while(!queue.isEmpty()){
        int front = queue.remove();
        
        for(int i = 0;i<graph.length;i++){
            if(graph[front][i] == 1 && !visited[i]){
                queue.add(i);
                map.put(i,front);
                visited[i] = true;
                if(i == ev){
                    int value = map.get(i);
                    smallAns.add(ev);
                    while(value != sv){
                        smallAns.add(value);
                        value = map.get(value);
                        
                    }
                    smallAns.add(value);
                    return smallAns;
                    
                }
            }
        }
        
    }
 return null;   
}
}
