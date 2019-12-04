public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }
    //虚拟头结点
    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    //获取链表中元素的个数
    public int getSize(){ return size;}

    //返回链表是否为空
    public boolean isEmpty(){ return  size == 0;}

    //在链表中index的位置来添加节点，该方法不常用，仅做思考练习
    public void add(int index,E e){
        if(index < 0 && index > size){
            throw new IllegalArgumentException("Index is illegal");
        } else {
            Node pre = dummyHead;
            for(int i = 0;i < index;i++){
                pre = pre.next;
            }
//            Node node = new Node(e);
//            node.next = pre.next;
//            pre.next = node;

            pre.next = new Node(e,pre.next);
            size++;
        }
    }

    //在链表头添加新元素e
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        add(0,e);
    }

    //在链表的末尾添加节点
    public void addLast(E e){
        add(size,e);
    }

    //获取链表中第index位置的节点,不常用,仅做思考练习
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        }
        Node cur = dummyHead.next;
        for(int i = 0 ; i < index ; i++)
            cur = cur.next;
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    //查找链表中是否包含某个元素E
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur.next != null){
            if(cur.e == e)
                return true;
            cur = cur.next;
        }
        return false;
    }

    //修改链表中index位置的元素e
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed.Illegal index");
        }
        Node cur = dummyHead.next;
        for(int i = 0 ; i < index ; i++)
            cur = cur.next;
        cur.e = e;
    }

    //删除index位置上的元素，返回删除元素
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed");

        Node pre = dummyHead;
        for(int i = 0 ; i < index ; i++){
            pre = pre.next;
        }
        Node retNode = pre.next;
        pre.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for(Node cur = dummyHead.next ; cur != null ; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");
        return res.toString();
    }

}
