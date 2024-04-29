 class Node {
        int key, val, cnt;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            cnt = 1;
    }
}
class LFUCache {
    Map<Integer,Node[]> freq;
    Map<Integer,Node> map;
    int size=0;
    int lst_freq=1;
    public Node[] createList(){
        Node start=new Node(-1,-1);
        Node end=new Node(-1,-1);
        start.next=end;
        end.prev=start;
        return new Node[]{start,end};
    }
    public LFUCache(int capacity) {
        freq=new HashMap<>();
        map=new HashMap<>();
        size=capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        Node n=map.get(key);
        removeFromFreq(n,n.cnt);
        addOnFreq(n,n.cnt);
        return n.val;
    }
    
    public void put(int key, int value) {
        if(size==0)return;
        if(map.containsKey(key)){
            Node n=map.get(key);
            n.val=value;
            removeFromFreq(n,n.cnt);
            addOnFreq(n,n.cnt);
        }else{
            if(map.size()==size)
                invalidate(lst_freq);
            Node n = new Node(key,value);
            lst_freq=1;
            map.put(key,n);
            addOnFreq(n,1);
        }
    }
    void addOnFreq(Node n,int frq){
        if(!freq.containsKey(frq))
            freq.put(frq,createList());
        Node start=freq.get(frq)[0];
        Node end=freq.get(frq)[1];
        start.next.prev=n;
        n.next=start.next;
        start.next=n;
        n.prev=start;
    }
    void removeFromFreq(Node n,int frq){
        Node start=freq.get(frq)[0];
        n.prev.next=n.next;
        n.next.prev=n.prev;
        if(frq==lst_freq && start.next.next==null)lst_freq++;
        n.cnt=frq+1;
    }
    void invalidate(int frq){
        Node start=freq.get(frq)[0];
        Node end=freq.get(frq)[1];
        map.remove(end.prev.key);
        end.prev.prev.next=end;
        end.prev=end.prev.prev;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */