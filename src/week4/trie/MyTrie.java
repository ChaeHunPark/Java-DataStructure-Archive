package week4.trie;

public class MyTrie {

    static class TrieNode {
        //알파벳 26개에 대응하는 자식 노드 배열
        TrieNode[] children = new TrieNode[26];
        // 단어의 끝임을 나타내는 마커
        boolean isEndOfWord;
    }

    private final TrieNode root;

    public MyTrie() {
        this.root = new TrieNode();
    }

    // 단어 삽입
    public void insert(String word) {
        TrieNode current = root;

        // 단어의 철자를 하나씩 따라가며 길 만들기
        for (char c : word.toLowerCase().toCharArray()) {

            int index = c - 'a'; // 문자를 0~25 인덱스로 변환

            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toLowerCase().toCharArray()) {
            int index = c - 'a';

            // 중간에 길이 끊기면? 그단어는 없는 것
            if(current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        // 마지막 포문이 끝나고 깃발 확인
        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toLowerCase().toCharArray()) {
            int index = c - 'a';
            if(current.children[index] == null) return false;
            current = current.children[index];
        }
        // 깃발 여부와 상관없이, 그 지점까지 도달했다면 true!
        return true;
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        // 1. 단어의 끝까지 내려온 경우
        if(index == word.length()) {
            // 단어가 없는데 삭제하라고 한 경우
            if(!current.isEndOfWord) return false;

            // 깃발 내리기
            current.isEndOfWord = false;

            // 이 노드 밑에 자식이 없으면 삭제 가능하다고 리턴
            return isEmpty(current);
        }

        // 2. 내려가는 과정
        char c = word.charAt(index);
        int charIndex = c - 'a';
        TrieNode node = current.children[charIndex];

        if (node == null) return false; // 지울 단어가 없음

        // 재귀적으로 끝까지 내려갔다가 올라오면서 삭제 여부 결정
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        // 3. 거꾸로 올라오며 철거
        if(shouldDeleteCurrentNode) {
            current.children[charIndex] = null;

            // 나도 깃발이 없고, 밑에 다른 자식도 없다면 나도 철거 대상
            return !current.isEndOfWord && isEmpty(current);
        }

        return false;
    }

    // 해당 노드 밑에 자식이 하나라도 있는지 체크하는 메서드
    private boolean isEmpty(TrieNode node) {
        for(int i = 0; i < 26; i++) {
            if(node.children[i] != null) return false;
        }
        return true;
    }

}
