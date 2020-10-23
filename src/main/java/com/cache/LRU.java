package com.cache;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> map_node;
    int capacity;

    public LRU(int capacity) {
        this.map_node = new HashMap(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int val){
        Node node = map_node.get(key);
        if(node!= null){
            remove(node);
            node.value = val;
            add(node);
        } else {
            if(map_node.size() == capacity){
                map_node.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node new_node = new Node();
            new_node.key = key;
            new_node.value = val;

            map_node.put(key, new_node);
            add(new_node);
        }
    }

    public int get(int key){
        int result = -1;
        Node node = map_node.get(key);
        if(node != null){
            remove(node);
            add(node);
            return node.value;
        }
        return result;
    }
    public void add(Node node) {
        Node next_node = head.next;
        head.next = node;
        node.prev = head;
        node.next = next_node;
        next_node.prev = node;
    }

    public void remove(Node node) {
        Node next_node = node.next;
        Node prev_node = node.prev;
        prev_node.next = next_node;
        next_node.prev = prev_node;
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
}
