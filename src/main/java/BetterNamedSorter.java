import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BetterNamedSorter {

    class ByNumericPrefixAndThenAlphabetically implements Comparator<String> {

        String startsWithNumericPrefix = "^([0-9]*).*";

        @Override
        public int compare(String one, String another) {
            Pattern startsWithNumericPrefixPattern = Pattern.compile(startsWithNumericPrefix);
            Matcher m1 = startsWithNumericPrefixPattern.matcher(one);
            Matcher m2 = startsWithNumericPrefixPattern.matcher(another);
            int oneNumericPrefixLength = -1, anotherNumericPrefixLength = -1;

            if (m1.find()) {
                oneNumericPrefixLength = m1.group(1).length();
            }

            if (m2.find()) {
                anotherNumericPrefixLength = m2.group(1).length();
            }


            if (oneNumericPrefixLength == 0 && anotherNumericPrefixLength == 0) {
                return one.compareTo(another);
            }

            if (oneNumericPrefixLength == 0 && anotherNumericPrefixLength != 0) return 1;
            if (anotherNumericPrefixLength == 0 && oneNumericPrefixLength != 0) return -1;


            int aNumericPrefix = Integer.parseInt(one.substring(0, oneNumericPrefixLength));
            int anotherNumericPrefix = Integer.parseInt(another.substring(0, oneNumericPrefixLength));
            return Integer.compare(aNumericPrefix, anotherNumericPrefix);
        }
    }

    public void sort(String[] a) {
        Arrays.sort(a, new ByNumericPrefixAndThenAlphabetically());
    }
}
