public class LoopQueue<E> implements Queue<E> {
    private E data[];
    private int front,tail;
    private int size;

    //循环队列中设定front==tail为空,front==(tail+1)%capacity为满。
    //所以需要浪费一个空间，在new的时候需要+1
    public LoopQueue(int capacity){
        data = (E[])new Object[capacity+1];
        front = 0;
        tail = 0;
        size =0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public void enqueue(E e) {
        if(front == (tail+1) % data.length)
            resize(getCapacity()*2);
        data[tail] = e;
        tail = (tail+1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(front == tail)
            throw new IllegalArgumentException("Cannot dequeue from a empty queue");
        E ret = data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;

        if(size==getCapacity()/4&&getCapacity()/2!=0)
            resize(getCapacity()/2);
        return ret;
    }

    /**
     * 在这个扩容方法中，采用的是将i+front的偏移量来计算旧数组中的每个元素位置。
     * @param newCapacity 指定新的容量
     */
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity+1];
        for(int i = 0; i < size;i++){
            newData[i] = data[(i+front)%data.length];
        }
        data = newData;
        front=0;
        tail=size;
    }

    /**
     * 输出时，for循环采用从队首到队尾的方式。
     * @return
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue[Size: %d ,Capacity: %d]\n",size,getCapacity()));
        res.append("front [");
        for(int i = front; i!=tail;i=(i+1)%data.length){
            res.append(data[i]);
            if(i+1!=tail)
                res.append(",");
        }
        res.append("] tail");
        return  res.toString();
    }
}
