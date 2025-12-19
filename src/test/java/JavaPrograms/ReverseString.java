package JavaPrograms;

public class ReverseString
{
    public static void main(String[] args)
    {
        String a= "hi";
        StringBuffer b= new StringBuffer(a);
        b.reverse();
        System.out.println(b);
    }
}