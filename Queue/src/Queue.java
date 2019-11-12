public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    //进队
    void enqueue(E e);
    //出对
    E dequeue();
    //获取队首元素
    E getFront();
}
