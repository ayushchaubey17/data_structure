package tries;

public class WordBreakProblem {
    public static void main(String[] args) {
        String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        String key = "iicelikemobile";


        for (String word: words) Intro.insertion(word);

      boolean a =   wordbreak(key);
        System.out.println(a);

    }

    private static boolean wordbreak(String key) {
        if (key.length()==0)return true;
        for (int i = 1; i <= key.length(); i++)
        {

            if (Intro.search(key.substring(0,i)) && Intro.search(key.substring(i))) return true;

            if (Intro.search(key.substring(0,i)) && wordbreak(key.substring(i))) return true;
        }
        return false;
    }


}
