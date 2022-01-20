package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphWithList {
    private LinkedList<Integer>[] adj;
    private int V;
    private int E;

    public GraphWithList(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes]; // here we created just an array
        for (int v = 0; v < V; v++) {
            // now we are creating linked list on every index of array
            this.adj[v] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        GraphWithList g = new GraphWithList(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
        System.out.println(g);
        System.out.println("BFS traversal : ");
//        g.bfs(0);
        System.out.println(g.bfs());
        System.out.println("DFS traversal : ");
        g.dfs(0);
        System.out.println();
        g.dfsRecursive();
    }

    void addEdge(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + " : ");
            for (int w : adj[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }// end of to string

    public ArrayList<Integer> bfs() {
        ArrayList<Integer> bfsList = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                Queue<Integer> q = new LinkedList<>();
                visited[i] = true;
                q.offer(i);
                while (!q.isEmpty()) {
                    Integer u = q.poll();
//                    System.out.print(u + " ");
                    bfsList.add(u);
                    for (int v : adj[u]) {
                        if (!visited[v]) {
                            visited[v] = true;
                            q.offer(v);
                        }
                    }
                }
            }
        }
        return bfsList;
    }// end of bfs method

    public void dfs(int s) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");

                for (int v : adj[u]) {
                    if (!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }
    }// end of dfs method

    public void dfsRecursive() {
        boolean[] visited = new boolean[V];
        // when we passed s = 0 then our dfs method can only traverse the nodes which are connected,
        // but if we have a node which are not connected to any other than we can't track that node,
        // so we are using for loop to traverse to that single node also
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                dfs(v, visited);
            }
        }
    }

    private void dfs(int v, boolean[] visited) {
        // make v = true
        visited[v] = true;
        System.out.print(v + " ");
        // now check all the adjacent nodes and check if they are already visited or not
        // if not then do the same step for adjacent node
        for (int w : adj[v]) {
            if (!visited[w]) {
                dfs(w, visited);// this time we passed w (adjacent node of v)
            }
        }
    }

}
