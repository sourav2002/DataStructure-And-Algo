package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class CycleInDirectedGraphDFS {

    public static void main(String[] args) {
        int n = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(0).add(1);

        adj.get(1).add(2);

        adj.get(2).add(3);

        adj.get(3).add(4);

        adj.get(4).add(5);

        adj.get(4).add(6);

        adj.get(6).add(1);
        CycleInDirectedGraphDFS cycle = new CycleInDirectedGraphDFS();
        cycle.isCyclic(n,adj);
        if (cycle.isCyclic(n, adj) == true) System.out.println("Not Bipartite");// conditions are different in this one
            // as compared to other Bipartite graph
        else System.out.println("Yes Bipartite");

    }

    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj){
        int visited[] = new int[n];
        int dfsVisited[] = new int[n];

        Arrays.fill(visited, 0);
        Arrays.fill(dfsVisited, 0);

        for (int i =0;i<n;i++){
            if (visited[i] ==0){
                if (checkCycle(i,adj, visited,dfsVisited) == true) return true;
            }
        }
        return false;
    }

    private boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] dfsVisited) {

        visited[node] = 1;
        dfsVisited[node] = 1;
        for (Integer it : adj.get(node)){
            if (visited[it] == 0){
                if (checkCycle(it,adj,visited,dfsVisited) == true){
                    return true;
                }
            }else if (dfsVisited[it] == 1){
                return true;
            }
        }
        dfsVisited[node] = 0;
        return false;
     }
}
