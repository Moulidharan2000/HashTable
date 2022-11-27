package HashTable;

public class MapNode<K, V> {
	K key;
    V value;
    MapNode<K, V> next;

    // constructor name as MyMaoNode and passing key and value
    public MapNode(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
    }

   // method getter and setter
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;

    }
    //  getvalue method and setvalue
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }

    public MapNode<K, V> getNext() {
        return next;
    }

    public void setNext(MapNode<K, V> next) {
        this.next = (MapNode<K, V>) next;
    }

    @Override
    public String toString() {
        StringBuilder nodeString = new StringBuilder();
        nodeString.append("MyMapNode{" + " Key= ").append(key).append(" Value= ").append(value).append('}');
        if (next != null)
            nodeString.append("->").append(next);
        return nodeString.toString();

    }
}
