package com;

/**
 * Author:Fanleilei
 * Created:2019/2/15 0015
 */
public class Test1 {

    public static void main(String[] args) {
        MsnMessage msnMessage=new MsnMessage();

        //com.IMessage iMessage=msnMessage;
        IMessage iMessage=  new MsnMessage();

        Platform platform=new MsnMessage();
        System.out.println(iMessage instanceof MsnMessage);//true
        System.out.println(iMessage instanceof IMessage);//true

        //父接口之间的相互转换
        Platform platform1= (Platform) iMessage;//编译、运行都可以通过
        System.out.println(iMessage instanceof Platform);//true


       Combination combination=new QQMessage();
       combination.print();
       combination.supportPlatform();



       QQMessage qqMessage=new QQMessage();
       Platform platform2=new QQMessage();
       IMessage iMessage2=new QQMessage();

       //Company company= (Company) platform2;//编译通过，运行不通过CCE


        System.out.println("------------------");
        //接口继承接口
        Combination qqcombination1=new QQMessage();
        qqcombination1.print();
        qqcombination1.supportPlatform();

        IMessage iMessage3=qqcombination1;//ok,ok
        Platform platform3=qqcombination1;//ok,ok


       //内部静态接口
        System.out.println("------------------");

        C c=new C();
        c.print();

        A.B q1=new C();
        q1.print();

        A.B q2=c;
        q2.print();

    }
}

//1.接口的实现类，要实现接口的抽象方法
//2.接口中定义的方法，默认就是public
//3.接口中定义的变量，实际就是全局常量，默认是public static final
//3.子类可以实现多个接口, 子类的实例化对象可以向上转型成任意接口类型
//4.子类可以继承抽象类（类）, 先extends 再implements
//5.抽象类可以实现接口（多个），接口的方法抽象类可以选择实现，如果抽象类不实现它所实现的接口中抽象方法，则抽象类的子类就必须实现接口中方法
//6.接口不能继承抽象类（类），可以继承接口并且是多继承
//7.一个接口可以使用extends继承多个父接口。
interface IMessage{
    void print();//相当于public abstract void print();

}
interface Platform{
    void supportPlatform();

}

//一个接口可以使用extends继承多个父接口。
interface Combination extends IMessage,Platform{
    void print();
    void supportPlatform();
}
class QQMessage implements Combination{


    @Override
    public void print() {
        System.out.println("这是QQMessage");
    }

    @Override
    public void supportPlatform() {
        System.out.println("QQ支持windows和Macos平台");
    }
}


class MsnMessage implements IMessage, Platform{

    public void print(){
        System.out.println("这是MsnMessage");
    }

    public void supportPlatform(){
        System.out.println("MSN支持 windows");
    }
}

//抽象类可以实现接口（多个）
//继承接口的抽象类可以不实现接口中的抽象方法
abstract class Company implements IMessage,Platform{
    public abstract void printCompany();

    public  void print(){
        System.out.println("这是Company实现的print方法");
    }

}


//接口可以定义一系列的内部结构，包括：内部普通类，内部普通类，内部接口。其中，使用static定义的内部
//接口就相当于一个外部接口

interface A{

    void print();
    //内部接口
    static interface B{

        void print();
    }
}

class C implements A.B{


    @Override
    public void print() {
        System.out.println("这是接口A的内部静态接口B的方法，由C类实现");
    }
}