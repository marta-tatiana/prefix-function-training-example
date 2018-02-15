import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringPrefix {
    private int numericPrefix;
    static int NOT_NUMERIC = -1;

    public StringPrefix(String s) {
        int prefixLength = numericPrefixLength(s);
        this.numericPrefix = (prefixLength == 0) ? NOT_NUMERIC : Integer.parseInt(s.substring(0, prefixLength));
    }

    public int getNumericPrefix() {
        return numericPrefix;
    }

    public boolean isNumericPrefix() {
        return numericPrefix != NOT_NUMERIC;
    }

    private int numericPrefixLength(String s) {
        String startsWithNumericPrefix = "^([0-9]*).*";

        Pattern startsWithNumericPrefixPattern = Pattern.compile(startsWithNumericPrefix);
        Matcher m1 = startsWithNumericPrefixPattern.matcher(s);

        if (m1.find()) {
            return m1.group(1).length();
        }
        return 0;
    }
}

class ByNumericPrefixAndThenAlphabetically implements Comparator<String> {

    @Override
    public int compare(String one, String another) {
        StringPrefix first = new StringPrefix(one);
        StringPrefix second = new StringPrefix(another);

        if (noneHasNumericPrefix(first, second)) {
            return one.compareTo(another);
        }

        if (onlyOneIsNumericPrefix(first, second)) {
            return -1;
        }

        if (onlyOneIsNumericPrefix(second, first)) {
            return 1;
        }

        return Integer.compare(first.getNumericPrefix(), second.getNumericPrefix());
    }

    private boolean noneHasNumericPrefix(StringPrefix first, StringPrefix second) {
        return !first.isNumericPrefix() && !second.isNumericPrefix();
    }

    private boolean onlyOneIsNumericPrefix(StringPrefix first, StringPrefix second) {
        return first.isNumericPrefix() && !second.isNumericPrefix();
    }
}

public class SorterWithExtractedMethods {

    public void sort(String[] a) {
        Arrays.sort(a, new ByNumericPrefixAndThenAlphabetically());
    }

}
