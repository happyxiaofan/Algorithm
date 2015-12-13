package com.rhwayfun.algorithm.graph;

/**
 * �����������
 * @author Administrator
 *
 */
public class DepthFirstSearch {

	//�������
	private boolean[] marked;
	//��ǵĶ�������
	private int count;
	
	/**
	 * 
	 * @param G �����һ��ͼ
	 * @param s ��ʼ������ͼ�Ķ���
	 */
	public DepthFirstSearch(MyGraph G,int s){
		marked = new boolean[G.V()];
		dfs(G,s);
	}

	private void dfs(MyGraph G, int v) {
		//����һ���ڵ��ͱ��Ϊtrue
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
		//����һ��ͼ
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
