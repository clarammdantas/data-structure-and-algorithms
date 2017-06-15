package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private static final int EMPTY = -1;
	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = EMPTY;
	}

	@Override
	public T head() {
		return array[0];
	}

	@Override
	public boolean isEmpty() {
		return tail == EMPTY;
	}

	@Override
	public boolean isFull() {
		return tail == array.length - 1;
	}

	private void shiftLeft() {
		for (int i = 1; i < array.length; i++) {
			array[i - 1] = array[i];
		}
		
		tail--;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!this.isFull()) {
			array[++tail] = element;
		}
		
		else {
			throw new QueueOverflowException();
		}
			
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!this.isEmpty()) {
			T element = head();
			this.shiftLeft();
			return element;
		}
		
		else {
			throw new QueueUnderflowException();
		}
	}

}
