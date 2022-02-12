import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree = Tree.readInGraph();
		tree.cutUnneededRest();
		int paths = tree.getNoOfPaths();
		int diameter = tree.getDiameter();
		System.out.println(paths*2-diameter);
	}
}

class Tree {
	Node[] nodes = null;

	public static Tree readInGraph() {
		// TODO Auto-generated method stub
		
	}

	public int getDiameter() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNoOfPaths() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void cutUnneededRest() {
		// TODO Auto-generated method stub
		Node root = getFirstNonPhoRest();
		
		Set<Node> children = getChildren(null, root);
		for (Node child:children) {
			child.cutUnneededSubTree(root);
		}
		
	}
}

class Node {
	int id;
	Set<Node> neighbours = new HashSet<>();
	boolean isPhoRest = false;
	
	public Node(int id, boolean isPhoRest) {
		this.id = id;
		this.isPhoRest = isPhoRest;
	}

	public void cutUnneededSubTree(Node parent) {
		// TODO Auto-generated method stub
		
		Set<Node> children = getChildren(parent,this);
		for (Node child:children) {
			child.cutUnneededSubTree(this);
		}
		
		if (!this.isPhoRest && this.neighbours.size()==1) {
			parent.neighbours.remove(this);
			return;
		}
	}
}
