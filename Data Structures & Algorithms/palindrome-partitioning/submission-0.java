class Solution {
    private List<List<String>> res;
    private List<String> part;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        part = new ArrayList<>();
        dfs(0, s);
        return res;
    }
    public void dfs(int i, String s){
        if(i >= s.length()){
            res.add(new ArrayList<>(part));
            return;
        }
        for(int j = i; j < s.length(); j++){
            if(isPalin(s,i, j)){
                part.add(s.substring(i, j + 1));
                dfs(j + 1, s);
                part.remove(part.size() - 1);
            }
        }
    }

    public boolean isPalin(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
