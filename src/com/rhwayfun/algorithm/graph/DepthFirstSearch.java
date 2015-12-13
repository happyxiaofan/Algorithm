package com.rhwayfun.algorithm.graph;

/**
 * 深度优先搜索
 * @author Administrator
 *
 */
public class DepthFirstSearch {

	//标记数组
	private boolean[] marked;
	//标记的顶点数量
	private int count;
	
	/**
	 * 
	 * @param G 输入的一幅图
	 * @param s 开始搜索的图的顶点
	 */
	public DepthFirstSearch(MyGraph G,int s){
		marked = new boolean[G.V()];
		dfs(G,s);
	}

	private void dfs(MyGraph G, int v) {
		//访问一个节点后就标记为true
		marked[v] = true;
		System.out.print(v + " ");
		count++;
		for(int w : G.adj(v)){
			if(!marked[w]) dfs(G,w);
		}
	}
	
	public boolean marked(int w){
		return marked[w];
	}
	
	public int count(){
		return count;
	}
	
	public static void main(String[] args) {
		//创建一幅图
		MyGraph G = new MyGraph(6);
		G.addEdge(0, 5);
		G.addEdge(2, 4);
		G.addEdge(3, 2);
		G.addEdge(2, 1);
		G.addEdge(0, 1);
		G.addEdge(0, 2);
		G.addEdge(4, 3);
		G.addEdge(5, 3);
		
		System.out.println(G);
		new DepthFirstSearch(G, 0);
	}
}
