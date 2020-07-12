/*

 Word Search II

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example:

Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]

 

Note:

    All inputs are consist of lowercase letters a-z.
    The values of words are distinct.



*/


class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for(String word : words){
            if(exist(board,word)){
                res.add(word);
            }
        }
        return res;
    }
    
    private boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(existWord(board, i, j, word, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean existWord(char[][] board, int i, int j, String word, int from, boolean visited[][]){
        if(from == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length){
            return false;
        }
        if(j < 0 || j >= board[0].length){
            return false;
        }
        if(board[i][j] != word.charAt(from)){
            return false;
        }
        if(visited[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        
        boolean res = existWord(board, i + 1, j, word, from + 1, visited) ||
                        existWord(board, i - 1, j, word, from + 1, visited) ||
                        existWord(board, i, j + 1, word, from + 1, visited) ||
                        existWord(board, i, j - 1, word, from + 1, visited);
        
        visited[i][j] = false;
        return res;
    }
}