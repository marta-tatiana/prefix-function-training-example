import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ABitBetterSorter {

    public void sort(String[] a) {
        Arrays.sort(a, (s1, s2) -> {
            Pattern p = Pattern.compile("^([0-9]*).*");
            Matcher m1 = p.matcher(s1);
            Matcher m2 = p.matcher(s2);
            int p1 = -1, p2 = -1;

            if (m1.find()) {
                p1 = m1.group(1).length();
            }

            if (m2.find()) {
                p2 = m2.group(1).length();
            }


            if (p1 == 0 && p2 == 0) {
                return s1.compareTo(s2);
            }

            if (p1 == 0 && p2 != 0) return 1;
            if (p2 == 0 && p1 != 0) return -1;


            int l1 = Integer.parseInt(s1.substring(0, p1));
            int l2 = Integer.parseInt(s2.substring(0, p2));
            return Integer.compare(l1, l2);
        });
    }
}
