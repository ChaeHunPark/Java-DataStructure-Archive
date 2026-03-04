package week3.graph;

public class MyGraphTest {
    public static void main(String[] args) {
        // 1. 그래프 생성 (정점 6개: 0 ~ 5)
        MyGraph graph = new MyGraph(6);

        // 2. 간선 연결 (복잡한 경로 테스트)
        // 0번에서 시작해 두 갈래(1, 2)로 나뉘는 구조
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4); // 사이클 생성 (1-3-4-1)

        /*
           그래프 구조 시각화:
              0
             / \
            1   2
           / \   \
          3---4   5
        */

        System.out.println("=== [Graph Traversal Test Start] ===");
        System.out.println("Starting Node: 0\n");

        // --- DFS 비교 ---
        System.out.println("[DFS - 깊이 우선 탐색]");
        graph.dfsRecursive(0); // 인접 리스트 + 재귀
        graph.dfsStack(0);     // 인접 리스트 + 스택
        graph.dfsMatrix(0);    // 인접 행렬 + 재귀
        System.out.println();

        // --- BFS 비교 ---
        System.out.println("[BFS - 너비 우선 탐색]");
        graph.bfsQueue(0);     // 인접 리스트 + 큐
        graph.bfsMatrix(0);    // 인접 행렬 + 큐
        System.out.println();

        System.out.println("=== [Test Finished] ===");
    }
}
