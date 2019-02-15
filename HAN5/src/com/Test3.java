package com;

/**
 * Author:Fanleilei
 * Created:2019/2/15 0015
 */
public class Test3 {
    public static void main(String[] args) {
        Parking parking=new Parking(7,8);
        Car truck=new Truck();
        Car bus=new Bus();
        Car auto=new Auto();
        Car auto1=new Auto(2,1);
        //Car auto2=new Auto(4,5);//会抛出异常


        parking.park(truck);
        parking.park(bus);
        parking.park(auto);
        parking.park(auto1);
        //parking.park(auto2);
    }



}


interface Car{

    int length();
    int width();
}

class Truck implements Car{


    @Override
    public int length() {
        return 8;
    }

    @Override
    public int width() {
        return 4;
    }

    @Override
    public String toString() {
        return "Truck  length="+length()+" width="+width();
    }
}
class Bus implements Car {

    @Override
    public int length() {
        return 9;
    }

    @Override
    public int width() {
        return 4;
    }

    @Override
    public String toString() {
        return "Bus width="+this.width()+" length="+this.length();
    }

}

class Auto implements Car{
   public  static final int MAX_LENGTH=3;
   public  static final int MAX_WIDTH=3;

   private int length=3;
   private int width=2;

    public Auto() {
    }

    public Auto(int length, int width) {
        if(length>MAX_LENGTH||width>MAX_WIDTH){
            throw new IllegalArgumentException("参数不合法");

        }
        this.length = length;
        this.width = width;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public int width() {
        return this.width;
    }

    @Override
    public String toString() {
        return "Auto width="+this.width()+" length="+this.length();
    }
}

//停车场
class Parking{

    private int standardLength=3;
    private int standardWidth=3;

    public Parking() {
    }

    public Parking(int standardLength, int standardWidth) {
        this.standardLength = standardLength;
        this.standardWidth = standardWidth;
    }

    public void park(Car car){
        if(car.length()<=standardLength&&car.width()<=standardWidth){
            System.out.println(car+"可以停在停车场");

        }else{

            System.out.println(car+"不可以停在停车场");
        }

    }
}