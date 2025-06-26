fun main() {
    val arr1 = IntArray(size)

// Populate the array using a loop
    for (i in 0 until size) {
        print("Enter value for arr[$i]: ")
        arr1[i] = readLine()!!.toInt()
    }

// Print the array
    println("Array elements: ${arr.joinToString()}")
}