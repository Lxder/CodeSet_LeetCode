package com307.RangeSumQueryMutable;


//利用线段树 segment Tree
public class NumArray {
	String s = "a"+100;
	SegmentTreeNode root = null;

	public NumArray(int[] nums) {
		//将数组存为线段树
		root = buildTree(nums, 0, nums.length - 1);
	}
	
	void update(int i, int val) {
		updateTree(root, i, val);
	}

	public int sumRange(int i, int j) {
		return sumRangeTree(root, i, j);
	}

	//--------------------------------------------------
	//构建线段树
	private SegmentTreeNode buildTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		} else {
			SegmentTreeNode ret = new SegmentTreeNode(start, end);
			if (start == end) { //如果只有一个数字
				ret.sum = nums[start];
			} else {
				int mid = start + (end - start) / 2;
				ret.left = buildTree(nums, start, mid);
				ret.right = buildTree(nums, mid + 1, end);
				ret.sum = ret.left.sum + ret.right.sum;
			}
			return ret;
		}
	}
	
	// 更新线段树节点
	void updateTree(SegmentTreeNode root, int pos, int val) {
		if (root.start == root.end) {  //这个叶子节点的pos = start = end
			root.sum = val;
		} else {
			int mid = root.start + (root.end - root.start) / 2;
			if (pos <= mid) {
				updateTree(root.left, pos, val);
			} else {
				updateTree(root.right, pos, val);
			}
			root.sum = root.left.sum + root.right.sum; //需要更新路径上的和
		}
	}	

	//在指定线段树上找到start到end
	public int sumRangeTree(SegmentTreeNode root, int start, int end) {
		if (root.end == end && root.start == start) { //如果起点 终点是需要的起点和终点，root.sum为结果
			return root.sum;
		} else {
			int mid = root.start + (root.end - root.start) / 2;
			if (end <= mid) { //如果需要的终点<=mid，则要求和的部分一定在左子树
				return sumRangeTree(root.left, start, end);
			} else if (start >= mid + 1) { //如果需要的起点大于mid，则要求和的部分一定在右子树
				return sumRangeTree(root.right, start, end);
			} else {
				//否则,求和的部分左右两侧都有，需要进下一层分别求
				return sumRangeTree(root.left, start, mid)
						+sumRangeTree(root.right, mid + 1, end);
			}
		}
	}
}

//线段树的数据结构
class SegmentTreeNode {
	int start, end;
	SegmentTreeNode left, right;
	int sum;

	public SegmentTreeNode(int start, int end) {
		this.start = start;
		this.end = end;
		this.left = null;
		this.right = null;
		this.sum = 0;
	}
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);