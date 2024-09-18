fun main(){
    var india=India()
    india.viewDetails()
}
open class Country{
    open var name:String=" "
    open var capital:String=" "
    open var currency:String=" "
    open var primeMinister:String=" "
    open fun viewDetails(){
        println("Name: $name")
        println("Capital: $capital")
        println("Currency: $currency")
        println("Prime Minister: $primeMinister")
    }
}
class India:Country(){
    override var name:String="India"
    override var capital:String="New Delhi"
    override var currency:String="Rupee"
    override var primeMinister:String="Narenda Modi"
}