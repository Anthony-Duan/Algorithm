package GraphBasics.DFSAndComponents;

import java.util.Vector;

/**
 * @ Description: 用邻接表表示稀疏图
 * @ Date: Created in 11:35 2018/8/1
 * @ Author: Anthony_Duan
 */
public class SparseGraph implements Graph {
    //节点数
    private int n;
    //边数
    private int m;
    //是否为有向图
    private boolean directed;
    //图的具体数据
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        //初始化没有任何边
        this.m = m;
        this.directed = directed;

        //g初始化为n个空vector 表示每一个g[i]都表示为空，即没有任何边
        g = (Vector<Integer>[]) new Vector[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<Integer>();
        }
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


    /**
     * 向图中添加一个边
     * 这里并没有处理平行边的情况
     * 因为邻接表如果要考虑没有平行边，每次添加边都需要遍历一次g[v]
     * 效率太低，所以一般是先添加，最后一次性处理，
     * 这里就暂时允许有平行边
     * @param v
     * @param w
     */
    @Override
    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        g[v].add(w);
        if (v != w && !directed) {
            g[w].add(v);
        }
        m++;
    }



    @Override
    public void show() {
        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ ) {
                System.out.print(g[i].elementAt(j) + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].elementAt(i) == w) {
                return true;
            }
        }
        return false;
    }


    /**
     * 返回图中一个顶点的所有邻边
     * 由于java使用引用机制所以返回一个Vector不会带来额外开销
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
