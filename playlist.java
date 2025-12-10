package playlist_backend;

public class Playlist {

    private Node head;
    private Node current;

    public void addSong(String name) {
        Node newSong = new Node(name);

        if (head == null) {
            head = newSong;
            current = head;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = newSong;
            newSong.prev = temp;
        }
    }

    public void removeSong(String name) {
        Node temp = head;

        while (temp != null && !temp.songName.equals(name))
            temp = temp.next;

        if (temp == null)
            return;

        if (temp == head)
            head = temp.next;

        if (temp.prev != null)
            temp.prev.next = temp.next;

        if (temp.next != null)
            temp.next.prev = temp.prev;

        if (temp == current)
            current = head;
    }

    public void playNext() {
        if (current != null && current.next != null)
            current = current.next;
    }

    public void playPrevious() {
        if (current != null && current.prev != null)
            current = current.prev;
    }

    public String getCurrentSong() {
        return (current != null) ? current.songName : "No song playing";
    }

    public String getPlaylist() {
        if (head == null) return "Playlist is empty!";

        StringBuilder sb = new StringBuilder();
        Node temp = head;

        while (temp != null) {
            sb.append(temp.songName);
            if (temp == current) sb.append("  <-- Playing");
            sb.append("\n");
            temp = temp.next;
        }
        return sb.toString();
    }
}
