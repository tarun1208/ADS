import java.util.*;

public class DFSAdjMatrix {
    int v;
    int adj[][];
    boolean visited[];

    DFSAdjMatrix(int v) {
        this.v = v;
        adj = new int[v][v];
        visited = new boolean[v];
        Arrays.fill(visited, false);
    }


    public void DFS(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i < v; i++) {
            if (adj[start][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("No of vertices: ");
        int v = sc.nextInt();

        DFSAdjMatrix b = new DFSAdjMatrix(v); 

        System.out.println("Enter adjacency matrix (" + v + "x" + v + "): ");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                b.adj[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter starting vertex for DFS:");
        int start = sc.nextInt();

        System.out.println("DFS Traversal:");
        b.DFS(start);
        sc.close();
    }
}
