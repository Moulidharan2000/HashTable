package HashTable;

public class HashTableMain {

	public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable();
        String sentence = "A Hashtable is an array of a list. Each list is known as a bucket. The position of the bucket is identified by calling the hashcode() method.";
        String[] sentenceArray = sentence.toLowerCase().split(" ");
        for (String word : sentenceArray) {
            Integer value = hashTable.get(word);

            if( value == null)
                value = 1;
            else
                value = value + 1;
            hashTable.add(word , value);
        }
        System.out.println(hashTable);
	}
}
