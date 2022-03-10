package com.java.prep.arrays;

/**
 * You have a long flowerbed in which some of the plots are planted, and some
 * are not. However, flowers cannot be planted in adjacent plots.
 * 
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty
 * and 1 means not empty, and an integer n, return if n new flowers can be
 * planted in the flowerbed without violating the no-adjacent-flowers rule.
 * 
 * Example 1:
 * 
 * Input: flowerbed = [1,0,0,0,1], n = 1 Output: true
 * 
 * Example 2:
 * 
 * Input: flowerbed = [1,0,0,0,1], n = 2 Output: false
 * 
 * Constraints:
 * 
 * 1 <= flowerbed.length <= 2 * 10^4
 * 
 * flowerbed[i] is 0 or 1.
 * 
 * There are no two adjacent flowers in flowerbed.
 * 
 * 0 <= n <= flowerbed.length
 * 
 *
 */
public class CanPlaceFlowers {

	/**
	 * Complexity - O(n), Space - O(1)
	 */
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (flowerbed.length == 1 && flowerbed[0] == 0) {
			return n <= 1;
		}
		if (n == 0) {
			return true;
		}
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 1) {
				i++;
			} else {
				if (i == 0 && i + 1 < flowerbed.length && flowerbed[i + 1] == 0) {
					flowerbed[i] = 1;
					n--;
				} else if (i == flowerbed.length - 1 && i - 1 > 0 && flowerbed[i - 1] == 0) {
					flowerbed[i] = 1;
					n--;
				} else if (i - 1 > 0 && flowerbed[i - 1] == 0 && i + 1 < flowerbed.length && flowerbed[i + 1] == 0) {
					flowerbed[i] = 1;
					n--;
				}
			}
			if (n == 0) {
				break;
			}
		}
		return n == 0;
	}

	public static void main(String[] args) {
		CanPlaceFlowers c = new CanPlaceFlowers();
		int flowers[] = { 0, 0, 0, 0, 0, 1, 0, 0 };
		System.out.println(c.canPlaceFlowers(flowers, 1));
	}

}
