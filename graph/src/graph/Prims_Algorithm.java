package graph;

import java.util.Scanner;

public class Prims_Algorithm {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();
		int adjacenyMatrix[][] = new int[v][v];
		
		for(int i=0;i<e;i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			int weight = s.nextInt();
			adjacenyMatrix[v1][v2]= weight;
			adjacenyMatrix[v2][v1]= weight;
		}
		prims(adjacenyMatrix);
		
	}

	private static void prims(int[][] adjacenyMatrix) {
		int v = adjacenyMatrix.length;
		int parent[]  = new int[v];
		boolean visited[] = new boolean[v];
		int weight[] = new int[v];
		weight[0]=0;
		parent[0]=0;
		for(int i = 1;i<v;i++) {
			weight[i] = Integer.MAX_VALUE;
		}
		for(int i=0;i<v;i++) {
			//pick vertex with minimum edge
			int minVertex =	findMinVertex(weight,visited);
			visited[minVertex] = true;
			
			for(int j=0;j<v;j++) {
				if(adjacenyMatrix[minVertex][j]!=0 && !visited[j]) {
					if(adjacenyMatrix[minVertex][j] < weight[j]) {
						weight[j]= adjacenyMatrix[minVertex][j];
						parent[j] = minVertex;
					}
				}
			}
		}
		
		for(int i = 1;i<v;i++) {
			if(parent[i] <i) {
				System.out.println(parent[i] + " "+ i + " "+ weight[i]);
			}else {
				System.out.println( i + " "+parent[i] + " "+ weight[i]);
			}
		}
		
	}

	private static int findMinVertex(int[] weight, boolean[] visited) {
		int minVertex=-1;
		for(int i=0;i<weight.length;i++) {
			if(!visited[i] && (minVertex == -1 || weight[i]<minVertex)) {
				minVertex = i;
			}
		}
		return minVertex;
	}

}
