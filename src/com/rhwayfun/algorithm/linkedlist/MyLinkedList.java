package com.rhwayfun.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * <p>Title:MyLinkedList</p>
 * <p>Description: �������</p>
 * @author rhwayfun
 * @date 2015-8-13 ����11:45:12
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

//����������
class InnerLinkedList{
	//��ӡ������������Ԫ��
	public void printLinkedListElements(){
		//ʹ��java���ö��󴴽�һ��������
		LinkedList<Person> linkedList = new LinkedList<Person>();
		//���һЩԪ��
		Person p1 = new Person("������",20);
		Person p2 = new Person("����ѩ",19);
		Person p3 = new Person("����˧",300);
		Person p4 = new Person("���ӷ�",21);
		Person p5 = new Person("����",18);
		
		linkedList.add(p1);
		linkedList.add(p2);
		linkedList.add(p3);
		linkedList.add(p4);
		linkedList.add(p5);
		
		System.out.println("����\t����\t");
		for (Person person : linkedList) {
			System.out.println(person.getName()+"\t"+person.getAge());
		}
	}
}

//�ڵ���
class Node{
	
	//ָ����
	public Node next;
	//������
	public int key;
	//�ڵ�����
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

//������
class MyNodeList{
	
	private List<Node> nodeList;
	
	public MyNodeList(){
		nodeList = new ArrayList<Node>();
		create();
	}
	//��������
	public void create(){
		
		//����ͷ��㣬ͷ���û����ֵ��ֻ��Ϊ��ʶ����
		Node head = new Node("head");
		
		//������ͨ�ڵ�
		Node node1 = new Node(88,"node1");
		Node node2 = new Node(12,"node2");
		Node node3 = new Node(9,"node3");
		Node node4 = new Node(93,"node4");
		Node node5 = new Node(4,"node5");
		Node node6 = new Node(25,"node6");
		
		//�ѽڵ㴮������
		head.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		
		//���뼯����
		nodeList.add(head);
		nodeList.add(node1);
		nodeList.add(node2);
		nodeList.add(node3);
		nodeList.add(node4);
		nodeList.add(node5);
		nodeList.add(node6);
	}
	
	//�ж��Ƿ�Ϊ�ձ�
	public boolean isEmpty(List<Node> nodeList){
		return nodeList==null;
	}
	
	//������Ϊ��
	public void makeEmpty(List<Node> nodeList){
		for (Node node : nodeList) {
			nodeList.remove(node);
		}
	}
	
	//���Ե�ǰ��ֵ�Ƿ�Ϊ���һ���ڵ�
	public boolean isLast(List<Node> nodeList,int key){
		boolean flag = false;
		if((nodeList.get(nodeList.size()-1).key)==key){
			flag = true;
		}
		return flag;
	}
	
	//����ĳ����ֵ�������еĽڵ�λ��
	public Node find(List<Node> nodeList,int key){
		Node position = null;
		for (Node node : nodeList) {
			if(node.key == key && node != null){
				position = node.next;
			}
		}
		return position;
	}
	
	//ɾ�������е�Ԫ��
	public void delete(List<Node> nodeList,int key){
		Node postion,tmpNode;
		//�ҵ�Ҫɾ��Ԫ�ص�ǰһ��Ԫ��
		postion = findPrevious(nodeList,key);
		//�жϵ�ǰԪ���Ƿ�Ϊ���һ��Ԫ��
		while(!isLast(nodeList,key)){
			tmpNode = postion.next;
			postion.next = tmpNode.next;
		}
	}

	//����ĳ��Ԫ�ص�ǰһ���ڵ�
	private Node findPrevious(List<Node> nodeList, int key) {
		Node position = null;
		for (Node node : nodeList) {
			if(node.next.key == key && node.next != null){
				position = node.next;
			}
		}
		return position;
	}
	
	//����һ��Ԫ��
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

//person��
class Person{
	
	private String name;
	private int age;
	
	/**
	 * <p>Description: ���췽��</p>
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
