// TC: O(1)
// SC: O(K), Where k is capacity

class LRUCache {

    class Node {
        int key;
        int value;
        Node next, prev;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
   
    private void addFirst(Node node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;     
    }
    
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    Node head;
    Node tail;
    HashMap<Integer, Node> hm;
    int capacity;
    public LRUCache(int capacity) {
        hm = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)) return -1;
        Node node = hm.get(key);
        remove(node);
        addFirst(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)) {
            Node node = hm.get(key);
            node.value = value;
            remove(node);
            addFirst(node);
            return;
        } 
        
        Node node = new Node(key, value);
        if(hm.size() == capacity) {
            hm.remove(tail.prev.key);
            remove(tail.prev);
        }
        addFirst(node);
        hm.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
