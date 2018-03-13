import java.util.*;

public class Friendships {
    Map<String, List<String>> friendships = new HashMap();

    //Dodanie przyjaciół - wykorzystuje funkcje addFriend!	
    public void makeFriends(String person1, String person2) {
        if (this.areFriends(person1, person2))
            return;
        addFriend(person1, person2);
	addFriend(person2, person1);
    }
    
    //Pobranie listy przyjaciol
    public List<String> getFriendsList(String person) {
        return friendships.get(person);
    }
    
    //Sprawdzenie czy przyjaciele
    public boolean areFriends(String person1, String person2) {
        if (person1.equals(person2))
            throw new IllegalArgumentException("The same names");
        if(friendships.containsKey(person1))
            if(friendships.get(person1).contains(person2))
            return true;
        return false;
    }
    //Dodanie do listy przyjaciol danej osoby
    private void addFriend(String person, String friend) {
        if(!friendships.containsKey(person))
            friendships.put(person, new ArrayList<String>());

        friendships.get(person).add(friend);
    }
}
