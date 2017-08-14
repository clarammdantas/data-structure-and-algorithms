package adt.bst;

import java.lang.Math;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(root);
	}
	
	private int height(BSTNode<T> node) {
		if (node.isEmpty())
			return -1;
		
		return Math.max(this.height((BSTNode<T>) node.getLeft()), this.height((BSTNode<T>) node.getRight())) + 1;
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> aux = this.root;
		
		return search(aux, element);
	}
	
	private BSTNode<T> search(BSTNode<T> node, T element) {
		if (!node.isEmpty()) {
			if (node.getData().equals(element))
				return node;
			
			else if (node.getData().compareTo(element) == 1 && !node.getLeft().isEmpty())
				return search((BSTNode<T>) node.getLeft(), element);
			
			else if (node.getData().compareTo(element) == -1 && !node.getRight().isEmpty())
				return search((BSTNode<T>) node.getRight(), element);
				
		}
		
		return new BSTNode<T>();
	}

	@Override
	public void insert(T element) {
		if (element != null)
			insert(this.root, element);
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
		} else {
			if (node.getData().compareTo(element) == 1)
				insert((BSTNode<T>) node.getLeft(), element);
			else
				insert((BSTNode<T>) node.getRight(), element);
		}
	}
	
	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> aux = this.root;
		if (!isEmpty())
			return maximum(aux);
		
		else
			return null;
	}
	
	private BSTNode<T> maximum(BSTNode<T> node) {
		if (node.isLeaf() || node.getRight().isEmpty())
			return node;
		
		return maximum((BSTNode<T>) node.getRight());
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> aux = this.root;
		
		if (!isEmpty())
			return minimum(aux);
		
		else
			return null;
	}
	
	private BSTNode<T> minimum(BSTNode<T> node) {
		if (node.isLeaf() || node.getLeft().isEmpty())
			return node;
		
		return minimum((BSTNode<T>) node.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) { //first greater
		BSTNode<T> node = search(element);
		
		if (node.isEmpty())
			return null;
		
		//has right subtree
		else if (!node.getRight().isEmpty())
			return minimum((BSTNode<T>) node.getRight());
		
		//doesn't have right subtree
		else {
			BSTNode<T> aux = node;
			BSTNode<T> auxParent = (BSTNode<T>) node.getParent();
			
			while (!auxParent.isEmpty() && aux.equals(auxParent.getRight())) {
				aux = auxParent;
				auxParent = (BSTNode<T>) auxParent.getParent();
			}
			
			return aux;
		}
			
	}
	
	

	@Override
	public BSTNode<T> predecessor(T element) { //first least
		BSTNode<T> node = search(element);
		
		if (node.isEmpty())
			return null;
		
		//has a left subtree
		else if (!node.getLeft().isEmpty())
			return minimum((BSTNode<T>) node.getLeft());
		
		
		//doesn't have a left subtree
		else {
			BSTNode<T> aux = node;
			BSTNode<T> auxParent = (BSTNode<T>) node.getParent();
			
			while (!auxParent.isEmpty() && aux.equals(auxParent.getLeft())) {
				aux = auxParent;
				auxParent = (BSTNode<T>) auxParent.getParent();
			}
			
			return auxParent;
		}
	}

	@Override
	public void remove(T element) { //base case is to remove a leaf
		BSTNode<T> node = search(element);
		
		if (!node.isEmpty() && node != null) {
			if (!node.getLeft().isEmpty() && !node.getRight().isEmpty())
				removeHasTwoChildren(node);
			
			else if (node.isLeaf())
				removeIsLeaf(node);
			
			else
				removeHasOneChild(node);
		}
	}
	
	private void removeIsLeaf(BSTNode<T> node) {
		node.setData(null);
	}
	
	private void removeHasOneChild(BSTNode<T> node) {
		BSTNode<T> aux;
		
		if (hasOnlyLeftSon(node)) {
			aux = (BSTNode<T>) node.getLeft();
		} else {
			aux = (BSTNode<T>) node.getRight();
		}
		
		if (node.getParent() == null) {
			aux.setParent(null);
			this.root = aux;
		}
		
		else {
			if (isLeftSon(node)) {
				node.getParent().setLeft(aux);
			} else {
				node.getParent().setRight(aux);
			}
			
			aux.setParent(node.getParent());
		}
	}
	
	private void removeHasTwoChildren(BSTNode<T> node) {
		BSTNode<T> minRight = minimum((BSTNode<T>) node.getRight());
		
		T aux = node.getData();
		
		node.setData(minRight.getData());
		minRight.setData(aux);
		
		remove(aux);
	}
	
	private boolean isLeftSon(BSTNode<T> node) {
		return !node.getParent().isEmpty() && !node.getParent().getLeft().isEmpty()
				&& node.getParent().getLeft().equals(node);
	}
	
	private boolean hasOnlyLeftSon(BSTNode<T> node) {
		return (node.getRight().isEmpty() && !node.getLeft().isEmpty());
	}

	@Override
	public T[] preOrder() { //root, left, right
		T[] array = (T[]) new Comparable[size()];
		preOrder(array, 0, this.root);
		
		return array;
	}
	
	private int preOrder(T[] array, int index, BSTNode<T> node) {
		if (!node.isEmpty()) {
			array[index++] = node.getData();
			
			index = preOrder(array, index, (BSTNode<T>) node.getLeft());
			index = preOrder(array, index, (BSTNode<T>) node.getRight());
		}
		
		return index;
	}

	@Override
	public T[] order() { //left, root, right
		T[] array = (T[]) new Comparable[size()];
		order(array, 0, this.root);
		
		return array;
	}
	
	private int order(T[] array, int index, BSTNode<T> node) {
		if (!node.isEmpty()) {
			index = order(array, index, (BSTNode<T>) node.getLeft());
			
			array[index++] = node.getData();
			
			index = order(array, index, (BSTNode<T>) node.getRight());
		}
		
		return index;
	}

	@Override
	public T[] postOrder() { //left, right, root
		T[] array = (T[]) new Comparable[size()];
		postOrder(array, 0, this.root);
		
		return array;
	}
	
	private int postOrder(T[] array, int index, BSTNode<T> node) {
		if (!node.isEmpty()) {
			index = postOrder(array, index, (BSTNode<T>) node.getLeft());
			index = postOrder(array, index, (BSTNode<T>) node.getRight());
			
			array[index++] = node.getData();
		}
		
		return index;
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
