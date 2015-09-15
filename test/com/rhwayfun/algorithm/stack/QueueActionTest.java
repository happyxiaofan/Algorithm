package com.rhwayfun.algorithm.stack;

import org.junit.Before;
import org.junit.Test;

public class QueueActionTest {

	private Queue queue;
	private QueueAction queueAction;
	
	@Before
	public void setUp() throws Exception {
		queue = new Queue(5);
		queueAction = new QueueAction();
	}

	@Test
	public void testEnqueue() {
		/*queueAction.enqueue(12);
		queueAction.enqueue(9);
		queueAction.enqueue(93);
		queueAction.enqueue(10);
		queueAction.enqueue(28);
		queueAction.enqueue(13);*/
		queueAction.enqueue(12,queue);
		queueAction.enqueue(9,queue);
		queueAction.enqueue(93,queue);
		queueAction.enqueue(10,queue);
		queueAction.enqueue(28,queue);
		queueAction.enqueue(13,queue);
	}

}
