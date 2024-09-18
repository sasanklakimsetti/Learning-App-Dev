fun main(){
    var animal1=Animal("Cat",4,true)
    animal1.details()
    var bird1=Bird("Peacock",2,"Ground")
    bird1.birdDetails()
}
// primary constructor
class Animal(var name:String, var legs:Int, var tail:Boolean){
    fun details(){
        println("Name: $name")
        println("No.of legs: $legs")
        print("Tail: ")
        if(tail) println("Yes") else println("No")
    }
}
// secondary constructor
class Bird{
    var name:String
    var legs:Int
    var airHeight:String
    constructor(name: String,legs: Int,airHeight:String){
        this.name=name
        this.legs=legs
        this.airHeight=airHeight
    }
    fun birdDetails(){
        println("Name of the bird: $name")
        println("No.of legs: $legs")
        println("Air Height: $airHeight")
    }
}