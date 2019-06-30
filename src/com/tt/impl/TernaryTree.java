package com.tt.impl;

import java.util.ArrayList;

public class TernaryTree {
	TreeNode root;

	void insert(String word) {
		root = insert(root, word.toLowerCase(), 0);
	}

	private TreeNode insert(TreeNode curr, String word, int i) {
		if (curr == null) {
			curr = new TreeNode(word.charAt(i));
		}

		if (word.charAt(i) > curr.val) {
			curr.right = insert(curr.right, word, i);
		} else if (word.charAt(i) < curr.val) {
			curr.left = insert(curr.left, word, i);
		} else {
			if (i == word.length() - 1) {
				curr.isEnd = true;
			} else {
				curr.middle = insert(curr.middle, word, i + 1);
			}
		}
		return curr;
	}

	ArrayList<String> list = new ArrayList<String>();

	ArrayList<String> getMatch(String word) {

		return list;
	}
}
