import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 9/27/2020
 */
@LeetCode(id = 1600, name = "Throne Inheritance", url = "https://leetcode.com/problems/throne-inheritance/")
public class ThroneInheritance
{
	class Link
	{
		boolean isDead;
		String name;
		List<Link> child;

		Link(String name)
		{
			this.name = name;
			this.isDead = false;
			child = new ArrayList<>();
		}
	}

	Link root;
	Map<String, Link> map;

	public ThroneInheritance(String kingName)
	{
		root = new Link(kingName);
		map = new HashMap<>();
		map.put(root.name, root);
	}

	public void birth(String parentName, String childName)
	{
		Link child = new Link(childName);
		map.get(parentName).child.add(child);
		map.put(child.name, child);
	}

	public void death(String name)
	{
		map.get(name).isDead = true;
	}

	public List<String> getInheritanceOrder()
	{
		List<String> inheritanceOrder = new ArrayList<>();
		inorder(root, inheritanceOrder);
		return inheritanceOrder;
	}

	private void inorder(Link root, List<String> inheritanceOrder)
	{
		if (root == null)
		{
			return;
		}

		if (!root.isDead)
		{
			inheritanceOrder.add(root.name);
		}

		for (Link child : root.child)
		{
			inorder(child, inheritanceOrder);
		}
	}
}
