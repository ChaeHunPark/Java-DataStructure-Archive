package week3.graph;

public class GraphPerformanceTest {
    public static void main(String[] args) {
        int v = 5000; // 정점 5,000개
        MyGraph performanceGraph = new MyGraph(v);

        // 무작위로 간선 10,000개 추가 (희소 그래프 환경 조성)
        for (int i = 0; i < 10000; i++) {
            int start = (int) (Math.random() * v);
            int end = (int) (Math.random() * v);
            if (start != end) performanceGraph.addEdge(start, end);
        }

        System.out.println("=== [Performance Test: V=5000, E=10000] ===");

        // 1. 인접 행렬 BFS 성능 측정
        long startTime = System.nanoTime();
        performanceGraph.bfsMatrix(0);
        long matrixTime = System.nanoTime() - startTime;

        // 2. 인접 리스트 BFS 성능 측정
        startTime = System.nanoTime();
        performanceGraph.bfsQueue(0);
        long listTime = System.nanoTime() - startTime;

        System.out.println("\n-------------------------------------------");
        System.out.println("Adjacency Matrix Time: " + (matrixTime / 1_000_000.0) + " ms");
        System.out.println("Adjacency List   Time: " + (listTime / 1_000_000.0) + " ms");
        System.out.println("-------------------------------------------");

        double gap = (double) matrixTime / listTime;
        System.out.printf("인접 리스트가 약 %.1f배 더 빠르다.\n", gap);
    }
}
