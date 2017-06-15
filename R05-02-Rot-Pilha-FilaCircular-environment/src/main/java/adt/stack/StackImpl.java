package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private static final int EMPTY = -1;
	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = EMPTY;
	}

	@Override
	public T top() {
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		return top == EMPTY;
	}

	@Override
	public boolean isFull() {
		return top == array.length - 1;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (!this.isFull()) {
			array[++top] = element;
		}
		
		else {
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (!this.isEmpty()) {
			T element = this.top();
			top--;
			return element;
		}
		
		else {
			throw new StackUnderflowException();
		}
	}

}
