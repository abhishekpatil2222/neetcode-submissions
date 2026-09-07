class TimeMap {
    class Pair{
        int time;
        String val;

        Pair(int t, String v){
            this.time = t;
            this.val = v;
        }

    }
    Map<String, List<Pair>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.putIfAbsent(key, new ArrayList<>());
        keyStore.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!keyStore.containsKey(key)) return "";
        List<Pair> values = keyStore.get(key);
        int left = 0, right = values.size() - 1;
        String res = "";
        while(left <= right){
            int mid = (left + right) / 2;
            if(values.get(mid).time <= timestamp){
                res = values.get(mid).val;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
}
