class Solution {
    Map<Character, Set<Character>> adj;
    Map<Character, Boolean> visited;
    StringBuilder res;
    public String foreignDictionary(String[] words) {
        adj = new HashMap<>();

        for(String word : words){
            for(char c : word.toCharArray()){
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        for(int i=0; i < words.length - 1; i++){
            String w1 = words[i], w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());
                if( w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))){
                    return "";
                }
            for(int j = 0; j < minLen; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        visited = new HashMap<>();
        res = new StringBuilder();
        for(char c : adj.keySet()){
            if(dfs(c)){
                return "";
            }
        }
        res.reverse();
        return res.toString();
    }

    public boolean dfs(Character c){
        if(visited.containsKey(c)){
            return visited.get(c);
        }
        visited.put(c, true);
        for(char next : adj.get(c)){
            if(dfs(next)){
                return true;
            }
        }
        visited.put(c, false);
        res.append(c);
        return false;
    }
}
