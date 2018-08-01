package GraphBasics.DFSAndComponents;

/**
 * @ Description: 图的接口
 * @ Date: Created in 12:14 2018/8/1
 * @ Author: Anthony_Duan
 */
public interface Graph {
    public int V();

    public int E();

    public void addEdge(int v, int w);

    boolean hasEdge(int v, int w);

    void show();

    public Iterable<Integer> adj(int v);
}
