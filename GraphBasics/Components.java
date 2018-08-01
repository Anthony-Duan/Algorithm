package GraphBasics.DFSAndComponents;

/**
 * @ Description: 求无全图的联通分量
 * @ Date: Created in 12:37 2018/8/1
 * @ Author: Anthony_Duan
 */
public class Components {

    //图的引用
    Graph G;
    //激励dfs的过程中节点是否被访问
    private boolean[] visited;
    //记录联通分量个数
    private int ccount;
    //每个节点所对应的联通分量标记
    private int[] id;


    //图的深度优先遍历
    void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;
        for (int i :
                G.adj(v)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    //构造函数，求出无全图的联通分量
    public Components(Graph graph) {
        //算法初始化
        G = graph;
        visited = new boolean[G.V()];
        id = new int[G.V()];
        ccount = 0;
        for (int i = 0; i < G.V(); i++) {
            visited[i] = false;
            id[i] = -1;
        }


        //求图的联通分量
        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    //返回图中联通分量的个数
    int count() {
        return ccount;
    }


    //查询v和w是否联通
    boolean isConnected(int v, int w) {
        assert v >= 0 && v < G.V();
        assert w >= 0 && w < G.V();
        return id[v] == id[w];
    }


}
