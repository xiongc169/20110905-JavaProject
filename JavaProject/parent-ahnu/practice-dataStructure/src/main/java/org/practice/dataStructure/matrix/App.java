package org.practice.dataStructure.matrix;

/**
 * @Desc App
 * @Author
 * @Date
 * @Version 1.0
 */
public class App {

    public static void main(String[] args) {
        try {
            MatrixGraph graph = buildMatrix();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static MatrixGraph buildMatrix() {
        Integer vertexNum = 9;
        Integer edgeNum = 20;
        Integer graphType = 0;
        MatrixGraph graph = new MatrixGraph(vertexNum, edgeNum, graphType);
        //顶点信息
        String[] vertex = {"0", "1", "2", "3", "4", "5", "6", "7"};
        //边信息
        Integer[][] edges = new Integer[][]{};
        edges[0][1] = 3;
        edges[0][2] = 1;
        edges[0][3] = 2;
        edges[0][4] = 4;
        graph.setVertex(vertex);
        graph.setEdges(edges);
        return graph;
    }
}
