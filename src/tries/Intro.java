package tries;

public class Intro {
    public static Node root = new Node();
    static  class  Node{
        Node[] child = new Node[26];
        boolean end = false;
        public Node() {
            for (int i = 0; i < 26; i++) child[i] = null;
        }
    }
    public static void main(String[] args) {
        String words[] = {"the", "their", "this", "a", "an", "any", "anywhere"};

        for (String el:words) insertion(el);




        System.out.println(search("anywhere"));

    }


    public  static  void  insertion(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx]= new Node();
            }
            curr = curr.child[idx];
        }

        curr.end = true;

    }


    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.child[idx]==null)return false;
            curr = curr.child[idx];

        }
        return curr.end;

    }


}
