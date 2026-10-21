public class SimpleHashtable {
    private Player[] hashtable;

    public SimpleHashtable() {
        hashtable = new Player[10];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void put(String key, Player player) {
        int hashedKey = hashKey(key);

        if (hashtable[hashedKey] != null) {
            System.out.println("Value already exists at bucket " + hashedKey);
            return;
        }

        hashtable[hashedKey] = player;
    }

    public Player get(String key) {
        int hashedKey = hashKey(key);
        return  hashtable[hashedKey];
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            System.out.println("Value at bucket " + i + " - " + hashtable[i]);
        }
    }
}