package ArrayAndHashing;

public class SentenceSim3 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() >= sentence2.length())
            return check(sentence1, sentence2);
        return check(sentence2, sentence1);
    }

    private boolean check(String s1, String s2) {
        String[] s1Arr = s1.split(" ");
        String[] s2Arr = s2.split(" ");

        int i = 0, j = s2Arr.length - 1;

        // prefix
        for (int k = 0; k < s1Arr.length && i < s2Arr.length; k++) {
            String u = s1Arr[k];
            String v = s2Arr[i];

            if (!u.equals(v))
                break;

            i++;
        }

        // suffix
        for (int k = s1Arr.length - 1; k >= 0 && j >= 0; k--) {
            String u = s1Arr[k];
            String v = s2Arr[j];

            if (!u.equals(v))
                break;

            j--;
        }

        return i > j;
    }
}
