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
		return height(this.root);
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
		BSTNode<T> newNode = new BSTNode<T>();
		newNode.setData(element);
		newNode.setLeft(new BSTNode<T>());
		newNode.setRight(new BSTNode<T>());
		
		if (this.isEmpty()) {
			root = newNode;
			root.setLeft(new BSTNode<T>());
			root.setRight(new BSTNode<T>());
		} else {
			BSTNode<T> aux = root;
			insert(aux, newNode);
		}
	}

	private void insert(BSTNode<T> node, BSTNode<T> newNode) {
		if (node.isEmpty()) {
			node = newNode;
		} else {
			if (node.getData().compareTo(newNode.getData()) == 1)
				insert((BSTNode<T>) node.getLeft(), newNode);
			else
				insert((BSTNode<T>) node.getRight(), newNode);
		}
	}
	
	@Override
	public BSTNode<T> maximum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> minimum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
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
