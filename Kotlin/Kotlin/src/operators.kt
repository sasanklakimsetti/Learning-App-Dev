fun main(){
    // var is mutable
    var i=13
    var j=14
    println(i+j)
    println(i-j)
    println(i*j)
    println(i.toFloat()/j)

    println(i>j)
    println(i<j)
    println(i>=j)
    println(i<=j)
    println(i==j)
    println(i!=j)
    println(i++ + ++i)
    //when operator
    val animal="Dog" // val is immutable
    when(animal){
        "Dog"->println("Bow Bow")
        "Cat"->println("Meow")
        "Sheep"->println("Meh")
    }
    if(animal=="Dog") println("It's a dog")
    else println("It's not a Dog")
}