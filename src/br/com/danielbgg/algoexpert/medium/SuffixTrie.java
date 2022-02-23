package br.com.danielbgg.algoexpert.medium;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrie {

	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	}

	TrieNode root = new TrieNode();
	char endSymbol = '*';

	public SuffixTrie(String str) {
		populateSuffixTrieFrom(str);
	}

	//time: O(n^2) | space: O(n^2)
	public void populateSuffixTrieFrom(String str) {
		for (int i = 0; i < str.length(); i++) {
			String s = str.substring(i, str.length());
			populate(s);
		}
	}

	private void populate(String str) {
		TrieNode parent = root;
		for (int i = 0; i < str.length(); i++) {
			TrieNode node = parent.children.get(str.charAt(i));
			if (node == null) {
				node = new TrieNode();
				parent.children.put(str.charAt(i), node);
			}
			parent = node;
		}
		parent.children.put(endSymbol, null);
	}

	//time: O(n) | space: O(1)
	public boolean contains(String str) {
		TrieNode parent = root;
		for (int i = 0; i < str.length(); i++) {
			TrieNode node = parent.children.get(str.charAt(i));
			if (node == null) {
				return false;
			}
			parent = node;
		}
		return parent.children.containsKey(endSymbol);
	}

	public static void main(String[] args) {
		SuffixTrie trie = new SuffixTrie("babc");
		System.out.println(trie.contains("babc"));
		System.out.println(trie.contains("abc"));
		System.out.println(trie.contains("bab"));
	}

}
