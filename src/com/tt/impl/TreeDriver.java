package com.tt.impl;

public class TreeDriver {
	public static void main(String[] args) {
		TernaryTree tt = new TernaryTree();
		tt.insert("abcd");
		tt.insert("abde");
		System.out.println(tt);
	}
}
