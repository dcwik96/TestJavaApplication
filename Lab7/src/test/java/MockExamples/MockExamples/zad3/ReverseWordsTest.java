package MockExamples.MockExamples.zad3;

import MockExamples.MockExamples.ReverseLetters;
import MockExamples.MockExamples.ReverseWords;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class ReverseWordsTest {

    @Mock
    ReverseWords reverseWords;

    @Mock
    ReverseLetters reverseLetters;

    @Test
    public void checkIfReverseLetters() {

    }
}
