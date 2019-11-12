public class Array<E> {

    private int size;
    private E[] data;

    public Array(int capacity) {
        data=(E[])new Object[capacity];
        size=0;
    }
    //无参构造器
    public Array(){
        this(10);
    }

    //获取数组中的元素个数
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 向数组中添加元素
     */
    //在第index位置插入一个新的元素e
    public void add(int index,E e){
        if(index<0||index>size){
            throw new IllegalArgumentException("Add failed.Index is illegal.");
        }
        //当数组达到最多元素时,即可扩容
        if(size==data.length){
            data=resize(2*data.length);
        }
        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

    //向所有元素之后添加一个新的元素
    public void addLast(E e){
        add(size,e);
    }

    //向首位置添加一个新的元素
    public void addFirst(E e){
        add(0,e);
    }

    //获取index位置的元素
    public E get(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        }
        return data[index];
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }
    //修改index位置的元素
    public void set(int index,E e){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Set failed.Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 查找
     * @param e
     */
    //查找数组中是否有元素e
    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if(data[i]==e)
                return true;
        }
        return false;
    }

    //查找数组中元素e的索引，如果索引不存在则返回-1
    public int find(E e){
        for(int i=0;i<size;i++){
            //泛型中的比较采用equals方法,值比较而不是引用比较
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //查找数组中元素e的所有索引,如果索引不存在则数组为空
    public Array findAll(E e){
        Array tmp = new Array(data.length);
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                tmp.addLast(i);
            }
        }
        return tmp;
    }

    /**
     * 删除
     */
    //从数组中删除index位置的元素,返回删除的元素
    public E remove(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Remove failed.Index is illegal");
        }
        E ret = data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        //此处要防止缩减到1时无法创建容量为0的数组
        if(size==data.length/4&&data.length/2!=0){
            data=resize(data.length/2);
        }
        return ret;
    }

    public E removeLast(){
        return remove(size-1);
    }


    //从数组中删除第一个元素值为e的元素
    public void removeElement(E e){
        int index = find(e);
        if(index!=-1)
            remove(index);
    }

    //从数组中删除所有元素值为e的位置
    public void removeAll(E e){
       for(int i=0;i<size;i++){
           if(data[i].equals(e)){
               remove(i);
               i--;
           }else if(i==size){
               break;
           }
       }
    }

    /**
     * 实现动态数组
     * @param newCapacity
     * @return
     */
    public E[] resize(int newCapacity){
        E[] newArr = (E[])new Object[newCapacity];
        for(int i=0;i<size;i++){
            newArr[i]=data[i];
        }
        data = newArr;
        return data;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n",size,data.length));
        res.append('[');
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1){
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }
}
