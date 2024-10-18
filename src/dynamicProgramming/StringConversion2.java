package dynamicProgramming;

public class StringConversion2 {
    public static void main(String[] args) {
        String a = "pear";

        String b = "sea";


      int lcs =   usingLcs(a, b, a.length(), b.length());
        System.out.println("delete = "+(a.length()-lcs));
        System.out.println("insert = " +(b.length()-lcs));

    }

    private static int usingLcs(String a, String b, int l1, int l2) {

        if (l1==0 || l2==0) return 0;
        if (a.charAt(l1-1)==b.charAt(l2-1)) return 1+usingLcs(a, b, l1-1, l2-1);

        return Math.max(usingLcs(a, b, l1 - 1, l2), usingLcs(a, b, l1, l2 - 1));


    }
}
