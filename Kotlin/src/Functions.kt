fun main(){
    var sum=add(12,2)
    System.out.println(sum)
    System.out.println(oddOrEven(sum))
    oddOrEven2(sum)
    printMessage(sum)
}
fun add(num1:Int,num2:Int):Int{return num1+num2}
// fun add(num1:Int,num2:Int):Int=num1+num2     short form if the code inside the function is one line
fun oddOrEven(num:Int):String{
    if(num%2==0) return "Even"
    else return "Odd"
}
//void function
fun oddOrEven2(num:Int){
    if(num%2==0) System.out.println("Even")
    else System.out.println("Odd")
}
fun printMessage(num:Int){
    for(i in 1..num) println("Hello $i")
}