public class SimpleHashtable {
    private SavedPlayer[] hashtable;
    private final SavedPlayer DELETED = new SavedPlayer("DELETED", null);

    public SimpleHashtable(){
        hashtable = new SavedPlayer[10];
    }

    public int hashKey(String key){
        return key.length() % hashtable.length;
    }

    public boolean isOccupied(int hashedKey){
        return hashtable[hashedKey] != null && hashtable[hashedKey] != DELETED;
    }

    public void put(String key, Player player){
        int hashedKey = hashKey(key);

        // linear probing - find next available space by iterating through array hashtable
        if (isOccupied(hashedKey)){
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1){
                hashedKey = 0;
            }

            else{
                hashedKey++;
            }

            while (hashedKey != stoppingIndex && isOccupied(hashedKey)){
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey)){
            System.out.println("Value already exists at bucket " + hashedKey);
            return;
        }

        hashtable[hashedKey] = new SavedPlayer(player.getUserName(), player);
    }

    public boolean isNullNotDeleted(int hashedKey){
        return hashtable[hashedKey] != null;
    }

    public int findKey(String key) {
        int hashedKey = hashKey(key);

        if (isNullNotDeleted(hashedKey) && hashtable[hashedKey].getKey().equals(key))
            return hashedKey;

        int stoppingIndex = hashedKey;

        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        }
        else {
            hashedKey++;
        }

        while (hashedKey != stoppingIndex &&
                isNullNotDeleted(hashedKey) &&
                !hashtable[hashedKey].getKey().equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (isNullNotDeleted(hashedKey) && hashtable[hashedKey].getKey().equals(key))
            return  hashedKey;

        return -1;
    }
    
    public Player remove(String key){
        int hashedKey = findKey(key);
        Player removedPlayer = null;

        if (hashedKey != -1) {
            removedPlayer = hashtable[hashedKey].getPlayer();
            hashtable[hashedKey] = DELETED;
            return removedPlayer;
        }
        return null;
    }

    public Player get(String key){
        int hashedKey = findKey(key);

        if (hashedKey == -1){
            return null;
        }

        return hashtable[hashedKey].getPlayer();
    }

    public void printHashtable(){
        for (int i = 0; i < hashtable.length; i++){
            Player player = null;
            if (isOccupied(i)){
                player = hashtable[i].getPlayer();
            }
            if (hashtable[i] == DELETED){
                System.out.println("Value at bucket " + i + " - " + "DELETED PLAYER");
            }
            else{
                System.out.println("Value at bucket " + i + " - " + player);
            }
        }
    }
}
