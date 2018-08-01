package GraphBasics.DFSAndComponents;

import java.util.Vector;

/**
 * @ Description: 用邻接矩阵表示稠密图
 * @ Date: Created in 11:35 2018/8/1
 * @ Author: Anthony_Duan
 */
public class DenseGraph implements Graph {
    //节点数
    private int n;

    //边数
    private int m;
    //是否为有向图
    private boolean directed;

    //图的具体数据
    private boolean[][] g;



    public DenseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        //初始化没有任何边
        this.m = 0;
        this.directed = directed;

        //g初始化为n*n的布尔矩阵，每一个g[i][j]均为false，表示没有任何边
        //false为Boolean型的变量的默认值
        g = new boolean[n][n];
    }

    //返回节点个数
    @Override
    public int V(){
        return n;
    }

    //返回边的个数
    @Override
    public int E(){
        return m;
    }


    //向图中添加一个边
    @Override
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        //首先判断边是否存在，如果存在什么都不做
        if (hasEdge(v, w)) {
            return;
        }

        g[v][w] = true;
        //如果不是有向图
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    // 验证图中是否有从v到w的边
    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(g[i][j] + "\t");
            }
            System.out.println();
        }
    }


    /**
     * 返回图中一个顶点的所有邻边
     * 由于java使用引用机制，返回一个Vector不会带来额外开销
     * @param v
     * @return
     */
    @Override
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<Integer>();

        for (int i = 0; i < n; i++) {
            if (g[v][i]) {
                adjV.add(i);
            }
        }

        return adjV;
    }


}
