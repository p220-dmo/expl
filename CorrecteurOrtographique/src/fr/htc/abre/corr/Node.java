package fr.htc.abre.corr;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private Node parent;
	private List<Node> childs = new ArrayList<Node>(26);
	private boolean word;
	private Character car;
	
	
	
	public Node(Node parent, Character car) {
		this.parent = parent;
		this.car = car;
	}
	
	public Character getCar() {
		return car;
	}

	public void setCar(Character car) {
		this.car = car;
	}

	public Node next (int car) {
		
		return null;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public boolean hasChild(char car) {
		
		try {
			if(this.childs.get(AlphabetOrder.getOrder(car)) != null) {
				return true;
			}
		}catch (Exception e) {
			System.out.println("No index found !!!");
		}
		return false;
	}


	public Node process(char car) {
		if(this.hasChild(car)) {
			return this.childs.get(AlphabetOrder.getOrder(car));
		}
		return this.addChild(car);
	}

	
	@Override
	public String toString() {
		return this.parent.getCar() +  " ==> " + car;
	}

	private Node addChild(char car) {
		Node node = new Node(this, car);
		this.childs.add(AlphabetOrder.getOrder(car),  node);
		return node;
	}

	public void print() {
		for (Node node : childs) {
			System.out.print("\t" + this.car);
			node.print();
		}
	}

	public void setWord(boolean isWord) {
		this.word = isWord;
	}

	public boolean isWord() {
		return word;
	}

	public Node avancer(char car) {
		int index = AlphabetOrder.getOrder(car);
		Node node = null;
		try {
			node = childs.get(index);
		} catch (Exception e) {
		}
		return node;
	}

}
