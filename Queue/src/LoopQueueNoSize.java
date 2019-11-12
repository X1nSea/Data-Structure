public class LoopQueueNoSize<E> implements Queue<E> {
    private E data[];
    private int front,tail;

    public LoopQueueNoSize(int capacity){
        data = (E[])new Object[capacity+1];
        front=0;
        tail=0;
    }

    public LoopQueueNoSize(){
        this(10);
    }

    @Override
    public int getSize() {
        return ((tail-front+data.length)%data.length);
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }

    @Override
    public void enqueue(E e) {
        if(front == (tail+1)%data.length)
            resize(getCapacity()*2);
        data[tail] = e;
        tail = (tail+1) % data.length;
    }

    /**
     * 思考后，仍未想通如何采用从队首到队尾的方式来进行扩容
     * 例如： for(int i = front;i != tail; i=(i+1)%data.length)
     * 这种循环中，如何来定位新数组和旧数组对应的元素关系，并同时能满足扩容和缩容两种模式
     * 如果后续有想法，会进行这里的更新，也希望大佬多多给予意见 :)
     * @param newCapacity 指定新的容量
     */
    private void resize(int newCapacity){
        E newData[] = (E [])new Object[newCapacity+1];
        int sz = getSize();
        for(int i = 0;i < sz;i++){
            newData[i] = data[(i+front)%data.length];
        }
        data = newData;
        front = 0;
        tail = sz;
    }

    @Override
    public E dequeue() {
        if (front == tail)
            throw new IllegalArgumentException("Cannot dequeue from a empty queue");
        E ret = data[front];
        data[front] = null;
        front = (front+1) % data.length;

        if(getSize() == getCapacity()/4 && getCapacity()/2 != 0)
            resize(getCapacity()/2);
        return ret;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue[Size : %d , Capacity : %d]\n",getSize(),getCapacity()));
        res.append("front:[");
        for(int i = 0;i < getSize();i++){
            res.append(data[(i+front)%data.length]);
            if(i != getSize()-1)
                res.append(",");
        }
        res.append("] tail");
        return res.toString();
    }

}
