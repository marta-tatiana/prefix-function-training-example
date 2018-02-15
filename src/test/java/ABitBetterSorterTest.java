import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ABitBetterSorterTest {

    @Test
    public void sortsCorrectly1() {
        String[] a = new String[]{"b", "aaa", "dd", "aba"};
        ABitBetterSorter sorter = new ABitBetterSorter();
        sorter.sort(a);
        assertThat(a, equalTo(new String[]{"aaa", "aba", "b", "dd"}));
    }


    @Test
    public void sortsCorrectly2() {
        String[] a = new String[]{"b", "01aaa", "02dd", "aba"};
        ABitBetterSorter sorter = new ABitBetterSorter();
        sorter.sort(a);
        assertThat(a, equalTo(new String[]{"01aaa", "02dd", "aba", "b"}));
    }

    @Test
    public void sortsCorrectly3() {
        String[] a = new String[]{"01a", "34a", "02a"};
        ABitBetterSorter sorter = new ABitBetterSorter();
        sorter.sort(a);
        assertThat(a, equalTo(new String[]{"01a", "02a", "34a"}));
    }
}
