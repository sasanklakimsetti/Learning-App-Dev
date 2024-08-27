// two types of constructor: primary, secondary
// primary constructor: defined just after the name of the class
// secondary constructor: defined inside the body of the class

// example of primary constructor
class Automobile(var name: String, var noOfTyres:Int, val maxSeating:Int){
    fun vehicleDetails(){
        System.out.println("Type: "+name )
        System.out.println("No.of tyres: "+noOfTyres)
        System.out.println("Seat Capacity: "+maxSeating)
    }
}
class Car(val name:String, val type:String, val kmRan:Int){
    fun driveCar(){System.out.println("You are driving a "+name)}
    fun applyBrakes(){
        System.out.println("Brakes applied")
    }
}
// empty constructor
class Empty(){}
// example of a secondary constructor
class Person{
    var name:String
    var age:Int
    var gender:Char
    constructor(name:String,age:Int,gender:Char){
        this.name=name
        this.age=age
        this.gender=gender
    }
    fun printDetails(){
        System.out.println("Name: "+name)
        System.out.println("Age: "+age)
        System.out.println("Gender: "+gender)
    }
}
fun main(){
    var vehicle1=Automobile("Car",4,7)
    vehicle1.vehicleDetails()
    var vehicle2=Automobile("Bike",2,2)
    vehicle2.vehicleDetails()
    var car2=Car("Volkswagen","Sedan",40)
    car2.driveCar()
    car2.applyBrakes()
    System.out.println(car2.name)
    var person1=Person("Sasank",19,'M')
    person1.printDetails()}