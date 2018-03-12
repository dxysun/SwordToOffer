public class TestMethod {

    public static void setValue(String str)
    {
        str = "new value";
        System.out.println("setValue method:" + str);
    }

    public static void setReferenceValue(People p)
    {
        p.setName("new name");
        System.out.println("setReferenceValue method:" + p.getName());
    }
    public static void swapReference(People p1,People p2)
    {
        People p = p1;
        p1 = p2;
        p2 = p;
        System.out.println("swapReference method p1:" + p1.getName());
        System.out.println("swapReference method p2:" + p2.getName());
    }
    public static void main(String[] args)
    {
        String name1 = "old name p1";
        String name2 = "old name p2";
        People p1 = new People(name1);
        People p2 = new People(name2);

        System.out.println("test method in value:");
        System.out.println("before method:" + name1);
        setValue(name1);
        System.out.println("after method:" + name1);
        System.out.println();

        System.out.println("test method in reference:");
        System.out.println("before method:" + p1.getName());
        setReferenceValue(p1);
        System.out.println("after method:" + p1.getName());
        System.out.println();

        System.out.println("test method swap reference:");
        System.out.println("before p1 :" + p1.getName());
        System.out.println("before p2 :" + p2.getName());
        swapReference(p1,p2);
        System.out.println("after p1 :" + p1.getName());
        System.out.println("after p2 :" + p2.getName());

    }
}
class People{

    private String name;

    public People(String name)
    {
        this.name = name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
