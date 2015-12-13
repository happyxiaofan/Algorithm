package com.rhwayfun.algorithm.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class MyGraph {
	private static final String NEWLINE = System.getProperty("line.separator");
	
	//������Ŀ
	private int V;
	//�ߵ���Ŀ
	private int E;
	//�ڽӱ�
	private Bag<Integer>[] adj;
	
	//���캯��
	@SuppressWarnings("unchecked")
	public MyGraph(int V){
		this.V = V;
		this.E = 0;
		//�����ڽӱ�
		adj = (Bag<Integer>[])new Bag[V];
		//�����������ʼ��Ϊ��
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}
	
	//�ӱ�׼�������ж���һ��ͼ
	public MyGraph(In in){
		//����������
		this(in.readInt());
		//������ȡ����
		int E = in.readInt();
		if(E < 0) throw new IllegalArgumentException("�����������0");
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
	
	//Ϊ����v��ӱ�w
	public void addEdge(int v,int w){
		//��w��ӵ�v��������
		adj[v].add(w);
		//��v��ӵ�w��������
		adj[w].add(v);
		E++;
	}
	
	//���ض���v���е��ڽӵ�
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	//���ؽ��v�Ķ�
	public int degree(int v){
		return adj[v].size();
	}
	
	//����ͼ���ַ�����ʾ
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
