interface resume{

    void biodata();
}
class teacher implements resume{
    String name,qu,ac;
    String exp;
    public void biodata(){
        name="cy";
        qu="teacher";
        ac="award";
        exp="10.4f";
        System.out.println("teacher resume");
        System.out.println("name"+ name);
        System.out.println("qu"+qu);
        System.out.println("ac"+ac);
        System.out.println("exp"+exp);

    }
}
class student implements resume{
    String name,qu,ac;
    String exp;
    public void biodata(){
        name="cy";
        qu="teacher";
        ac="award";
        exp="10.4f";
        System.out.println("teacher resume");
        System.out.println("name"+ name);
        System.out.println("qu"+qu);
        System.out.println("ac"+ac);
        System.out.println("exp"+exp);

    }
}
public class interfacep {
    public static void main(String arg[]){
        teacher obj1=new teacher();
        obj1.biodata();
        student obj2=new student();
        obj2.biodata();

    }
}
