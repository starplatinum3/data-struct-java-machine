package top.starp.single;

public class Singleton {

    String name="11";
    private  static  class BuildIn{
       static Singleton INSTANCE=new Singleton();
    }
   public  static Singleton getINSTANCE(){
        return BuildIn.INSTANCE;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getINSTANCE();
        System.out.println(instance.name);
    }
}
