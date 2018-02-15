import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BetterNamedSorterShould {

    @Test
    public void sortAlphabeticallyWhenGivenStringsWithoutNumericPrefixes() {
        String[] a = new String[]{"b", "aaa", "dd", "aba"};
        BetterNamedSorter sorter = new BetterNamedSorter();
        sorter.sort(a);
        assertThat(a, equalTo(new String[]{"aaa", "aba", "b", "dd"}));
    }


    @Test
    public void sortByNumericPrefixesAndThenAlphabeticallyWhenGivenStringsWithAndWithoutPrefixes() {
        String[] a = new String[]{"b", "01aaa", "02dd", "aba"};
        BetterNamedSorter sorter = new BetterNamedSorter();
        sorter.sort(a);
        assertThat(a, equalTo(new String[]{"01aaa", "02dd", "aba", "b"}));
    }

    @Test
    public void sortByNumericPrefixesIfPresent() {
        String[] a = new String[]{"01a", "34a", "02a"};
        BetterNamedSorter sorter = new BetterNamedSorter();
        sorter.sort(a);
        assertThat(a, equalTo(new String[]{"01a", "02a", "34a"}));
    }

    @Test
    public void workOnEmptyArray() {
        String[] a = new String[]{};
        BetterNamedSorter sorter = new BetterNamedSorter();
        sorter.sort(a);
        assertThat(a, equalTo(new String[]{}));
    }
}
