package MinimumSpanTrees;

/**
 * @ Description: 带全图接口
 * @ Date: Created in 07:54 2018/8/2
 * @ Author: Anthony_Duan
 */
public interface WeightedGraph<Weight extends Number & Comparable>  {

    //返回节点个数
    public int V();

    //返回边个数
    public int E();

    public void addEdge(Edge<Weight> e);

    boolean hasEdge(int v, int w);

    void show();

    public Iterable<Edge<Weight>> adj(int v);
}
