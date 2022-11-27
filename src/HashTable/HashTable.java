package HashTable;

import java.util.ArrayList;

public class HashTable<K, V> {
	MapNode head;
    MapNode tail;
    private final int numOfBuckets;
    ArrayList<MapNode<K, V>> myBucketArray;

    public HashTable() {
        this.numOfBuckets = 10;
        this.myBucketArray = new ArrayList<>(numOfBuckets);
        for (int i = 0; i < numOfBuckets; i++)
            this.myBucketArray.add(null);
    }

    public V get(K key) {
        int index = this.getBucketIndex(key);
        if (this.myBucketArray.get(index) == null)
            return null;
        MapNode<K, V> myNode = search(key);
        return (myNode == null) ? null : myNode.getValue();
    }

    public MapNode<K, V> search(K key) {
        MapNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        MapNode<K, V> myNode = this.myBucketArray.get(index);
        if (myNode == null) {
            myNode = new MapNode<>(key, value);
            this.myBucketArray.set(index, myNode);
        }
        myNode = search(key);
        if (myNode == null) {
            myNode = new MapNode<>(key, value);
            this.append(myNode);
        } else
            myNode.setValue(value);
    }

    public int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numOfBuckets;
        return index;

    }
    private void append(MapNode<K, V> myNode) {
        if (this.head == null)
            this.head = myNode;
        if (this.tail == null)
            this.tail = myNode;
        else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }
    public void remove(K key) {
        MapNode currentNode = head;
        MapNode<K, V> previousNode = null;
        while (currentNode != null && currentNode.getKey().equals(key)) {
            head = currentNode.getNext();
        }
        while (currentNode != null && !(currentNode.getKey().equals(key))) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (currentNode != null)
            previousNode.next = currentNode.next;
        if (currentNode == null)
            System.out.println("Word not found");
    }
    
    public String toString() {
        return "MyHashMapNodes{" + head + '}';
    }
}
