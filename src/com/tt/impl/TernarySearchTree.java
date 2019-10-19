package oracle;

import java.util.ArrayList;
import java.util.List;

class TSTNode {
    char val;
    TSTNode left;
    TSTNode right;
    TSTNode middle;
    List<String> prefix;
    boolean isEnd;

    protected TSTNode(char c) {
        this.val = c;
        prefix = new ArrayList<>();
    }
}

public class TernarySearchTree {
    TSTNode root;

    public static void main(String[] args) {
        TernarySearchTree tst = new TernarySearchTree();
        System.out.println(tst.insertDriver(new String[] { "himanish", "hillary", "himani", "himesh", "henry" }));
        List<String> searchPrefix = tst.searchPrefixDriver("himesh");

        for (String s : searchPrefix) {
            System.out.println(s);
        }
    }

    TSTNode insertDriver(String words[]) {
        for (String word : words) {
            root = insert(word.toCharArray(), root, 0);
        }
        return root;
    }

    TSTNode insert(char letters[], TSTNode curr, int index) {
        if (curr == null) {
            curr = new TSTNode(letters[index]);
        }
        if (curr.val > letters[index]) {
            curr.left = insert(letters, curr.left, index);
        } else if (curr.val < letters[index]) {
            curr.right = insert(letters, curr.right, index);
        } else {
            curr.prefix.add(String.valueOf(letters));
            if (index == letters.length - 1) {
                curr.isEnd = true;
            } else {
                curr.middle = insert(letters, curr.middle, index + 1);
            }
        }

        return curr;
    }

    List<String> searchPrefixDriver(String prefix) {
        return searchPrefix(prefix.toCharArray(), root, 0);
    }

    List<String> searchPrefix(char[] letters, TSTNode curr, int index) {
        if (curr == null) {
            return new ArrayList<>();
        }
        if (curr.val > letters[index]) {
            return searchPrefix(letters, curr.left, index);
        } else if (curr.val < letters[index]) {
            return searchPrefix(letters, curr.right, index);
        } else {
            if (index == letters.length - 1) {
                return curr.prefix;
            } else {
                return searchPrefix(letters, curr.middle, index + 1);
            }
        }
    }

}
