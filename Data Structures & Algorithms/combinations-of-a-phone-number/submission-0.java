class Solution {
    public List<String> res;
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.isEmpty()) return res;
        backTrack(0, "", digits);
        return res;
    }
    public void backTrack(int i, String cur, String digits){
        if(cur.length() == digits.length()){
            res.add(cur);
            return;
        }
        String chars = digitToChar[digits.charAt(i) - '0'];
        for(char c : chars.toCharArray()){
            backTrack(i+1, cur + c, digits);
        }
    }
}
