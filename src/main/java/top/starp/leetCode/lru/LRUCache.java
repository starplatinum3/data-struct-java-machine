package top.starp.leetCode.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class  Node{
        int val;
        int key;
        Node next;
        Node prev;

    }

    Node head;
    Node tail;
    public LRUCache(int cap) {
//        Node head=new Node();
//        Node tail=new Node();
         head=new Node();
         tail=new Node();
        head.next=tail;
        tail.prev=head;
        this.cap=cap;

    }

    Map<Integer,Node> cache =new HashMap<>();

    int get(int val){
//        Integer integer = map.get(val);
        Node node = cache.get(val);
        if(node==null){
            return -1;
//            return  node.val;
        }
        moveToHead(node);
        return  node.val;

    }

    void moveToHead(Node node){
//        node.next=head.next;
//        head.next=node;
//
        rmNode(node);
      addToHead(node);
//        rmNode(node);
    }

    void addToHead(Node node){
//        Node trueHead=node.next;
        Node trueHeadOld=head.next;

        node.next=head.next;
        node.prev=head;
//        trueHead.next=head.next;
        trueHeadOld.prev=node;
//        trueHead.prev=node;
//        head.next=node;
//        trueHead=node;
        head.next=node;

    }

    void rmNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
//        1 2 3 4
//        node .prev.
    }

    Node rmTail(){


        Node newDummyTail=tail.prev;
//        rmNode(tail.prev);
        rmNode(newDummyTail);
        return newDummyTail;
    }

    int cap;
    int size=0;

    void put(int key,int val){

        Node node = cache.get(key);
        if(node==null){
//            新的
            Node newNode = new Node();
            newNode.val=val;
            newNode.key=key;
//            moveToHead(newNode);
            addToHead(newNode);
            size++;
            if(size>cap){
//                好的
                Node nodeTail = rmTail();
                cache.remove(nodeTail.key);
size--;
            }
            return;

        }
//        addToHead(newno);
        node.val=val;
        moveToHead(node);
    }
}
