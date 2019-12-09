package org.practice.dataStructure.ch05.matrix;

/**
 * @Desc 邻接矩阵存储
 * @Author
 * @Date 2019年7月8日15:30:29
 * @Version 1.0
 */
public class MatrixGraphLite {

    //顶点信息
    public String[] vertex;

    //边信息，值表示边的权值
    public Integer[][] edges;

    //遍历标志
    public boolean[] isTraveled;

    public MatrixGraphLite() {
    }

    /**
     * 构造函数
     *
     * @param vertexNum 顶点数
     */
    public MatrixGraphLite(Integer vertexNum) {
        this.vertex = new String[vertexNum];
        this.edges = new Integer[vertexNum][vertexNum];
        this.isTraveled = new boolean[vertexNum];
    }
}
