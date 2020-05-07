import common.LeetCode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 07-May-20
 */
@LeetCode(id = 1146, name = "Snapshot Array", url = "https://leetcode.com/problems/snapshot-array/")
class SnapshotArray
{
	private Map<Integer, Map<Integer, Integer>> snapshots;
	private int currentSnapShotId;
	private Map<Integer, Integer> currentState;

	public SnapshotArray(int length)
	{
		snapshots = new HashMap<>();
		currentState = new HashMap<>();
	}

	public void set(int index, int val)
	{
		currentState.put(index, val);
	}

	public int snap()
	{
		snapshots.put(currentSnapShotId, currentState);
		currentState = new HashMap<>(currentState);
		return currentSnapShotId++;
	}

	public int get(int index, int snap_id)
	{
		Integer value = snapshots.getOrDefault(snap_id, Collections.emptyMap()).get(index);
		return value == null ? 0 : value;
	}
}
