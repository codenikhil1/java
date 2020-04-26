package graph;

import java.util.Arrays;
import java.util.Scanner;
class Edge implements Comparable<Edge>{
	int source;
	int dest;
	int weight;
	
	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;  //To Sort in increasing order
	}
}
public class Kruskals_Algorithm {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
		Edge input[] = new Edge[E];
		for(int i=0;i<E;i++) {
			input[i] = new Edge();
			input[i].source = s.nextInt();
			input[i].dest = s.nextInt();
			input[i].weight = s.nextInt();
		}
		Kruskals(input,V);
	}

	private static void Kruskals(Edge[] input, int v) {
		Arrays.sort(input);
		
		Edge output[] = new Edge[v-1];
		int parent[] = new int[v];
		for(int i=0;i<v;i++) {
			parent[i]=i;
		}
		int count = 0;
		int i=0;
		while(count != v-1) {
			Edge currentEdge = input[i];
			int sourceParent = findParent(input[i].source,parent);
			int destParent = findParent(input[i].dest,parent);
		
			if(sourceParent != destParent) {
				output[count] = currentEdge;
				count++;
				parent[sourceParent] = destParent;
			}
			i++;
														
		}
		for(int j=0;j<v-1;j++) {
			if(output[j].source < output[j].dest) {
				System.out.println(output[j].source + " " + output[j].dest + " "+ output[j].weight);
			}else {
				System.out.println(output[j].dest + " " + output[j].source + " "+ output[j].weight);
			}
		}
		
		
		
		
		
	}

	private static int findParent(int source, int[] parent) {
		if(parent[source] == source) {
			return source;
		}
		return findParent(parent[source],parent);
	}

}
