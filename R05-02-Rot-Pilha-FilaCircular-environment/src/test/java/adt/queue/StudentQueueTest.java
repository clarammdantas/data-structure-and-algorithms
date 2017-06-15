package adt.queue;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		queue1 = new QueueImpl(4);
		queue2 = new QueueImpl(2);
		queue3 = new QueueImpl(10);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() throws QueueUnderflowException {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException, QueueUnderflowException {
		queue1.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
		queue1.enqueue(new Integer(10));
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue1.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}
	
	private Integer[] generateQueueElements() {
		Random ran = new Random();
		int size = ran.nextInt(100) + 1;
		
		Integer[] aQueue = new Integer[size];
		for (int i = 0; i < size; i++) {
			aQueue[i] = ran.nextInt(50);
		}
		
		return aQueue;
	}
	
	@Test
	public void testQueue() throws QueueOverflowException, QueueUnderflowException {
		Integer[] q = generateQueueElements();
		Queue q1 = new QueueImpl<>(q.length);
		
		for (int i = 0; i < q.length; i++) {
			q1.enqueue(q[i]);
		}
		
		int i = 0;
		while (!q1.isEmpty()) {
			assertEquals(q[i++], q1.dequeue());
		}
	}
}