package edu.sharedProject

import java.lang.Thread.sleep

fun main()
{
    println("Hello, this is the paint shop!")

    sleep(500)

    val color : Color = setColor()
    println()
    val sparePart : SparePart = setSparePart()

    val cost = Starter.calculateCost(color, sparePart)

    println("\nTotal cost: $cost")

}

fun setColor() : Color
{
    lateinit var color : Color

    println("Pick the color. The list of the available colors:")
    Color.entries.forEach { println("    ${it.ruTerm}") }
    print("Place to enter: ")

    val colorInput = readln()

    runCatching<Color>() {
        Color.entries.find { it.ruTerm == colorInput }
            ?: throw IllegalStateException()
    }
        .onFailure {
            println("Picked color `${colorInput}` is not present.")
        }
        .onSuccess { chosenColor ->
            color = chosenColor
        }
    return color
}


fun setSparePart() : SparePart
{
    lateinit var sparePart: SparePart

    println("Pick the spare part of car.")
    SparePart.entries.forEach { println("    ${it.ruTerm}") }
    print("Place to enter: ")

    val sparePartInput = readln()
    runCatching<SparePart>() {
        SparePart.entries.find { it.ruTerm == sparePartInput }
            ?: throw IllegalStateException()
    }
        .onFailure {
            println("Picked spare part `${sparePartInput}` is not present.")
        }
        .onSuccess { chosenSparePart ->
            sparePart = chosenSparePart
        }
    return  sparePart
}

class Starter {
    companion object {
        private const val BASE_COST: Double = 12000.0

        fun calculateCost(color: Color, sparePart: SparePart): Long {
            return (BASE_COST * color.factor * sparePart.factor).toLong()
        }
    }
}