package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class graph {
	
	
	public static void printDFS(int[][] edges) {
		int[] visited = new int[edges.length];
		for(int i=0;i<edges.length;i++) {
				if(visited[i] == 0) {
					printDFSHelper(edges,i,visited);
				}
		}
		
	}

	private static void printDFSHelper(int[][] edges, int sv, int[] visited) {
		System.out.println(sv);
		visited[sv]=1;
		
		for(int i=0;i<edges.length;i++) {
			if(edges[sv][i] == 1 && visited[i]!=1 ) {
				printDFSHelper(edges,i,visited);
			}
		}
		
	}
	public static void BFSHelper(int[][] graph,boolean[] visited,int sv){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(sv);
        visited[sv] = true;
        
        while(queue.size()!=0){
            int front = queue.remove();
            System.out.print(front+" ");
            
            for(int i=0;i<graph.length;i++){
                if(graph[front][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
            
    }
        
}
    public static void printBFS(int[][] graph){
        boolean visited[] = new boolean[graph.length];
        
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                BFSHelper(graph,visited,i);
            }
        }
        
            
}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Number of vertices: ");
		int v = s.nextInt();
		System.out.println("Number of edges: ");
		int e = s.nextInt();
		int edges[][] = new int[v][v];
		
		for(int i=0;i<e;i++) {
			System.out.println("Enter Starting vertex: ");
			int sv = s.nextInt();
			System.out.println("Enter ending vertex: ");
			int ev = s.nextInt();
			edges[sv][ev]=1;
		}
		System.out.println("DFS traversal");
		printDFS(edges);
		System.out.println("BFS traversal");
		printBFS(edges);
	}

}
