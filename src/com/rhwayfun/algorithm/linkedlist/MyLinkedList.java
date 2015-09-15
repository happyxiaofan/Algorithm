package com.rhwayfun.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * <p>Title:MyLinkedList</p>
 * <p>Description: 链表程序</p>
 * @author rhwayfun
 * @date 2015-8-13 下午11:45:12
 * @version 1.0
 */
public class MyLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*InnerLinkedList ml = new InnerLinkedList();
		ml.printLinkedListElements();*/
		
		MyNodeList mnl = new MyNodeList();
		List<Node> nodeList = mnl.getNodeList();
		System.out.println(nodeList);
	}

	
}

//内置链表类
class InnerLinkedList{
	//打印输出链表的所有元素
	public void printLinkedListElements(){
		//使用java内置对象创建一个空链表
		LinkedList<Person> linkedList = new LinkedList<Person>();
		//添加一些元素
		Person p1 = new Person("李星云",20);
		Person p2 = new Person("姬如雪",19);
		Person p3 = new Person("不良帅",300);
		Person p4 = new Person("张子凡",21);
		Person p5 = new Person("林轩",18);
		
		linkedList.add(p1);
		linkedList.add(p2);
		linkedList.add(p3);
		linkedList.add(p4);
		linkedList.add(p5);
		
		System.out.println("姓名\t年龄\t");
		for (Person person : linkedList) {
			System.out.println(person.getName()+"\t"+person.getAge());
		}
	}
}

//节点类
class Node{
	
	//指针域
	public Node next;
	//数据域
	public int key;
	//节点名称
	private String nodeName;
	
	/**
	 * @return the nodeName
	 */
	public String getNodeName() {
		return nodeName;
	}
	/**
	 * @param nodeName the nodeName to set
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	/**
	 * @return the next
	 */
	public  Node getNext() {
		return next;
	}
	/**
	 * @param next the next to set
	 */
	public  void setNext(Node next) {
		this.next = next;
	}
	/**
	 * @return the key
	 */
	public  int getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public  void setKey(int key) {
		this.key = key;
	}
	
	
	public Node(){
	}
	
	public Node(Node next,int key){
		this.next = next;
		this.key = key;
	}
	
	public Node(int key,String nodeName){
		this.key = key;
		this.nodeName = nodeName;
	}
	
	public Node(String nodeName) {
		this.nodeName = nodeName;
	}
	
	@Override
	public String toString() {
		if(this.next != null){
			return "[key=" + this.key + ", node=" + this.nodeName + ", next=" + this.next.nodeName + "]";
		}
		return "[key=" + this.key + ", node=" + this.nodeName + ", next=" + null + "]";
	}
}

//链表类
class MyNodeList{
	
	private List<Node> nodeList;
	
	public MyNodeList(){
		nodeList = new ArrayList<Node>();
		create();
	}
	//创建链表
	public void create(){
		
		//创建头结点，头结点没有数值，只作为标识作用
		Node head = new Node("head");
		
		//创建普通节点
		Node node1 = new Node(88,"node1");
		Node node2 = new Node(12,"node2");
		Node node3 = new Node(9,"node3");
		Node node4 = new Node(93,"node4");
		Node node5 = new Node(4,"node5");
		Node node6 = new Node(25,"node6");
		
		//把节点串接起来
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		
		//加入集合中
		nodeList.add(head);
		nodeList.add(node1);
		nodeList.add(node2);
		nodeList.add(node3);
		nodeList.add(node4);
		nodeList.add(node5);
		nodeList.add(node6);
	}
	
	//判断是否为空表
	public boolean isEmpty(List<Node> nodeList){
		return nodeList==null;
	}
	
	//让链表为空
	public void makeEmpty(List<Node> nodeList){
		for (Node node : nodeList) {
			nodeList.remove(node);
		}
	}
	
	//测试当前数值是否为最后一个节点
	public boolean isLast(List<Node> nodeList,int key){
		boolean flag = false;
		if((nodeList.get(nodeList.size()-1).key)==key){
			flag = true;
		}
		return flag;
	}
	
	//查找某个数值在链表中的节点位置
	public Node find(List<Node> nodeList,int key){
		Node position = null;
		for (Node node : nodeList) {
			if(node.key == key && node != null){
				position = node.next;
			}
		}
		return position;
	}
	
	//删除链表中的元素
	public void delete(List<Node> nodeList,int key){
		Node postion,tmpNode;
		//找到要删除元素的前一个元素
		postion = findPrevious(nodeList,key);
		//判断当前元素是否为最后一个元素
		while(!isLast(nodeList,key)){
			tmpNode = postion.next;
			postion.next = tmpNode.next;
		}
	}

	//查找某个元素的前一个节点
	private Node findPrevious(List<Node> nodeList, int key) {
		Node position = null;
		for (Node node : nodeList) {
			if(node.next.key == key && node.next != null){
				position = node.next;
			}
		}
		return position;
	}
	
	//插入一个元素
	public void insert(List<Node> nodeList,int key,Node position){
		Node tmpNode = new Node();
		tmpNode.key = key;
		tmpNode.next = position.next;
		position.next = tmpNode;
	}
	
	/**
	 * @return the nodeList
	 */
	public List<Node> getNodeList() {
		return nodeList;
	}
	
	/**
	 * @param nodeList the nodeList to set
	 */
	public void setNodeList(List<Node> nodeList) {
		this.nodeList = nodeList;
	}
}

//person类
class Person{
	
	private String name;
	private int age;
	
	/**
	 * <p>Description: 构造方法</p>
	 * @param name
	 * @param age
	 */
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	/**
	 * @return the name
	 */
	
	public  String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public  void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the age
	 */
	public  int getAge() {
		return age;
	}
	
	/**
	 * @param age the age to set
	 */
	public  void setAge(int age) {
		this.age = age;
	}
	
	
}
