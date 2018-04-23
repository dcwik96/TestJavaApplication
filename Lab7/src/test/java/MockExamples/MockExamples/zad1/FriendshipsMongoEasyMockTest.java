package MockExamples.MockExamples.zad1;

import MockExamples.MockExamples.FriendsCollection;
import MockExamples.MockExamples.FriendshipsMongo;
import MockExamples.MockExamples.Person;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

@RunWith(EasyMockRunner.class)
public class FriendshipsMongoEasyMockTest {

    @TestSubject
    FriendshipsMongo friendships = new FriendshipsMongo();

    //A nice mock expects recorded calls in any order and returning null for other calls
    @Mock(type = MockType.NICE)
    FriendsCollection friends;

    @Test
    public void mockingWorksAsExpected() {
        Person joe = new Person("Joe");
        //Zapisanie zachowania - co sie ma stac
        expect(friends.findByName("Joe")).andReturn(joe);
        //Odpalenie obiektu do sprawdzenia zachowania
        replay(friends);
        assertThat(friends.findByName("Joe")).isEqualTo(joe);
    }

    @Test
    public void alexDoesNotHaveFriends() {
        assertThat(friendships.getFriendsList("Alex")).isEmpty();
    }

    @Test
    public void joeHas5Friends() {
        List<String> expected = Arrays.asList("Karol", "Dawid", "Maciej", "Tomek", "Adam");
        Person joe = createMock(Person.class);
        expect(friends.findByName("Joe")).andReturn(joe);
        expect(joe.getFriends()).andReturn(expected);
        replay(friends);
        replay(joe);
        assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Karol", "Dawid", "Maciej", "Tomek", "Adam");
    }

    @Test
    public void checkIfAreFriendsForExistingPersonReturnFalse() {
        Person joe = new Person("Joe");
        expect(friends.findByName("Joe")).andReturn(joe);
        assertThat(friendships.areFriends(joe.getName(), "inny")).isFalse();
    }

    @Test
    public void checkIfAreFriendsForExistingPersonReturnTrue() {
        Person joe = createMock(Person.class);
        List<String> expected = Arrays.asList("Kumpel");

        expect(friends.findByName("Joe")).andReturn(joe);
        expect(joe.getFriends()).andReturn(expected);

        replay(friends);
        replay(joe);

        assertThat(friendships.areFriends("Joe", "Kumpel")).isTrue();
    }

}
