public class MyLinkedList<E>{
    private Node head;
    private int numNodes=0;
    public MyLinkedList()
    {
        head = null;
    }
    private class Node
    {
        private Node next;
        private Object data;

        public Node(Object data)
        {
            this.data=data;
        }
        public Object getData()
        {
            return this.data;
        }
    }
    public void add(int index , E element)
    {
        if(head==null)
        {
            head=new Node(element);
            head.next=null;
        }
        Node temp = head;
        Node holder;
        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;

    }
    public void addFirst(E e)
    {
        Node temp =head;
        head= new Node(e);
        head.next=temp;
        numNodes++;
    }
    public void addLast (E e)
    {
        if(head==null)
        {
            head=new Node(e);
            head.next=null;
        }
        Node temp =head;
        while (temp.next!=null)
        {
            temp=temp.next;
        }
        Node newNode = new Node(e);
        temp.next=newNode;
    }
    public E remove (int index)
    {
        if (index < 0 || index >= numNodes) return null;
        else if (index == 0) return removeFirst();
        else if (index == numNodes - 1) return removeLast();
        else {
            Node previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node current = previous.next;
            previous.next = current.next;
            numNodes--;
            return (E)current.data;
        }

    }
    public E removeLast() {
        if (numNodes == 0) return null; // Nothing to remove
        else if (numNodes == 1) { // Only one element in the list
            Node temp = head;
            head = null; // list becomes empty
            numNodes = 0;
            return (E)temp.data;
        } else {
            Node current = head;

            for (int i = 0; i < numNodes - 2; i++)
                current = current.next;

            Node temp = current.next;
            current.next=null;
            numNodes--;
            return (E)temp.data;
        }
    }
    public E removeFirst() {
        if (numNodes == 0) return null; // Nothing to delete
        else {
            Node temp = head; // Keep the first node temporarily
            head = head.next; // Move head to point to next node
            numNodes--; // Reduce size by 1
            return (E)temp.data; // Return the deleted element
        }
    }
    public boolean remove(E e)
    {
        Node temp =head;
        while(temp!=null)
        {
            if(e.equals(temp.data))
                return false;
            temp=temp.next;
        }
        remove(indexOf(e));
        return true;
    }
    public int indexOf(E o)
    {
        int index =0;
        Node temp =head;
        while(temp!=null)
        {
            if(temp.data==o)
            {
                return index;
            }
            temp=temp.next;
            index++;
        }
        return -1;
    }
    public int size()
    {
        return this.numNodes;
    }
    public MyLinkedList<E> clone()
    {
        MyLinkedList<E> newLinkedList = new MyLinkedList<>();
        Node temp = head;
        while(temp!=null)
            newLinkedList.addLast((E)temp.data);
        return newLinkedList;
    }
    public boolean contains (E o)
    {
        Node temp =head;
        while(temp!=null)
        {
            if(o.equals((E)temp.data))
            {
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public boolean add(E e)
    {
        Node temp = head;
        while(temp!=null)
        {
            if(temp.data==e)
            {
                return false;
            }
            temp=temp.next;
        }
        this.addLast(e);
        return true;
    }
    public E get(int i)
    {
        Node temp= head;
        int index =0;
        while(temp!=null)
        {
            temp=temp.next;
            index++;
            if(index==i)
            {
                return (E)temp.data;
            }
        }
        return null;
    }
    public E getFirst()
    {
        Node temp=head;
        return (E) temp.data;
    }
    public E getLast()
    {
        Node temp =head;
        while(temp.next!=null)
            temp=temp.next;
        return (E)temp.data;
    }
    public void clear()
    {
        head=null;
        numNodes=0;
    }
    public void print()
    {
        Node temp =head;
        while(temp!=null) {
            System.out.println(temp.data);
            temp=temp.next;
        }

    }

}
