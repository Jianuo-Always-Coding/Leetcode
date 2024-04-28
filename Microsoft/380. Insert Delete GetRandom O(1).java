class RandomizedSet {
    Map<Integer,Integer>map; // 存放val 和 index，因为remove的时候需要用到
    List<Integer>list; // 存放数 get random 可以通过index得到数字
    Random rand;
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
        rand=new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        // to remove first get the index of given val
        int idx = map.get(val);
        // take the last value from the list
        int lastVal = list.get(list.size()-1);
        // insert the lastVal in the given val idx
        list.set(idx,lastVal);
        // update the lastVal index
        map.put(lastVal,idx);
        // remove the val
        list.remove(list.size()-1);
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        int randIndex = rand.nextInt(list.size());
        return list.get(randIndex);
    }
}