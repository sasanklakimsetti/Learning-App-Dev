fun main(){
    // while loop
    var num=5
    while(num<=10) {
        println(num)
        num++
    }
    // do while loop
    do{
        println(num)
        num++
    }while(num<=20)

    // for loop
    for(i in 1..10) println(i) // .. acts as inclusive range
    for(i in 1..10 step 3) println(i) //step acts as iterator operation like i+=2,i+=3
    for(i in 1 until 10) println(i) // until acts as range where upper limit is exclusive
    for(i in 10 downTo 1) println(i)
    // printing a table using for loop
    val n=10
    for(i in 1..10){
        println(n.toString()+" x "+i+" = "+(n*i))
    }
    //using dollar sign
    for(i in 1..10){
        println("$n * $i = ${n*i}")
    }
}