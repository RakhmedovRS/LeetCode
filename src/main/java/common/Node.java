package common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 10-Jul-20
 */
public class Node
{
	public int val;
	public List<Node> neighbors;
	public Node prev;
	public Node next;
	public Node child;

	public Node()
	{
		this.val = 0;
		this.neighbors = new ArrayList<>();
	}

	public Node(int val)
	{
		this.val = val;
		this.neighbors = new ArrayList<>();
	}

	public Node(int val, ArrayList<Node> neighbors)
	{
		this.val = val;
		this.neighbors = neighbors;
	}
}
