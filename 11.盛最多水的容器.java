/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 *
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (53.49%)
 * Total Accepted:    33.5K
 * Total Submissions: 61.9K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为
 * (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 
 * 
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 
 */
class Solution {
    /**
     * 双指针的方法，每次只移动最小的指针，直到指针相遇， 因为影响容器大小的因素除了长度，就剩高度了，最短的会是最终的取值高度
     */
    public int maxArea(int[] height) {
        return func1(height);
    }

    private int extracted(int[] height) {
        int f = 0;
        int e = height.length - 1;
        int max = 0;
        while (f < e) {
            int mj = Math.min(height[f], height[e]) * (e - f);
            max = Math.max(max, mj);// 记录最大值
            if (height[f] < height[e]) {
                f++;
            } else {
                e--;
            }
        }
        return max;
    }

    private int func1(int[] height) {
        int f = 0;
        int e = height.length - 1;
        int max = 0;
        while (f < e) {
            max = Math.max(max,Math.min(height[f],height[e])*(e-f));
            if(height[f] < height[e]){
                f++;
            }else{
                e--;
            }
        }
        return max;
    }
}
