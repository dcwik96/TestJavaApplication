package MockExamples.MockExamples.zad1;


import MockExamples.MockExamples.FriendsCollection;
import MockExamples.MockExamples.FriendshipsMongo;
import MockExamples.MockExamples.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

// Ta linia jest wymagana
@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class FriendshipsMongoMockitoTest {

    //Co zastepujemy
    @Mock
    FriendsCollection friends;

    //Nasza atrapa
    @InjectMocks
    FriendshipsMongo friendships;

    @Test
    public void mockingWorskAsExpected() {
        Person joe = new Person("Joe");
        doReturn(joe).when(friends).findByName("Joe");
        assertThat(friends.findByName("Joe")).isEqualTo(joe);
    }

    @Test
    public void alexDoesNotHaveFriends() {
        assertThat(friendships.getFriendsList("Alex")).isEmpty();
    }

    @Test
    public void joeHas5Friends() {
        List<String> expected = Arrays.asList(new String[]{"Karol", "Dawid", "Maciej", "Tomek", "Adam"});
        //Spy przechwytuje wywołania z przekazywanymi pośrednio danymi w celu
        // późniejszego zbadania tych danych w teście - tutaj w przykładzie lista przyjaciół Joe
        Person joe = spy(new Person("Joe"));
        doReturn(joe).when(friends).findByName("Joe");
        doReturn(expected).when(joe).getFriends();
        assertThat(friendships.getFriendsList("Joe")).hasSize(5).containsOnly("Karol", "Dawid", "Maciej", "Tomek", "Adam");
    }

    @Test
    public void checkIfAreFriendsWorksForNULL() {
        assertThat(friendships.areFriends("Ktos", "inny")).isFalse();
    }

    @Test
    public void checkIfAreFriendsForExistingPersonReturnFalse() {
        Person joe = new Person("Joe");
        doReturn(joe).when(friends).findByName(joe.getName());
        assertThat(friendships.areFriends(joe.getName(), "inny")).isFalse();
    }

    @Test
    public void checkIfAreFriendsForExistingPersonReturnTrue() {
        Person joe = spy(new Person("Joe"));
        List<String> expected = Arrays.asList(new String[]{"Kumpel"});

        doReturn(joe).when(friends).findByName("Joe");
        doReturn(expected).when(joe).getFriends();


        assertThat(friendships.areFriends(joe.getName(), "Kumpel")).isTrue();
    }


}