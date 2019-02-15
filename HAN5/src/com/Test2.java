package com;

/**
 * Author:Fanleilei
 * Created:2019/2/15 0015
 */
public class Test2 {

    public static void main(String[] args) {

        Computer computer=new Computer();
        //多态的一种实现方法
        Usb udisk=new UDisk();
        computer.plugin(udisk);
        System.out.println("------------------");
        Usb keyboard=new KeyBoard();
        computer.plugin(keyboard);
    }

}

interface  Usb{

    //安装驱动-设备厂商提供
    void setup();
    //设备工作
    void work();
}

class Computer{

    public void plugin(Usb usb){
        usb.setup();
        usb.work();

    }
}


class UDisk implements  Usb{


    @Override
    public void setup() {
        System.out.println("安装U盘的驱动程序");
    }

    @Override
    public void work() {
        System.out.println("通过U盘与计算机之间进行数据传输");
    }
}

class KeyBoard implements  Usb{


    @Override
    public void setup() {
        System.out.println("安装键盘的驱动程序");
    }

    @Override
    public void work() {
        System.out.println("通过键盘操作计算机");
    }
}