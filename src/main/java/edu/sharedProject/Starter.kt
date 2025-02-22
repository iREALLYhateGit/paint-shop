package edu.sharedProject

import java.util.Scanner


fun main(args : Array<String>)
{
    println("Enter the spare part of car, that you want to paint.")
    SparePart.entries.forEach { print(it.toString() + " in ru term: " + it.ruTerm + "\n") }
    println("Place to enter:")
    val scanner = Scanner(System.`in`)
    val sparePart : SparePart? = try {
        SparePart.valueOf(scanner.nextLine())
    } catch (ex : IllegalStateException)
    {
        null
    }
    val cost = sparePart?.let { Starter.calculateCostWithDeclaredSparePart(it) }
    println("Total cost: $cost")
}

class Starter
{

    companion object
    {
        private const val baseCost : Double = 12000.0
        fun getBaseCost() : Double { return baseCost }

        fun calculateCostWithDeclaredSparePart(sparePart: SparePart) : Long
        {
            return (getBaseCost()*sparePart.factor).toLong()
        }
    }

}