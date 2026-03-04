package week3.graph;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MyGraph {
    private int v;
    private int[][] matrix; // 1. 인접 행렬 방식
    private ArrayList<ArrayList<Integer>> adj; // 2. 인접 리스트 방식

    public MyGraph(int v) {
        this.v = v;
        matrix = new int[v][v];
        adj = new ArrayList<>(v);
        for (int i=0; i<v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int start, int end) {
        // matrix
        matrix[start][end] = 1;
        matrix[end][start] = 1;
        // list
        adj.get(start).add(end);
        adj.get(end).add(start);
    }

    // DFS (깊이 우선 탐색)

    // [방법 1] 재귀 방식 (가장 많이 쓰이는 방식)
    public void dfsRecursive(int start) {
        boolean[] visited = new boolean[v];
        System.out.print("DFS (Recursive): ");
        dfsRecursiveLogic(start, visited);
        System.out.println();
    }

    private void dfsRecursiveLogic(int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");
        for (int neighbor : adj.get(current)) {
            if(!visited[neighbor]) {
                dfsRecursiveLogic(neighbor, visited);
            }
        }
    }

    // [방법 2] 스택 방식
    public void dfsStack(int start) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        System.out.print("DFS (Stack): ");
        while (!stack.isEmpty()) {
            int current = stack.pop();

            if(!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");

                // 스택이라 역순으로 넣어야 재귀와 순서가 비슷해짐
                List<Integer> neighbors = adj.get(current);
                for(int i = neighbors.size() -1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if(!visited[neighbor]) stack.push(neighbor);
                }
            }
        }
        System.out.println();
    }

    // [방법 1] 큐 방식 (최단 거리 핵심)
    public void bfsQueue(int start) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS (Queue): ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // --- [인접 행렬 기반 DFS] ---
    public void dfsMatrix(int start) {
        boolean[] visited = new boolean[v];
        System.out.print("DFS Matrix (Recursive): ");
        dfsMatrixLogic(start, visited);
        System.out.println();
    }

    private void dfsMatrixLogic(int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");

        // [차이점] i번 정점의 모든 열을 순회하며 연결된(1인) 곳을 찾음
        for (int i = 0; i < v; i++) {
            if (matrix[current][i] == 1 && !visited[i]) {
                dfsMatrixLogic(i, visited);
            }
        }
    }

    // --- [인접 행렬 기반 BFS] ---
    public void bfsMatrix(int start) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Matrix (Queue): ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            // [차이점] 행렬의 한 줄을 다 검사해서 연결된 친구들을 큐에 넣음
            for (int i = 0; i < v; i++) {
                if (matrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }
}