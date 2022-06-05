package top.starp.single;

public class SingletonCls {
   static SingletonCls   INSTANCE;
    String name="11";
//    private  static  class BuildIn{
//       static SingletonCls INSTANCE=new SingletonCls();
//    }
   public  static SingletonCls getINSTANCE(){
       synchronized ( SingletonCls.class){
//           锁住整个类还是
//           这样就是访问这个类的时候 其他不能 但是这个方法是。。？
           if (INSTANCE==null) {
               INSTANCE=new SingletonCls();
           }
//      懒汉
           return  INSTANCE;
//        return BuildIn.INSTANCE;
       }

    }

    public  static synchronized SingletonCls getINSTANCESync(){
        if (INSTANCE==null) {
            INSTANCE=new SingletonCls();
        }
//      懒汉
        return  INSTANCE;

//        synchronized ( SingletonCls.class){
////           锁住整个类还是
////           这样就是访问这个类的时候 其他不能 但是这个方法是。。？
//            if (INSTANCE==null) {
//                INSTANCE=new SingletonCls();
//            }
////      懒汉
//            return  INSTANCE;
////        return BuildIn.INSTANCE;
//        }

    }

//    public  static SingletonCls getINSTANCEHunger (){
//        if (INSTANCE==null) {
//            INSTANCE=new SingletonCls();
//        }
////      懒汉
//        return  INSTANCE;
////        return BuildIn.INSTANCE;
//    }

    public static void main(String[] args) {
        SingletonCls instance = SingletonCls.getINSTANCE();
        System.out.println(instance.name);
    }
}
