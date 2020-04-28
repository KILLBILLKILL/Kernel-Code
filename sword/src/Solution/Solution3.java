package Solution;

import java.util.ArrayList;

/**
 *从尾到头打印链表
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */

public class Solution3 {
    ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            if(listNode!=null)
            {
                printListFromTailToHead(listNode.next);
                list.add(listNode.val);
            }
            return list;
    }

}
