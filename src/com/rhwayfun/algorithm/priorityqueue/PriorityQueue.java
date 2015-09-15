package com.rhwayfun.algorithm.priorityqueue;

/**
 * 
 * <p>Title:PriorityQueue</p>
 * <p>Description:优先队列的java实现</p>
 * @author rhwayfun
 * @date Aug 21, 2015 10:33:21 AM
 * @version 1.0
 */
public class PriorityQueue {
	
	//往有限队列中增加元素
	public void insert(int value,Heap heap){
		int i = 0;
		//判断当前堆是否已满
		if(isFull(heap)){
			System.out.println("堆已满，插入失败！");
		}
		/* 由于是插入一个元素，而堆是数组实现的，数组长度固定，每次插入一个元素时都把堆的大小增加1
		 * 根据堆的性质，任意一个子树的根节点都比其孩子节点的值小，把要插入的值和其父节点的值比较
		 * 而堆中元素的排列都是从根节点开始依次从左往右添加到数组中，所以对于堆中任意一个节点i
		 * 其父节点为(i/2)，左孩子节点为2i，右孩子为2i+1
		 */
		for(i = ++heap.size; heap.values[i/2] > value; i /= 2){
			heap.values[i] = heap.values[i/2];
		}
		//循环结束说明value找到了其要插入的位置，就是i，现在只需要把i位置上的值改为要插入的值大小即可
		heap.values[i] = value;
	}

	public int delete(Heap heap){
		/* 根据堆的定义要删除一个元素实际上就是删除堆的根，由于是根节点，所以根节点必须由新的节点替代
		 * 思路：把堆的最后一个节点取出来（不是删除！），然后从根节点位置开始遍历，每次遍历都要从其左右
		 * 孩子节点中选取较小的元素放入其父节点的位置（因为按照堆的性质父节点的值必然小雨其子节点的值），
		 * 遍历的终止条件就是子节点的位置小于堆的大小。遍历结束，说明程序已经找到要把堆中最后一个元素放入
		 * 的位置。然后把最后一个元素的值赋给该位置的值就可以了。
		 */
		int i,child = 0;
		int lastElement,minElement;
		//堆为空
		if(heap.size == 0){
			System.out.println("堆为空，删除失败！");
		}
		//如果不为空，则拿到堆的根节点和最后一个节点
		minElement = heap.values[1];//堆的根节点，也就是最小的节点
		lastElement = heap.values[heap.size];//堆的最后一个节点
		
		//这个循环就是为了找到最后一个元素插入的位置
		for(i = 1; 2*i < heap.size; i = child){
			child = 2*i;
			//找到当前节点左右孩子节点中较小的节点
			if(child != heap.size && heap.values[child + 1] < heap.values[child]){
				//如果当前节点的左孩子大于右孩子则较小的孩子节点就是右孩子了
				child++;
			}
			//往下走一层
			if(lastElement > heap.values[child]){
				heap.values[i] = heap.values[child];
			}else{
				break;
			}
		}
		
		//循环结束，位置已找到就是i
		heap.values[i] = lastElement;
		return minElement;
	}
	private boolean isFull(Heap heap) {
		if(heap.size < heap.capacity)
			return false;
		return true;
	}
}
