package playlist_backend;

public class Node {
    String songName;
    Node next;
    Node prev;

    public Node(String name) {
        this.songName = name;
        this.next = null;
        this.prev = null;
    }
}
