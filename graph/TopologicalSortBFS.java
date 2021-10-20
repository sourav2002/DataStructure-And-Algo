package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 6;
        for (int i =0; i< V; i++){
            adj.add(new ArrayList<Integer>());
        }

        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(1);
        adj.get(4).add(0);
        adj.get(5).add(2);
        adj.get(5).add(0);

        TopologicalSortBFS obj = new TopologicalSortBFS();
        int [] ans = obj.topoSort(adj,V);
        System.out.println(Arrays.toString(ans));

    }

    int[] topoSort(ArrayList<ArrayList<Integer>> adj, int v) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[v];
        for (int i=0; i<v; i++){
            if (visited[i] == 0){
                findTopoSortBFS(adj,i,q,visited);
            }
        }
        // put values from queue to an array because we have to return an array
        int[] topo = new int[v];
        int ind =v-1;
        while (!q.isEmpty()){
            topo[ind--] = q.remove();
        }
        return topo;
    }

    private void findTopoSortBFS(ArrayList<ArrayList<Integer>> adj, int node, Queue<Integer> q, int[] visited) {
        visited[node] = 1;
        for (Integer it: adj.get(node)){
            if (visited[it] == 0){
                findTopoSortBFS(adj,it,q,visited);
            }
        }
        q.add(node);
    }
}
