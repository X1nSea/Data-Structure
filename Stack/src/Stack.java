public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    //进栈
    void push(E e);
    //出栈
    E pop();
    //查看栈顶元素
    E peek();
}
