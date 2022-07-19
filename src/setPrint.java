import java.util.HashSet;
import java.util.Set;

public class setPrint {
    public static void main(String[] args) {
        Set<String> s=new HashSet<>();
        s.add("张三");
        s.add("张三");
        s.add("张三");
        s.add("张1");
        s.add("张2");
        s.add("张3");
        String nameList = s.toString();
        nameList = nameList.substring(1, nameList.length() - 2);
        System.out.println(nameList);

        Integer a =Integer.valueOf(100);
        Integer b =Integer.valueOf(100);
        System.out.println(a==b);  // true ,缓冲池引用相同
        Integer c =Integer.valueOf(999);
        Integer d =Integer.valueOf(999);
        System.out.println(c==d);  // false ,新的不同的对象
    }
}
