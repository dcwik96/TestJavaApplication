package MockExamples.MockExamples;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;


public class ReverseWords implements ReverseLetters {
    public static ReverseWords with(final ReverseLetters reversePhrase) {

        return new ReverseWords(reversePhrase);
    }

    public String apply(final String sentence) {
        final Iterable<String> words = Splitter.on(' ').split(sentence);
        return Joiner.on(' ').join(Iterables.transform(words, reverseLetters));
    }

    private ReverseWords(final ReverseLetters reversePhrase) {
        Preconditions.checkArgument(reversePhrase != null);
        this.reverseLetters = reversePhrase;
    }

    private final ReverseLetters reverseLetters;
}
