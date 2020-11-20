package Design_mode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Prototype {
    public static void main(String[] args) {
        String[] origin = {"Apple", "Pear", "Banana"};
        String[] copy = Arrays.copyOf(origin, origin.length);

    }
}

//class Student implements Cloneable {
//    private int id;
//    private String name;
//    private String score;
//
////    public Object clone() {
////        Student std = new Student();
////        std.id = this.id;
////        std.name = this.name;
////        std.score = this.score;
////        return std;
//
//    public Student copy(){
//        Student std=new Student();
//        std.id = this.id;
//        std.name = this.name;
//        std.score = this.score;
//        return std;
//    }
//}
