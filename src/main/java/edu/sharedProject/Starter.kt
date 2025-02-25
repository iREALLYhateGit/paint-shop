package edu.sharedProject

import java.lang.Thread.sleep

fun main()
{
    println("Hello, this is the paint shop!\n")

    sleep(500)

    val color : Color = setColor()
    println()
    val sparePart : SparePart = setSparePart()

    val cost = Starter.calculateCost(color, sparePart)

    println("\nTotal cost: $cost")
}

fun setColor() : Color
{
    println("Pick the color. The list of the available colors:")
    Color.entries.forEach { println("    ${it.ruTerm}") }
    return defColor()
}

fun defColor() : Color
{
    print("Place to enter: ")
    val colorInput = readln()
    return runCatching<Color>() {
        Color.entries.find { it.ruTerm == colorInput }
            ?: throw IllegalStateException()
    }.getOrElse {
        println("Picked color `${colorInput}` is not present.")
        return defColor()
    }
}


fun setSparePart() : SparePart
{
    println("Pick the spare part of car.")
    SparePart.entries.forEach { println("    ${it.ruTerm}") }

    return defSparePart()
}

fun defSparePart() : SparePart
{
    print("Place to enter: ")
    val sparePartInput = readln()
    return runCatching<SparePart>() {
        SparePart.entries.find { it.ruTerm == sparePartInput }
            ?: throw IllegalStateException()
    }.getOrElse {
        println("Picked spare part `${sparePartInput}` is not present.")
        return defSparePart()
    }
}

class Starter {
    companion object {
        private const val BASE_COST: Double = 12000.0

        fun calculateCost(color: Color, sparePart: SparePart): Long {
            return (BASE_COST * color.factor * sparePart.factor).toLong()
        }
    }
}