package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class CycleDetectionDFS {

    public static void main(String[] args) {
        int vertices = 8;
        CycleDetectionDFS cd = new CycleDetectionDFS();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= vertices + 1; i++) {
            adj.add(new ArrayList<>());
        }
//        1-->3
        adj.get(1).add(3);
        adj.get(3).add(1);
//        3-->4
        adj.get(3).add(4);
        adj.get(4).add(3);
//        2-->5
        adj.get(2).add(5);
        adj.get(5).add(2);
        //        5-->6
        adj.get(5).add(6);
        adj.get(6).add(5);
        //        6-->7
        adj.get(6).add(7);
        adj.get(7).add(6);
        //        7-->8
        adj.get(7).add(8);
        adj.get(8).add(7);
        //        8-->5
        adj.get(8).add(5);
        adj.get(5).add(8);

        for (int i = 1; i <= vertices; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.println(cd.isValid(vertices, adj));

    }

    public boolean isValid(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V + 1];
        Arrays.fill(visited, false);

        for (int i = 1; i <= V; i++) {
            if (visited[i] == false) {
                if (checkForCycleDfs(visited, adj, i)) {// i is the node for which we start iteration
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkForCycleDfs(boolean[] visited, ArrayList<ArrayList<Integer>> adj, int currentNode) {
        Stack<Node> s = new Stack<>();
        s.add(new Node(currentNode,-1));
        visited[currentNode] = true;
        while (!s.isEmpty()) {
            int node = s.peek().first;
            int prev = s.peek().second;
            s.pop();

            for (Integer it : adj.get(node)) {
                if (visited[it] == false) {
                    s.add(new Node(it,node));
                    visited[it] = true;
                } else if (prev != it){
                    return true;
                }
            }
        }
        return false;
    }

    static class Node {
        int first, second;

        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
