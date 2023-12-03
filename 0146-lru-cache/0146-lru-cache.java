import java.util.HashMap;
import java.util.Map;

class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
    }

    Node head;
    Node tail;
    private Map<Integer, Node> map;
    private final int CAPACITY;

    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            moveToHead(map.get(key));
            return;
        } else if (map.size() >= CAPACITY) {
            map.remove(removeTail());
        }
        Node node = addNode(new Node(key, value));
        map.put(key, node);
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private int removeTail() {
        int keyToRemove = tail.prev.key;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return keyToRemove;
    }

    private void removeNode(Node node){
        Node pre = node.prev;
        Node post = node.next;

        pre.next = post;
        post.prev = pre;
    }

    private Node addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        return node;
    }

    private static class Node {
        Node prev;
        Node next;

        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
