package com143.ReorderList;


public class Solution {

	public static void main(String args[]){
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(2);
		ListNode n13 = new ListNode(3);
		ListNode n14 = new ListNode(4);
		ListNode n15 = new ListNode(5);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = null;
		reorderList(n15);
		while(n15!=null){
			System.out.println(n15.val);
			n15=n15.next;
		}
	}
	
	//�Ƚ���벿��ͷ�壬Ȼ��ǰ�벿���ٰ�λ�ò���
	public static void reorderList(ListNode head) {
        if(head==null) return;
        int len = 0 ; //������
        ListNode p = head ;
		while (p != null){ //���㳤��
			len++;
			p=  p.next;
		}
		
		int half = (len+1)/2;
		ListNode h = new ListNode(0); //�½�һ���ڵ㣬�Ժ�벿�ֽ���ͷ��
		p=head;
		
		while(half>0){
			p = p.next;
			half--;
		}
		
		ListNode pnext ;
		while(p!=null){ //��벿��ͷ��
			pnext = p.next;
			p.next = h.next;
			h.next = p;
			p = pnext;
		}
		
		ListNode pre = h;
		p = head;		
		half = (len+1)/2;
		while(half>0){ //ǰ�벿�ֲ��뵽ָ��λ��
			pnext = p.next;
			p.next = pre.next;
			pre.next = p;
			pre  = p.next ;
			p = pnext;
			half--;
		}		
		head = h.next;		
    }
}

