public class setPrint {
    public static void main(String[] args) {
        Integer a =Integer.valueOf(100);
        Integer b =Integer.valueOf(100);
        System.out.println(a==b);  // true ,缓冲池引用相同
        Integer c =Integer.valueOf(999);
        Integer d =Integer.valueOf(999);
        System.out.println(c==d);  // false ,新的不同的对象

    }
    public static void test() {
        try {
            System.exit(1);
        } finally {
            System.out.println("finally被执行");
        }
    }

}
