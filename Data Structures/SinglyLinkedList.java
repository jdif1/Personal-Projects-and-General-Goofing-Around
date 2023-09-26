import java.util.ArrayList;

public class SinglyLinkedList<T> {
    private LLNode<T> head = new LLNode<>(null);
    private LLNode<T> tail;
    private int size = 0;

    public void addNode(T data){
        if (size == 0){
            head.data = data;
            tail = head;
        }else{
            tail.next = new LLNode<>(data);
            tail = tail.next;
        }
        size++;
    }

    public LLNode<T> nodeTraversal(int target){
        if (target > size - 1 || target < 0 ){
            throw new IndexOutOfBoundsException("The target position is outside the bounds of the list. The bounds" +
                    " are between 0 and " + size +"." );
        }
        LLNode<T> node = head;
        for (int i = 0; i < target; i++){
            node = node.next;
        }
        return node;
    }

    public void removeNode (int target){
        if (target == 0){
            head = head.next;
            System.out.println("check");
        }else{
            LLNode<T> previousNode = nodeTraversal(target-1);
            if (previousNode.next == tail){
                previousNode.next = null;
                tail = previousNode;
            } else {
                previousNode.setNext(previousNode.next.next);
            }
        }
        size--;
    }

    public int searchForFirstMatch(T searchData){
        //returns the location of the first match found, if no locations are found, returns -1
        LLNode<T> node = head;
        for (int i = 0; i < size; i++){
            if (searchData == node.getData()){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Integer> searchForAllMatches(T searchData){
        //returns an ArrayList with all matches found, if no matches are found the ArrayList will be empty
        ArrayList<Integer> matches = new ArrayList<>();
        LLNode<T> node = head;
        for (int i = 0; i < size; i++){
            if (searchData == node.getData()){
                matches.add(i);
            }
        }
        return matches;
    }

    public int getSize() { return size; }

    public LLNode<T> getHead() { return head; }
    
    protected class LLNode<T> {
        T data;
        LLNode<T> next;
        LLNode(T data){
            this.data = data;
            this.next = null;
        }
        public T getData() { return data; }

        public void setData(T data) { this.data = data; }

        private void setNext(LLNode<T> next){ this.next = next; }
    }
}
