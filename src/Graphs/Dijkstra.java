package Graphs;

class DijkstraGraphMatrix {
    int numVert;
    int[][] adjMatrix;

    public DijkstraGraphMatrix(int numVert) {
        this.numVert = numVert;
        adjMatrix = new int[numVert][numVert];
    }

    public void addEdge(int src, int dest, int weight) {
        adjMatrix[src][dest] = weight;
    }

    public void dijkstra(int start) {
        int[] dist = new int[numVert];
        boolean[] visited = new boolean[numVert];
        for (int i = 0; i < numVert; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[start] = 0;
        for (int count = 0; count < numVert - 1; count++) {
            int u = minDistance(dist, visited);
            if (u == -1) break; // All reachable vertices processed
            visited[u] = true;
            for (int v = 0; v < numVert; v++) {
                if (!visited[v] && adjMatrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + adjMatrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + adjMatrix[u][v];
                }
            }
        }
        for (int i = 0; i < numVert; i++) {
            System.out.println("Distance from " + start + " to " + i + " is " + dist[i]);
        }
    }

    private int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < numVert; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}

public class Dijkstra {
    public static void main(String[] args) {
        DijkstraGraphMatrix graph = new DijkstraGraphMatrix(5);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 4, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 0, 7);
        graph.addEdge(3, 2, 6);
        graph.addEdge(4, 1, 3);
        graph.addEdge(4, 2, 9);
        graph.addEdge(4, 3, 2);
        graph.dijkstra(0);
    }
}
