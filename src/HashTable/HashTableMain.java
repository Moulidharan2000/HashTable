package HashTable;

public class HashTableMain {

	public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable();
        String sentence = "Paranoids are not paranoid because they are paranoid but	because they keep putting themselves deliberately into paranoid avoidable situations";
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
        hashTable.remove("avoidable");
        System.out.println(hashTable);
	}
}
