package org.practice.dataStructure.community01.ch05.matrix;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc AppMatrix2
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012-07-04 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppMatrix2 {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //构建图
            MatrixGraph graph = buildMatrix();
            //广度遍历
            BFSTraverse(graph);

            //构建图
            MatrixGraph graph2 = buildMatrix();
            //深度遍历
            DFSTraverse(graph2, 0);
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
     * 广度遍历
     */
    public static void BFSTraverse(MatrixGraph graph) {
        Deque deque = new ArrayDeque();
        for (int i = 0; i < graph.vertexNum; i++) {
            if (!graph.isTraveled[i]) {
                deque.add(graph.vertex[i]);
                graph.isTraveled[i] = true;
                System.out.print(i + " ");
            }
            for (int j = 0; j < graph.vertexNum; j++) {
                if (j != i && !graph.isTraveled[j] && (graph.edges[i][j] != null || graph.edges[j][i] != null)) {
                    deque.add(graph.vertex[j]);
                    graph.isTraveled[j] = true;
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * 深度遍历
     */
    public static void DFSTraverse(MatrixGraph graph, Integer start) {
        if (!graph.isTraveled[start]) {
            graph.isTraveled[start] = true;
            System.out.print(start + " ");
        }
        for (int i = 0; i < graph.vertexNum; i++) {
            if (i != start && !graph.isTraveled[i] && (graph.edges[i][start] != null || graph.edges[start][i] != null)) {
                DFSTraverse(graph, i);
            }
        }
        return;
    }
}






















