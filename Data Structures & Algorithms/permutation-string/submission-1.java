class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i=0; i < s1.length(); i++){
            freq1[s1.charAt(i) - 'a'] += 1;
            freq2[s2.charAt(i) - 'a'] += 1;
        }
        int matches = 0;
        for(int i=0; i < 26; i++){
            if(freq1[i] == freq2[i]) matches++;
        }
        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++){
            if(matches == 26) return true;

            int index = s2.charAt(r) - 'a';
            freq2[index] += 1;
            if(freq2[index] == freq1[index]) matches++;
            else if(freq2[index] - 1 == freq1[index]) matches--;

            index = s2.charAt(l) - 'a';
            freq2[index] -= 1;
            l++;
            if(freq2[index] == freq1[index]) matches++;
            else if(freq2[index] + 1 == freq1[index]) matches--;


        }

        return matches == 26;

        
    }
}
