package graphs;
import java.util.*;

public class TreeNode <T> {
	private TreeNode<T> parent;
	private List<TreeNode<T>> children;
	private  T data;
	
	
	
	public TreeNode(TreeNode<T> parent, List<TreeNode<T>> nodes, T data) {
		
		this.parent = parent;
		this.children = nodes;
		this.data = data;
	}
	
	public void addChild(TreeNode<T> child) {
		child.setParent(this);
		this.children.add(child);
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public TreeNode<T> getParent() {
		return parent;
	}
	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}
	public List<TreeNode<T>> getNodes() {
		return children;
	}
	public void setNodes(List<TreeNode<T>> nodes) {
		this.children = nodes;
	}
	
	
	
	
	
}
