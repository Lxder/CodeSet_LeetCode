package com307.RangeSumQueryMutable;


//�����߶��� segment Tree
public class NumArray {
	String s = "a"+100;
	SegmentTreeNode root = null;

	public NumArray(int[] nums) {
		//�������Ϊ�߶���
		root = buildTree(nums, 0, nums.length - 1);
	}
	
	void update(int i, int val) {
		updateTree(root, i, val);
	}

	public int sumRange(int i, int j) {
		return sumRangeTree(root, i, j);
	}

	//--------------------------------------------------
	//�����߶���
	private SegmentTreeNode buildTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		} else {
			SegmentTreeNode ret = new SegmentTreeNode(start, end);
			if (start == end) { //���ֻ��һ������
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
	
	// �����߶����ڵ�
	void updateTree(SegmentTreeNode root, int pos, int val) {
		if (root.start == root.end) {  //���Ҷ�ӽڵ��pos = start = end
			root.sum = val;
		} else {
			int mid = root.start + (root.end - root.start) / 2;
			if (pos <= mid) {
				updateTree(root.left, pos, val);
			} else {
				updateTree(root.right, pos, val);
			}
			root.sum = root.left.sum + root.right.sum; //��Ҫ����·���ϵĺ�
		}
	}	

	//��ָ���߶������ҵ�start��end
	public int sumRangeTree(SegmentTreeNode root, int start, int end) {
		if (root.end == end && root.start == start) { //������ �յ�����Ҫ�������յ㣬root.sumΪ���
			return root.sum;
		} else {
			int mid = root.start + (root.end - root.start) / 2;
			if (end <= mid) { //�����Ҫ���յ�<=mid����Ҫ��͵Ĳ���һ����������
				return sumRangeTree(root.left, start, end);
			} else if (start >= mid + 1) { //�����Ҫ��������mid����Ҫ��͵Ĳ���һ����������
				return sumRangeTree(root.right, start, end);
			} else {
				//����,��͵Ĳ����������඼�У���Ҫ����һ��ֱ���
				return sumRangeTree(root.left, start, mid)
						+sumRangeTree(root.right, mid + 1, end);
			}
		}
	}
}

//�߶��������ݽṹ
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