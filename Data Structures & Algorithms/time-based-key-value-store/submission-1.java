class TimeMap {

    class Pair {
        String value;
        int timestamp;
    }

    HashMap<String, ArrayList<Pair>> map;
    
    public TimeMap() {
        map = new HashMap<String, ArrayList<Pair>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Pair>());
        }

        ArrayList<Pair> arr = map.get(key);
        Pair pair = new Pair();
        pair.timestamp = timestamp;
        pair.value = value;
        arr.add(pair);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        String res;
        ArrayList<Pair> pairs = map.get(key);

        int left = 0, right = pairs.size()-1;
        int mid;
        while (left < right) {
            mid = right - (right-left)/2;

            Pair pair = pairs.get(mid);
            if (pair.timestamp == timestamp) return pair.value;

            if (pair.timestamp > timestamp) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (left < 0) left = 0;
        if (left == pairs.size()) left = pairs.size()-1;
        Pair pair = pairs.get(left);
        if (pair.timestamp <= timestamp) return pair.value;

        return "";
    }
}
