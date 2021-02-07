package com.yoong.dataStructure.community01.ch05.matrix;

/**
 * @Desc 邻接矩阵存储
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012-07-04 09:00:00
 * <p>
 * @Version 1.0
 */
public class MatrixGraph {

    //顶点信息
    public String[] vertex;

    //边信息，值表示边的权值
    public Integer[][] edges;

    //深搜和广搜的遍历标志
    public boolean[] isTraveled;

    //顶点数量
    public Integer vertexNum;

    //边数量
    public Integer edgeNum;

    //图类型
    public Integer graphType;

    public MatrixGraph() {
    }

    /**
     * 构造函数
     *
     * @param vertexNum 顶点数
     * @param edgeNum   边数
     * @param graphType
     */
    public MatrixGraph(Integer vertexNum, Integer edgeNum, Integer graphType) {
        this.vertexNum = vertexNum;
        this.edgeNum = edgeNum;
        this.graphType = graphType;

        this.vertex = new String[vertexNum];
        this.edges = new Integer[vertexNum][vertexNum];
        this.isTraveled = new boolean[vertexNum];
    }
}
