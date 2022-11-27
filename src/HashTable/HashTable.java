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

   // Method to search the word in LinkedList
    // key : key to search


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

    //Method to add key and value to hash table
    // key    : word to be added
     //value: frequency of word

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

    /**
     * this implements hash function to find index for a key
     */
    public int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numOfBuckets;
        ////System.out.println("Key: "+word+" hashcode: "+hashCode+" index: "+index);
        return index;

    }
    // Method to append value to Linked List
    // myNode : value to append
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
    
    public String toString() {
        return "MyHashMapNodes{" + head + '}';
    }
}
