package Solution;
/**
 *复杂链表的复制
 *题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，
 * 并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，
 * 否则判题程序会直接返回空）
 */
public class Solution25 {

    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
            return null;
        RandomListNode currentNode=pHead;
        while(currentNode!=null)
        {
            RandomListNode cloneNode=new RandomListNode(currentNode.lable);
            RandomListNode nextNode=currentNode.next;
            currentNode.next=cloneNode;
            cloneNode.next=nextNode;
            currentNode=nextNode;
        }
        currentNode=pHead;
        while(currentNode!=null)
        {
            currentNode.next.random=currentNode.random==null?null:currentNode.random.next;
            currentNode=currentNode.next.next;
        }
        currentNode=pHead;
        RandomListNode p=pHead.next;
        while(currentNode!=null)
        {
            RandomListNode clone=currentNode.next;
            currentNode.next=clone.next;
            clone.next=clone.next==null?null:clone.next.next;
            currentNode=currentNode.next;

        }

        return p;

    }







}
