package graph;

public class Graph {

    private int[][] adjMatrix;
    private int V; // vertices in graph
    private int E; // number of edges in graph

    public Graph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        System.out.println(g);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, "+E + " edges "+"\n");
        for (int v =0; v< V; v++){
            sb.append(v+ " : ");
            for (int w : adjMatrix[v]){
                sb.append(w+ " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public void addEdge(int u, int v) {
        this.adjMatrix[u][v] = 1;
        this.adjMatrix[v][u] = 1;// because it is an undirected array
        E++;
    }
}
