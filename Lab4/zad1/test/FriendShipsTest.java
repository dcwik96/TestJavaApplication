
import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

//import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

public class FriendShipsTest {

    private Friendships fs;

    private static final String name1 = "Imie";
    private static final String name2 = "Imie2";

    @Test
    public void checkAdding() {
        fs = new Friendships();

        fs.makeFriends(name1, name2);

        assertThat(fs.friendships.isEmpty(), is(false));
        assertThat(fs.getFriendsList(name1), contains(name2));

    }

    @Test
    public void checkDuplicateAdding() {

        fs = new Friendships();

        fs.makeFriends(name1, name2);
        fs.makeFriends(name1, name2);
        fs.makeFriends(name2, name1);

        assertThat(fs.getFriendsList(name1), hasSize(1));
        assertThat(fs.getFriendsList(name2), hasSize(1));

    }

    @Test(expected = IllegalArgumentException.class)
    public void AddingSelfPersonAsFriend() {

        fs = new Friendships();

        fs.makeFriends(name1, name1);

        assertThat(fs.getFriendsList(name1), hasSize(1));
        assertThat(fs.getFriendsList(name2), hasSize(1));


    }
}
