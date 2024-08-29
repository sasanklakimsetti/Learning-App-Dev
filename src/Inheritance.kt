fun main(){
    val child=Child()
    child.myMethod()
    val parent=Parent()
    parent.myMethod()
    println()
    println()
    val curvv=Tata()
    curvv.detailsOfCar()
    println()
    println()
    val oneplus=Oneplus("Oneplus")
    oneplus.powerOff()
    oneplus.makeCall()
    oneplus.display()
}
// open before class is for inheritance by child
open class Parent{
    // open before val is for overriding the val with same name in child class
    open val name:String=" "
    open val age:Int=16
    // open before fun is for overriding the fun with same name in child class
    open fun myMethod(){
        System.out.println("I'm in Parent")
    }
}
class Child:Parent(){
    // override before val is for overriding the val which was already present in Parent class
    override val name:String=" "
    override val age:Int=6
    // override before fun is for overriding the fun which was already present in Parent class
    override fun myMethod(){
        System.out.println("I'm in Child")
    }
}

// example for Inheritance of classes and objects
open class Cars{
    open val name:String=" "
    open val mileage:Int=50
    open val seatingCapacity:Int=4
    open val type:String=" "
    open fun detailsOfCar(){
        System.out.println("Car Name: "+name)
        System.out.println("Mileage: "+mileage)
        System.out.println("Seating Capacity: "+seatingCapacity)
        System.out.println("Type: "+type)
    }
}
class Tata:Cars(){
    override val name:String="Curvv"
    override val mileage:Int=50
    override val seatingCapacity:Int=4
    override val type:String="Coupe EV"
    override fun detailsOfCar(){
        System.out.println("Car Name: "+name)
        System.out.println("Mileage: "+mileage)
        System.out.println("Seating Capacity: "+seatingCapacity)
        System.out.println("Type: "+type)
    }
}

open class Mobile(val type:String){
    open val name:String=" "
    open val size:Int=5
    fun makeCall()=println("Calling from mobile")
    fun powerOff()=println("Shutting down")
    open fun display()=println("Simple Mobile Display")
}
class Oneplus(typeParam:String):Mobile(typeParam){
    override fun display()=println("Oneplus display")
    override val name:String="Oneplus"
    override val size:Int=5
}