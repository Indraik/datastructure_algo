package Graphs;

class DijkstraGraphMatrix{
	static int[][] adjMAtrix;
	static int numVert;
	public DijkstraGraphMatrix(int numVert) {
		DijkstraGraphMatrix.numVert = numVert;
		adjMAtrix = new int[numVert][numVert];
	}
	public static void addEdge(int src,int dest,int weight) {
		adjMAtrix[src][dest] = weight;
	}
	public static void dijkstra() {
		
	}
}

public class Dijkstra {

	public static void main(String[] args) {
		
	

	}

}
