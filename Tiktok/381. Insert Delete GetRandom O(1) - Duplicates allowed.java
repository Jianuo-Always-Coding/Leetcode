class RandomizedCollection {
    private Map<Integer,List<Integer>> map;
    private List<Integer> list;
    private int size;
    
    public RandomizedCollection() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.size = 0;
    }
    
    public boolean insert(int val) {
        boolean result = map.containsKey(val);
        if(!result) {
            List<Integer> lst = new ArrayList<>();
            map.put(val, lst);
        }

        list.add(size,val);
        map.get(val).add(size);
        size++;
        return !result;
    }
    
    public boolean remove(int val) {
        // 没有这个元素
        if(map.get(val) == null) {
            return false;
        }
        List<Integer> lst = map.get(val);
        //get first indx of th val to be removed
        int idx = lst.remove(0);
        if(map.get(val).size() == 0)
            map.remove(val);
        
        //get last element to be swaped with element to be deleted
        int last = list.get(size - 1); // list中最后一个元素的值
        //get pos list of last element and updte it
        if(idx != size - 1) {
            List<Integer> last_element_list = map.get(last);
            last_element_list.remove(new Integer(size - 1)); // 移除最后一个index，如果不变成Integer，就按照索引移除
            last_element_list.add(idx);
            //overrrite the element to be deleted by last element
            list.set(idx, list.get(size - 1));
        }
        size--;
        return true;
        
    }
    
    public int getRandom() {
        Random rdm = new Random();
        return list.get(rdm.nextInt(this.size));
    }
}
