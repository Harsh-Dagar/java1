package classes_and_object;

public class ComplexNumbers {
    private int real;
    private int img;
    public ComplexNumbers(int real,int img){
        this.real=real;
        this.img=img;
    }
    public void plus(ComplexNumbers c){
        this.real=this.real+c.real;
        this.img=this.img+c.img;
    }
    public void multiply(ComplexNumbers c){
        int temp1,temp2;
        temp1=this.real*c.real-this.img*c.img;
        temp2=this.real*c.img+this.img*c.real;
        this.real=temp1;
        this.img=temp2;
    }
    public void print(){
        System.out.println(this.real+" + i"+this.img);
    }
}
