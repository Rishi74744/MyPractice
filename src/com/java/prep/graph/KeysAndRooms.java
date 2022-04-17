package com.java.prep.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except
 * for room 0. Your goal is to visit all the rooms. However, you cannot enter a
 * locked room without having its key.
 * 
 * When you visit a room, you may find a set of distinct keys in it. Each key
 * has a number on it, denoting which room it unlocks, and you can take all of
 * them with you to unlock the other rooms.
 * 
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if
 * you visited room i, return true if you can visit all the rooms, or false
 * otherwise.
 * 
 * Example 1:
 * 
 * Input: rooms = [[1],[2],[3],[]] Output: true
 * 
 * Explanation: We visit room 0 and pick up key 1.
 * 
 * We then visit room 1 and pick up key 2.
 * 
 * We then visit room 2 and pick up key 3.
 * 
 * We then visit room 3.
 * 
 * Since we were able to visit every room, we return true.
 * 
 * Example 2:
 * 
 * Input: rooms = [[1,3],[3,0,1],[2],[0]] Output: false
 * 
 * Explanation: We can not enter room number 2 since the only key that unlocks
 * it is in that room.
 * 
 * Constraints:
 * 
 * n == rooms.length
 * 
 * 2 <= n <= 1000
 * 
 * 0 <= rooms[i].length <= 1000
 * 
 * 1 <= sum(rooms[i].length) <= 3000
 * 
 * 0 <= rooms[i][j] < n
 * 
 * All the values of rooms[i] are unique.
 */
public class KeysAndRooms {

	/**
	 * Complexity - (m*n), Space - O(n)
	 */
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		if (rooms.size() == 0 || rooms.size() == 1) {
			return true;
		}
		Queue<Integer> q = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		q.offer(0);
		while (!q.isEmpty()) {
			int currentRoom = q.poll();
			visited.add(currentRoom);
			List<Integer> keys = rooms.get(currentRoom);
			for (int i = 0; i < keys.size(); i++) {
				if (!visited.contains(keys.get(i))) {
					q.offer(keys.get(i));
				}
			}
		}
		return visited.size() == rooms.size();
	}

	public static void main(String[] args) {
		KeysAndRooms k = new KeysAndRooms();
		k.canVisitAllRooms(new ArrayList<>());
	}

}
