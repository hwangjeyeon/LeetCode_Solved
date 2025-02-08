class NumberContainers {
    static Map<Integer, TreeSet<Integer>> num;
    static Map<Integer, Integer> indexes;
    public NumberContainers() {
        num = new HashMap<>();
        indexes = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(indexes.containsKey(index)){
            int pre = indexes.get(index);
            num.get(pre).remove(index);
            if(num.get(pre).isEmpty()){
                num.remove(pre);
            }
        }
        indexes.put(index, number);
        num.putIfAbsent(number, new TreeSet<>());
        num.get(number).add(index);
    }
    
    public int find(int number) {
        if(num.containsKey(number)){
            return num.get(number).first();
        }
        
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */