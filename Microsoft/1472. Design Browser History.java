class Node{
    String data;
    Node next;
    Node prev; 
    public Node(String data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class BrowserHistory {
    Node Home;
    Node temp;
    public BrowserHistory(String homepage) {
        Home = new Node(homepage);
        temp = Home; 
    }
    
    public void visit(String url) {
       
        Node newVisited = new Node(url);
        temp.next = newVisited;
        newVisited.prev = temp;
        temp = newVisited;
    }
    
    public String back(int steps) {
        int count = 0;
        while(temp.prev != null && count != steps ){
            temp = temp.prev;
            count++;
        }
        return temp.data;
    }
    
    public String forward(int steps) {
        int count = 0;
        while(temp.next != null && count != steps ){
            temp = temp.next;
            count++;
        }
        return temp.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */