package com.rhwayfun.algorithm.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class MyGraph {
	private static final String NEWLINE = System.getProperty("line.separator");
	
	//顶点数目
	private int V;
	//边的数目
	private int E;
	//邻接表
	private Bag<Integer>[] adj;
	
	//构造函数
	@SuppressWarnings("unchecked")
	public MyGraph(int V){
		this.V = V;
		this.E = 0;
		//创建邻接表
		adj = (Bag<Integer>[])new Bag[V];
		//将所有链表初始化为空
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}
	
	//从标准输入流中读入一幅图
	public MyGraph(In in){
		//读到顶点数
		this(in.readInt());
		//继续读取边数
		int E = in.readInt();
		if(E < 0) throw new IllegalArgumentException("边数必须大于0");
		for(int e = 0; e < E; e++){
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	//为顶点v添加边w
	public void addEdge(int v,int w){
		//将w添加到v的链表中
		adj[v].add(w);
		//将v添加到w的链表中
		adj[w].add(v);
		E++;
	}
	
	//返回顶点v所有的邻接点
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	//返回结点v的度
	public int degree(int v){
		return adj[v].size();
	}
	
	//返回图的字符串表示
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices," + E + " edges" + NEWLINE);
		for(int v = 0; v < V; v++){
			sb.append(v + ":");
			for(int w : adj[v]){
				sb.append(w + " ");
			}
			sb.append(NEWLINE);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		In in = new In(args[0]);
		MyGraph G = new MyGraph(in);
		StdOut.println(G);
	}
}
