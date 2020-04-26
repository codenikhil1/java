package graph;

import java.util.Scanner;
import java.util.ArrayList;

public class GetPathdfs {

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
        ArrayList<Integer> ans = getPath(graph,sv,ev);
		for(int i : ans){
            System.out.print(i+" ");
        }
	}
    
    public static ArrayList<Integer> getPath(int[][] graph,int sv,int ev){
        boolean[] visited = new boolean[graph.length];
        return getPathH(graph,sv,ev,visited);
        
    }
    
    public static ArrayList<Integer>  getPathH(int[][] graph,int sv,int ev,boolean[] visited){
        if(sv == ev){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(sv);
            return ans;
        }
        ArrayList<Integer> smallAns = new ArrayList<>();
        visited[sv]  = true;
        for(int i =0 ; i<graph.length;i++){
            if(graph[sv][i] == 1 && !visited[i]){
                smallAns = getPathH(graph,i,ev,visited);
                if(smallAns!=null){
                    smallAns.add(sv);
                    return smallAns;
                }
            }
        }
        return null;
        
        
        
    }  

}
