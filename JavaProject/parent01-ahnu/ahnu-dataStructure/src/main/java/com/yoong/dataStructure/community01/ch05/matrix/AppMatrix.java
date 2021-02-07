package com.yoong.dataStructure.community01.ch05.matrix;

import java.util.PriorityQueue;

/**
 * @Desc AppMatrix
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012-07-04 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppMatrix {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            MatrixGraph graph = buildMatrix();
            BFSTraverse(graph);
            DFSTraverse(graph);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 构建图(邻接矩阵存储)
     */
    public static MatrixGraph buildMatrix() {
        //顶点数
        Integer vertexNum = 8;
        //边数
        Integer edgeNum = 7;
        Integer graphType = 0;
        MatrixGraph graph = new MatrixGraph(vertexNum, edgeNum, graphType);
        //顶点信息
        String[] vertex = {"0", "1", "2", "3", "4", "5", "6", "7"};
        //边信息
        Integer[][] edges = new Integer[vertexNum][vertexNum];
        edges[0][1] = 3;
        edges[0][2] = 1;
        edges[0][3] = 2;
        edges[0][4] = 4;
        edges[3][5] = 5;
        edges[3][6] = 9;
        edges[3][7] = 7;
        graph.vertex = vertex;
        graph.edges = edges;
        return graph;
    }

    /**
     * 广度优先搜索(Breadth First Search)
     */
    public static void BFSTraverse(MatrixGraph graph) {
        for (int i = 0; i < graph.vertex.length; i++) {
            graph.isTraveled[i] = false;
        }
        for (int i = 0; i < graph.vertex.length; i++) {
            if (!graph.isTraveled[i]) {
                BFS(graph, i);
            }
        }
    }

    private static void BFS(MatrixGraph graph, int vertex) {
        PriorityQueue<Integer> toTravel = new PriorityQueue<>();
        toTravel.add(vertex);

        while (toTravel.size() > 0) {
            int tmp = toTravel.poll();
            graph.isTraveled[tmp] = true;
            System.out.println(String.format("遍历 %d 节点", tmp));

            for (int i = 0; i < graph.vertex.length; i++) {
                if (!graph.isTraveled[i] && graph.edges[tmp][i] != null && (graph.edges[tmp][i] != 0 || graph.edges[i][tmp] != 0)) {
                    toTravel.add(i);
                }
            }
        }
    }

    /**
     * 深度优先搜索(Depth First Search)
     */
    public static void DFSTraverse(MatrixGraph graph) {
        for (int i = 0; i < graph.vertex.length; i++) {
            graph.isTraveled[i] = false;
        }
        for (int i = 0; i < graph.vertex.length; i++) {
            if (!graph.isTraveled[i]) {
                DFS(graph, i);
            }
        }
    }

    private static void DFS(MatrixGraph graph, int vertex) {
        System.out.println(String.format("遍历 %d 节点", vertex));
        graph.isTraveled[vertex] = true;

        for (int i = 0; i < graph.vertex.length; i++) {
            if (!graph.isTraveled[i] && graph.edges[vertex][i] != null && (graph.edges[vertex][i] != 0 || graph.edges[i][vertex] != 0)) {
                DFS(graph, i);
            }
        }
    }
}






















