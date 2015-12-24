package com025.ReverseNodesink_Group;

public class Solution {

	public static void main(String[] args) {
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(2);
		ListNode n13 = new ListNode(3);
		ListNode n14 = new ListNode(4);
		ListNode n15 = new ListNode(5);
		ListNode n16 = new ListNode(6);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = n16;
		n16.next = null;

		ListNode solu = reverseKGroup(n11,3);
		while (solu != null) {
			System.out.println(solu.val);
			solu = solu.next;
		}

	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode pre =head;
		ListNode q = head;
		
		ListNode result = new ListNode(0); //存放结果

		result.next = head;
		ListNode reshead= result; //指向结果的头部
		
		
		int temp = 0; //存放节点总数		
		while(q!=null){ //计算节点总数
            ++temp;
            q=q.next;
        }
		
		q = head;  //q存放要翻转的节点，pre指示q前面的节点		
		int t; //每组翻转的次数
		while(k<=temp){
			t = k;
			ListNode remark = q;

			while(t>0){
				System.out.println(result.next.val);
				pre = q ;
				q = q.next;
				pre.next = result.next; //带头结点的头插法
				result.next = pre;
				t--;
			}
			
			remark.next = q;	//将每一部分连接起来(若数量不够，则直接连接；否则q=null，代表结尾)
			result = remark;	//改变result，指向部分逆置的最后一个节点（就是下一次头插法的头节点）
			temp -=k;
		}
		return reshead.next;
	}

}
