import java.util.Scanner;

public class test {
    public static void main(String[] args){
        System.out.println("==== 复数运算测试====");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入第一个数的实部");
        Complex first=new Complex();
        first.setReal(sc.nextDouble());
        System.out.println("请输入第一个数的虚部");
        first.setImag(sc.nextDouble());

        System.out.println("请输入第二个数的实部");
        Complex second=new Complex();
        second.setReal(sc.nextDouble());
        System.out.println("请输入第二个数的虚部");
        second.setImag(sc.nextDouble());

        System.out.println("加法测试");
        System.out.println(first+"+"+second+"="+first.add(second));

        System.out.println("减法测试");
        System.out.println(first+"-"+second+"="+first.sub(second));

        System.out.println("乘法测试");
        System.out.println(first+"*"+second+"="+first.mul(second));

        System.out.println("除法测试");
        System.out.println(first+"/"+second+"="+first.div(second));

        System.out.println("比较测试");
        System.out.println(first+"=="+second+"?="+first.equals(second));

        System.out.println("展示哈希值");
        System.out.println(first+":"+"  "+first.hashCode()+second+":"+second.hashCode());

        System.out.println("与其他值转换测试");

        System.out.println("输入任意数字:");
        double num=sc.nextDouble();
        System.out.println(first+"+"+num+"="+first.add(num));
        System.out.println(first+"-"+num+"="+first.sub(num));
        System.out.println(first+"*"+num+"="+first.mul(num));
        System.out.println(first+"/"+num+"="+first.div(num));

        System.out.println("构造测试");
        int test=10;
        Complex result=new Complex(test);
        System.out.println("int: "+result);

        byte test2=10;
        Complex result2=new Complex(test2);
        System.out.println("byte: "+result2);

        float test3=10.0f;
        Complex result3=new Complex(test3);
        System.out.println("float: "+result3);

    }


}
