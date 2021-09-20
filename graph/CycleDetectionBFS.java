package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionBFS {

    public static void main(String[] args) {

        int n = 4, m = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // edge 1-->2
        adj.get(1).add(2);
        adj.get(2).add(1);

        //edge2-->3
        adj.get(2).add(3);
        adj.get(3).add(2);

        //edge 3-->1 for creating cyclic graph
        adj.get(3).add(4);
        adj.get(4).add(1);

        for (int i = 1; i < n; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }

        CycleDetectionBFS cycle = new CycleDetectionBFS();
        System.out.println(cycle.isCycle(n, adj));
    }

    private boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) { // s is the source or current node
        Queue<Node> q = new LinkedList<>(); //BFS use queue
        q.add(new Node(s, -1));
        visited[s] = true;

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int prev = q.peek().second;
            q.remove();

            for (Integer it : adj.get(node)) { // get the adjacent nodes of current node
                if (visited[it] == false) {// checking if node is visited or not
                    q.add(new Node(it, node));
                    visited[it] = true;
                } else if (prev != it) { // after checking if node is visited or not, if it is already visited
                    // than check for if it is not a previous node if it is not previous than there is a loop in graph
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) { // V is the no. of nodes
        boolean[] vis = new boolean[V + 1];// v+1 because we will assume our array starts from 1 not from 0
        Arrays.fill(vis, false);

        for (int i = 1; i <= V; i++) {
            if (vis[i] == false) {
                if (checkForCycle(adj, i, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Node {
        int first;
        int second;

        public Node(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }
}
