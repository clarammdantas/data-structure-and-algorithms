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
			return aux;
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
			return aux;
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
			
			while (!auxParent.isEmpty() || auxParent.getData() != null) {
				aux = auxParent;
				auxParent = (BSTNode<T>) auxParent.getParent();
			}
			
			return aux;
		}
			
	}
	
	

	@Override
	public BSTNode<T> predecessor(T element) { //first least
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) { //base case is to remove a leaf
		//TODO
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
