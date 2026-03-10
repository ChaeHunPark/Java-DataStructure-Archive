package week4.trie;

public class MyTrieTest {
    public static void main(String[] args) {
        MyTrie trie = new MyTrie();
// 1. 기초 데이터 삽입 (공통 경로 생성)
        System.out.println("=== 데이터 삽입: apple, apply, app ===");
        trie.insert("apple");
        trie.insert("apply");
        trie.insert("app");

        // 2. 삭제 전 상태 확인
        System.out.println("apple 있음? : " + trie.search("apple")); // true
        System.out.println("apply 있음? : " + trie.search("apply")); // true
        System.out.println("app 있음?   : " + trie.search("app"));   // true

        // 3. apple 삭제 (공통 경로가 있는 단어 삭제)
        System.out.println("\n=== apple 삭제 실행 ===");
        trie.delete("apple");

        System.out.println("apple 있음? : " + trie.search("apple")); // false (삭제됨)
        System.out.println("apply 있음? : " + trie.search("apply")); // true  (살아있어야 함!)
        System.out.println("app 있음?   : " + trie.search("app"));   // true  (살아있어야 함!)

        // 4. apply 삭제 (마지막 남은 긴 단어 삭제)
        System.out.println("\n=== apply 삭제 실행 ===");
        trie.delete("apply");

        System.out.println("apply 있음? : " + trie.search("apply")); // false
        System.out.println("app 있음?   : " + trie.search("app"));   // true (app은 깃발이 따로 있어서 살아야 함)

        // 5. 없는 단어 삭제 시도
        System.out.println("\n=== 없는 단어(banana) 삭제 시도 ===");
        trie.delete("banana"); // 에러 없이 조용히 지나가야 함
    }
}
