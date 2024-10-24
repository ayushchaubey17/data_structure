package tries;

public class PrefixProblem {
    static Node root =new Node();

    static  class  Node{
        Node[] child = new Node[26];
        boolean eow;
        int freq =1;
    }
    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        root.freq = -1;

        for (String el: arr) insertion(el);

        for (String el: arr){
            System.out.print(findPrefix(el)+",");
        }


    }

    public static String findPrefix(String key) {
        Node curr = root;

        String ans ="";
        for (int level =0;level<key.length();level++)
        {
            int idx = key.charAt(level)-'a';
            curr = curr.child[idx];
            if (curr.freq==1)
              return   ans+= (char)(idx+'a');

            else ans+= (char)(idx+'a');


        }
        return ans;
    }

    public static void insertion(String word) {
        Node curr = root;
        for (int level =0;level<word.length();level++)
        {
            int idx = word.charAt(level)-'a';
            if (curr.child[idx]==null) curr.child[idx]= new Node();
            else curr.child[idx].freq++;
            curr = curr.child[idx];

        }
        curr.eow = true;
    }
}
