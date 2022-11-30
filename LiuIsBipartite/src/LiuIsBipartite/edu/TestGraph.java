package LiuIsBipartite.edu;

import java.util.*;



import java.io.*;

public class TestGraph {

	static final String fileName = "GraphVertices.txt";
	
	public static void main(String[] args) throws FileNotFoundException{
		System.out.print("Enter the name of the input file");
		Scanner in = new Scanner(System.in);
		String fileName = in.nextLine();
		
		
		File file = new File(fileName);
		Scanner reader = new Scanner(file);
		
		//load number of vertices
		int vertices = Integer.parseInt(reader.nextLine());
		
		//load edges
		int[][] edges = new int[vertices][vertices];
		for (int v = 0; v < vertices; v++) {
			String line = reader.nextLine();
			//separate into whitespace, splitting by whitespace
			String[] data = line.split("\\s+");
			
			//first value on each line is supposed to be the origin of the edge
			int origin = Integer.parseInt(data[0]);
			
			//run through all but the first value (since it was supposed to be the origin value)
			for (int i = 1; i < data.length; i++) {
				int value = Integer.parseInt(data[i]);
				edges[origin][value] = 1;
			}
		}
		
		reader.close();
		
		//generate graph
		 UnweightedGraph<Integer> graph = new UnweightedGraph<Integer>(edges, vertices);
			System.out.println("\n");
			
			/*
			 * Connected graph detection algorithm:
			 * 	Run DFS from any vertex.
			 * 	The graph is connected iff all vertices have been visited.
			 */
			
			System.out.println("Please input starting vertex");
			
			int v1 = in.nextInt(); 
			
			System.out.println("Please input ending vertex");
			
			int v2 = in.nextInt(); 
			
			AbstractGraph.Tree bfsTree = graph.bfs(v2);
			System.out.println("Shortest path is: " + bfsTree.getPath(v1));
			
			/*
			if (dfsTree.getNumberOfVerticesFound() == vertices) {
				System.out.println("The graph is connected");
			}
			else {
				System.out.println("The graph is not connected");
			}
			
			if (graph.isCyclic(0)){
				System.out.println("There is a cycle in the graph");
			}
			else {
				System.out.println("There is no cycle in the graph");
			}
			*/
			
	}
}
