package com.example.myapplication.utils;

import com.example.myapplication.utils.TrieNode;

import java.util.ArrayList;
import java.util.Map;

public class trie {
    public static TrieNode root = new TrieNode();



    public static void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new TrieNode());
            }
            cur = cur.children.get(ch);
        }
        cur.isEndOfWord = true;
    }

    public static ArrayList<String> findWordsWithPrefix(String prefix) {
        ArrayList<String> res = new ArrayList<>();
        TrieNode cur = root;

        // Traverse the trie to the prefix
        for (char ch : prefix.toCharArray()) {
            if (!cur.children.containsKey(ch)) {
                return res; // Prefix not found, return empty list
            }
            cur = cur.children.get(ch);
        }

        // Use helper method to find all words with the given prefix
        helperSearch(res, cur, prefix);
        return res;
    }

    private static void helperSearch(ArrayList<String> list, TrieNode node, String curStr) {
        if (node.isEndOfWord) {
            list.add(curStr);
        }

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            char ch = entry.getKey();
            TrieNode childNode = entry.getValue();
            helperSearch(list, childNode, curStr + ch);
        }
    }
}

