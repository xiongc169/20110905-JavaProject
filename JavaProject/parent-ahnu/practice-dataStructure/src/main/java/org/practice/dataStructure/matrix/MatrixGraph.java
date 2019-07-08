package org.practice.dataStructure.matrix;

/**
 * @Desc MatrixGraph
 * @Author
 * @Date 2019年7月8日15:30:29
 * @Version 1.0
 */
public class MatrixGraph {

    //顶点信息
    private String[] vertex;

    //边信息
    private Integer[][] edges;

    //深搜和广搜的遍历标志
    private boolean[] isTrav;

    //顶点数量
    private Integer vertexNum;

    //边数量
    private Integer edgeNum;

    //图类型
    private Integer graphType;

    public MatrixGraph() {
    }

    public MatrixGraph(Integer vertexNum, Integer edgeNum, Integer graphType) {
        this.vertexNum = vertexNum;
        this.edgeNum = edgeNum;
        this.graphType = graphType;

        this.vertex = new String[vertexNum];
        this.edges = new Integer[vertexNum][vertexNum];
        this.isTrav = new boolean[vertexNum];
    }

    public String[] getVertex() {
        return vertex;
    }

    public void setVertex(String[] vertex) {
        this.vertex = vertex;
    }

    public Integer[][] getEdges() {
        return edges;
    }

    public void setEdges(Integer[][] edges) {
        this.edges = edges;
    }

    public boolean[] getIsTrav() {
        return isTrav;
    }

    public void setIsTrav(boolean[] isTrav) {
        this.isTrav = isTrav;
    }

    public Integer getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(Integer vertexNum) {
        this.vertexNum = vertexNum;
    }

    public Integer getEdgeNum() {
        return edgeNum;
    }

    public void setEdgeNum(Integer edgeNum) {
        this.edgeNum = edgeNum;
    }

    public Integer getGraphType() {
        return graphType;
    }

    public void setGraphType(Integer graphType) {
        this.graphType = graphType;
    }
}
