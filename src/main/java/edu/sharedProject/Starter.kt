package edu.sharedProject

fun main(args: Array<String>) {
    println("Enter the color, you want the spare part of your car to be painted in. The list of available colors:")
    Color.entries.forEach {
        println("    ${it.ruTerm}")
    }
    println("Place to enter:")

    val colorInput = readln()

    var color : Color? = null
    var sparePart : SparePart? = null

    runCatching<Color>() {
        Color.entries.find { it.ruTerm == colorInput }
            ?: throw IllegalStateException()
    }
        .onFailure {
            println("К сожалению, введённый вами цвет `${colorInput}` является недействительным. Попробуйте ещё раз.")
        }
        .onSuccess { chosenColor ->
            color = chosenColor
        }

    println("Enter the spare part of car, that you want to paint.")
    SparePart.entries.forEach { print(it.toString() + " in ru term: " + it.ruTerm + "\n") }
    println("Place to enter:")

    val sparePartInput = readln()
    runCatching<SparePart>() {
        SparePart.entries.find { it.ruTerm == sparePartInput }
            ?: throw IllegalStateException()
    }
        .onFailure {
            println("К сожалению, введённая вами деталь `${colorInput}` является недопустимым вариантом. Попробуйте ещё раз.")
        }
        .onSuccess { chosenSparePart ->
            sparePart = chosenSparePart
        }
    if(color != null && sparePart != null)
    {
        val cost = Starter.calculateCost(color!!, sparePart!!)
        println("Total cost: $cost")
    }
    else
        println("Reenter parameters")

}

class Starter {
    companion object {
        private const val BASE_COST: Double = 12000.0

        fun calculateCost(color: Color, sparePart: SparePart): Long {
            return (BASE_COST * color.factor * sparePart.factor).toLong()
        }
    }
}