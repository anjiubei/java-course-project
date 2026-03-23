public class Complex implements Comparable<Complex>{
    private double real;
    private double imag;

    //构造方法
   public Complex(double real,double imag){
        this.real = real;
        this.imag = imag;
    }
    public Complex(){
        this(0,0);
    }
    public Complex(double real){
        this(real,0);
    }
    //加法
    public Complex add(Complex c){
       return new Complex(real+c.real,imag+c.imag);
    }
    public Complex add(double real){
       return new Complex(real+this.real,this.real);
    }
    //减法
    public Complex sub(Complex c){
       return new Complex(real-c.real,imag-c.imag);
    }
    public Complex sub(double real){
       return new Complex(this.real-real,this.imag);
    }
    //乘法
    public Complex mul(Complex c){
       double r=this.real*c.real-this.imag*c.imag;
       double i=this.real*c.imag+this.imag*c.real;
       return new Complex(r,i);
    }
    public Complex mul(double x){
       return new Complex(this.real*x,this.imag*x);
    }
    //除法
    public Complex div(Complex c){
       double denominator=c.real*c.real+c.imag*c.imag;
       double r=(this.real*c.real+this.imag*c.imag)/denominator;
       double i=(this.imag*c.real-this.real*c.imag)/denominator;
       return new Complex(r,i);
    }
    public Complex div(double x){
       return new Complex(this.real/x,this.imag/x);
    }
    //将该对象与另一对象比较，同为Complex类且其real和imag值相等时，返回true
    @Override
    public boolean equals(Object o){
       if(this==o) return true;
       if(o instanceof Complex){
           Complex temp=(Complex)o;
           return temp.real==this.real &&temp.imag==this.imag;
       }
       return false;
    }
    //返回当前对象的符合复数表示的字符串
    @Override
    public String toString(){
       if(this.imag==0){
           return this.real+"";
       }
       if(this.real==0){
           return this.imag+"";
       }
       if(this.imag<0){
           return this.real+""+this.imag+"i";
       }else{
           return this.real+"+"+this.imag+"i";
       }
    }
    //比较两个复数的模长大小
    @Override
    public int compareTo(Complex anotherComplex){
       double modulusOfThis=Math.pow(this.real*this.real+this.imag*this.imag,2);
       double modulusOfAnother=Math.pow(anotherComplex.real*anotherComplex.real+anotherComplex.imag*anotherComplex.imag,2);
       return modulusOfThis==modulusOfAnother?0:(modulusOfThis<modulusOfAnother?-1:1);
    }

    @Override
    public int hashCode(){
        int result=Double.hashCode(this.real);
        result=result*31+Double.hashCode(this.imag);
        return result;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }
}
