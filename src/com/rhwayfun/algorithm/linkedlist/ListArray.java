package com.rhwayfun.algorithm.linkedlist;

/**
 * 
 * <p>Title:ListArray</p>
 * <p>Description:使用数组实现线性表</p>
 * @author rhwayfun
 * @date Aug 27, 2015 11:02:33 AM
 * @version 1.0
 */
public class ListArray implements List {

	//数组容量
	private int len = 8;
	//数组中元素的个数
	private int size;
	//数组之间元素的比较策略
	private Strategy strategy;
	//用于装载数据元素的数组
	private Object[] elements;
	
	public ListArray(){
		this(new DefaultStrategy());
	}
	
	public ListArray(Strategy strategy) {
		this.strategy = strategy;
		size = 0;
		elements = new Object[len];
	}

	//判断数组中是否包含元素e
	public boolean contains(Object e) {
		boolean isContains = false;
		for (int i = 0; i < elements.length; i++) {
			if(strategy.equal(elements[i], e)){
				isContains = true;
			}
		}
		return isContains;
	}

	//获取第i位置上元素
	public Object get(int i) {
		if(i < 0 || i > size){
			System.out.println("下标越界，获取失败！");
			return null;
		}
		return elements[i];
	}

	//获取数组元素的个数
	public int getSize() {
		return size;
	}

	//在第i个位置插入数据元素e
	public boolean insert(int i, Object e) throws OutOfBoundException {
		if(i < 0 || i > size){
			System.out.println("下标越界，插入失败！");
			return false;
		}else{
			//如果数组中元素的大小超过了数组的容量，则增大数组的容量
			if(size >= elements.length){
				expandSpace();
			}
			//把从第i位置的元素开始到最后一个元素，都往后移动一个位置
			for(int j = size - 1; j > i; j--){
				elements[j] = elements[j-1];
			}
			//把第i位置的值改为e
			elements[i] = e;
			//把数组元素的格式增加1
			size++;
			return true;
		}
	}

	//动态扩展数组容量
	private void expandSpace() {
		Object[] newArray = new Object[elements.length*2];
		for (int i = 0; i < elements.length; i++) {
			newArray[i] = elements[i];
		}
		elements = newArray;
	}

	//在元素j的后面插入元素e
	public boolean insertAfter(Object j, Object e) {
		//定位元素j的位置
		int i = indexOf(j);
		try {
			if(i != -1){
				insert(i + 1, e);
				return true;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
	}

	//在元素j的前面插入元素e
	public boolean insertBefore(Object j, Object e) {
		//定位元素j的位置
		int i = indexOf(j);
		try {
			if(i != -1){
				insert(i, e);
				return true;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
	}

	//判断数组中是否元素
	public boolean isEmpty() {
		return size == 0;
	}

	//移除数组中第i位置的元素并返回
	public Object remove(int i) throws OutOfBoundException {
		Object e = get(i);
		if(i < 0 || i > size){
			System.out.println("下标越界，删除失败！");
			return null;
		}
		for (int j = i; j < size - 1; j++) {
			elements[j] = elements[j + 1];
		}
		//把数组的元素个数减少1
		elements[--size] = null;
		return e;
	}

	//删除元素e，并判断是否删除成功
	public boolean remove(Object e) {
		boolean isRemove = false;
		//判断数组中是否存在元素e
		if(contains(e)){
			//获取该元素的下标
			int i = indexOf(e);
			for (int j = i; j < size - 1; j++) {
				elements[j] = elements[j + 1];
			}
			isRemove = true;
		}
		return isRemove;
	}

	//把数组中第i位置的元素替换为e
	public void replace(int i, Object e) throws OutOfBoundException {
		if(i < 0 || i > size){
			System.out.println("替换失败");
			return;
		}
		elements[i] = e;
	}

	//定位元素e的位置
	public int indexOf(Object e) {
		for (int i = 0; i < size; i++) {
			if(strategy.equal(elements[i], e)){
				return i;
			}
		}
		return -1;
	}

}
