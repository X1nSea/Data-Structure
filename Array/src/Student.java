public class Student {
    private String name;
    private int score;

    public Student(String stuName,int stuScore){
        name=stuName;
        score=stuScore;
    }

    @Override
    public String toString(){
        return String.format("Student(name:%s,score:%d)",name,score);
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Alice",100));
        arr.addLast(new Student("Bob",99));
        arr.addLast(new Student("Charlie",88));
        arr.addLast(new Student("David",77));
        arr.addLast(new Student("Charlie",88));
        System.out.println(arr);
        System.out.println();
        Student removeStu = new Student("Charlie",88);
        arr.removeAll(removeStu);
        //实际上都是重新new出来的对象，所以并不会删除任何元素
        System.out.println(arr);
    }
}
