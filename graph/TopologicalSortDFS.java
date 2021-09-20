package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSortDFS {

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

        TopologicalSortDFS obj = new TopologicalSortDFS();
        int [] ans = obj.topoSort(adj,V);
        System.out.println(Arrays.toString(ans));

    }

    private int[] topoSort(ArrayList<ArrayList<Integer>> adj, int v) {
        Stack<Integer> s = new Stack<>();
        int[] visited = new int[v];// default value of an int array is 0, On the other side for Integer array it is null
        for (int i =0; i< v; i++){
            if (visited[i] == 0){
                findTopoSort(adj,i,s,visited);
            }
        }

        // put values from stack to an array because we have to return an array
        int[] topo = new int[v];
        int ind =0;
        while (!s.isEmpty()){
            topo[ind++] = s.pop();
        }
        return topo;
    }

    private void findTopoSort(ArrayList<ArrayList<Integer>> adj, int node, Stack<Integer> s, int[] visited) {
        visited[node] = 1;
        for (Integer it : adj.get(node)){
            if (visited[it] == 0){
                findTopoSort(adj,it,s,visited);
            }
        }
        s.push(node);
    }
}
