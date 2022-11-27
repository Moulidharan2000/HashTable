package HashTable;

public class HashTable<K, V> {
	MapNode head;
    MapNode tail;

    public V get(K word) {
        MapNode<K, V> myNode = searchNode(word);
        return (myNode == null) ? null : myNode.getValue();
    }

    public MapNode<K, V> searchNode(K word) {
        MapNode<K, V> currentNode = head;
        int position = 0;
        while (currentNode != null) {
            position++;
            if (currentNode.getKey().equals(word)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public void add(K key, V value) {
        MapNode<K, V> myNode = searchNode(key);
        if (myNode == null) {
            myNode = new MapNode<>(key, value);
            this.append(myNode);
        } else
            myNode.setValue(value);

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

    public String toString() {
        return "MyLinkedListNodes{" + head + '}';
    }

    public void printNodes() {
        System.out.println("My nodes: " + head);
    }
}
