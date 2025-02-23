package edu.sharedProject

fun main(args: Array<String>) {
    println("Введите цвет детали, которую хотите добавить в корзину. Список представлен ниже:")
    Color.entries.forEach {
        println("    ${it.ruTerm}")
    }
    println("Место для ввода:")
    val colorStr = readln()
    
    runCatching<Color>() {
        Color.entries.find { it.ruTerm == colorStr }  
            ?: throw IllegalStateException()
    }
        .onFailure {
            println("К сожалению, введённый вами цвет `${colorStr}` является недействительным. Попробуйте ещё раз.")
        }
        .onSuccess { color ->
            val cost = Starter.calculateCost(color)
            println("Общая сумма: $cost")
        }
}

class Starter {
    companion object {
        const val BASE_COST: Double = 12000.0

        fun calculateCost(color: Color): Long {
            return (BASE_COST * color.factor).toLong()
        }
    }
}
