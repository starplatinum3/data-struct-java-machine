package top.starp.copy;

//序列化 java
public class Person implements Cloneable
        , java.io.Serializable {
    public String pname;
    public int page;
    public Address address;

    public Person() {
    }

    public static void testShallowClone() throws Exception {
        Person p1 = new Person("zhangsan", 21);
        p1.setAddress("湖北省", "武汉市");
        Person p2 = (Person) p1.clone();
        System.out.println("p1:" + p1);
        System.out.println("p1.getPname:" + p1.getPname().hashCode());

        System.out.println("p2:" + p2);
        System.out.println("p2.getPname:" + p2.getPname().hashCode());

        p1.display("p1");
        p2.display("p2");
        p2.setAddress("湖北省", "荆州市");
        System.out.println("将复制之后的对象地址修改：");
        p1.display("p1");
        p2.display("p2");
    }

    public static void main(String[] args) throws Exception {
        testShallowClone();
    }

    public Person(String pname, int page) {
        this.pname = pname;
        this.page = page;
        this.address = new Address();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.address = (Address) address.clone();
        return p;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    public void setAddress(String provices, String city) {
        address.setAddress(provices, city);
    }

    public void display(String name) {
        System.out.println(name + ":" + "pname=" + pname + ", page=" + page + "," + address);
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pname='" + pname + '\'' +
                ", page=" + page +
                ", address=" + address +
                '}';
    }
}
