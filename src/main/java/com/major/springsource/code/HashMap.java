package com.major.springsource.code;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;

public class HashMap<K,V> {
    static class Node<K,V> {
        final int hash;
        final K key;
        final K value;
        final Node<K,V> next;

        public Node(int hash, K key, K value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
