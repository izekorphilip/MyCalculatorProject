import java.util.Scanner

// Data class stores each calculation in the calculator history
data class Calculation(
    // Stores the numeric enteries by the user
    val firstNumber: Double,
    val secondNumber: Double,
    val operation: String,
    val result: Double
)
// Calculator class contains all calculator functions
class Calculator {
    // Function performs simple arithmetics
    fun add(a: Double, b: Double): Double {
        return a + b
    }
    fun subtract(a: Double, b: Double): Double {
        return a - b
    }
    fun multiply(a: Double, b: Double): Double {
        return a * b
    }fun divide(a: Double, b: Double): Double {
        // Prevent division by zero using conditional statement
        return if (b != 0.0) {
            a / b
        } else {
            // Display error message if user tries dividing by zero
            println("Error: Cannot divide by zero.")
            0.0
        }
    }
}
// Main function where program execution starts
fun main() {
    // Scanner object reads user keyboard input
    val scanner = Scanner(System.`in`)
    val calculator = Calculator()
    var continueCalculator = true
    // Mutable collection stores all calculations
    val history = mutableListOf<Calculation>()

    // Display program title
    println("PHILIP ADVANCED CALCULATOR")
// Loop repeats until user decides to stop
    while (continueCalculator) {
        //type your entries
        print("\nEnter first number: ")
        val num1 = scanner.nextDouble()
        print("Enter second number: ")
        val num2 = scanner.nextDouble()

        // Display calculator menu
        println("\nChoose an operation:")
        println("1. Addition (+)")
        println("2. Subtraction (-)")
        println("3. Multiplication (*)")
        println("4. Division (/)")
        println("5. View History")

        print("Enter choice (1-5): ")
        val choice = scanner.nextInt()

        var result = 0.0
        var operation = ""
        // when keyword used to determine selected operation
        when (choice) {

            1 -> {
                // Call add function
                result = calculator.add(num1, num2)
            }
            2 -> {
                result = calculator.subtract(num1, num2)
                operation = "-"
            }
            3 -> {
                result = calculator.multiply(num1, num2)
                operation = "*"
            }
            4 -> {
                result = calculator.divide(num1, num2)
                operation = "/"
            }
            5 -> {
                println("\nCALCULATION HISTORY")

                // Loop through collection and display history
                for (item in history) {

                    // Print stored calculation
                    println(
                        "${item.firstNumber} ${item.operation} ${item.secondNumber} = ${item.result}"
                    )
                }
                // Skip remaining loop code and restart
                continue
            }
            // Runs if invalid menu choice entered
            else -> {
                println("Invalid choice.")
                //restart loop
                continue
            }
        }
// Create Calculation object using entered values
        val calculation = Calculation(
            num1,
            num2,
            operation,
            result
        )
        history.add(calculation)
        println("\nResult: $num1 $operation $num2 = $result")

// Another use of when keyword with conditions
        when {
            // Check if result is greater than 100
            result > 100 -> {
                println("Large result detected!")
            }
            result < 0 -> { println("Negative result detected!")
            }

            result == 0.0 -> {
                println("The result is zero.")
            }

            // Runs if no previous condition is true
            else -> {
                println("Normal result.")
            }
        }
        // Ask user whether to continue
        print("\nDo you want to continue? (yes/no): ")
        val answer = scanner.next()
        if (answer.lowercase() != "yes") {
            continueCalculator = false
        }
    }
    println("\nCalculator closed. Goodbye!")
}