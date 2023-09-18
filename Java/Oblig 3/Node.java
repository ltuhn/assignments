public class Node<T> {
    private Node<T> neste;
    private T data;

    public Node(T data) {
        this.data = data;
    }
    
    public void settNeste(Node<T> n) {
        this.neste = n;
    }
    
    public Node<T> hentNeste() {
        return neste;
    }
    
    public T hentData() {
        return data;
    }

    @Override
    public String toString() {
        Node<T> temp = this;
        String stringTemp = "";

        while(temp != null) {
            stringTemp += temp.hentData() + " | ";
            temp = temp.hentNeste();
        }
        return stringTemp;
    }
}