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
		
		ListNode result = new ListNode(0); //��Ž��

		result.next = head;
		ListNode reshead= result; //ָ������ͷ��
		
		
		int temp = 0; //��Žڵ�����		
		while(q!=null){ //����ڵ�����
            ++temp;
            q=q.next;
        }
		
		q = head;  //q���Ҫ��ת�Ľڵ㣬preָʾqǰ��Ľڵ�		
		int t; //ÿ�鷭ת�Ĵ���
		while(k<=temp){
			t = k;
			ListNode remark = q;

			while(t>0){
				System.out.println(result.next.val);
				pre = q ;
				q = q.next;
				pre.next = result.next; //��ͷ����ͷ�巨
				result.next = pre;
				t--;
			}
			
			remark.next = q;	//��ÿһ������������(��������������ֱ�����ӣ�����q=null�������β)
			result = remark;	//�ı�result��ָ�򲿷����õ����һ���ڵ㣨������һ��ͷ�巨��ͷ�ڵ㣩
			temp -=k;
		}
		return reshead.next;
	}

}
