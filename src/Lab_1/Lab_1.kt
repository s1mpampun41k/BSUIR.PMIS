package Lab_1

import kotlin.math.pow
import java.util.*
import kotlin.math.exp

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите выражение в обратной польской записи, разделяя элементы пробелом:")
    val input = scanner.nextLine()
    val tokens = input.split(" ")
    val stack = mutableListOf<Int>()

    fun cheking(): Boolean {
        if (stack.size < 2) {
            println("Ошибка: недостаточно операндов.")
            return false
        }
        return true
    }

    for (token in tokens) {
        when (token) {
            "+" -> {
                if (cheking()) {
                    val b = stack.removeAt(stack.lastIndex)
                    val a = stack.removeAt(stack.lastIndex)
                    stack.add(a + b)
                } else return
            }
            "-" -> {
                if (cheking()) {
                    val b = stack.removeAt(stack.lastIndex)
                    val a = stack.removeAt(stack.lastIndex)
                    stack.add(a - b)
                } else return
            }
            "*" -> {
                if (cheking()) {
                    val b = stack.removeAt(stack.lastIndex)
                    val a = stack.removeAt(stack.lastIndex)
                    stack.add(a * b)
                } else return
            }
            "/" -> {
                if (cheking()) {
                    val b = stack.removeAt(stack.lastIndex)
                    val a = stack.removeAt(stack.lastIndex)
                    if (b == 0) {
                        println("Ошибка: деление на ноль.")
                        return
                    }
                    stack.add(a / b)
                } else return
            }
            "^" -> {
                if (cheking()) {
                    val b = stack.removeAt(stack.lastIndex)
                    val a = stack.removeAt(stack.lastIndex)
                    stack.add((a.toDouble()).pow(b).toInt())
                } else return
            }
            "exp" -> {
                    val a = stack.removeAt(stack.lastIndex)
                    stack.add(exp(a.toDouble()).toInt())
            }
            "%" -> {
                if (cheking()) {
                    val b = stack.removeAt(stack.lastIndex)
                    val a = stack.removeAt(stack.lastIndex)
                    stack.add(a % b)
                } else return
            }
            else -> {
                try {
                    stack.add(token.toInt())
                } catch (e: NumberFormatException) {
                    println("Ошибка: некорректный токен '$token'.")
                    return
                }
            }
        }
    }

    if (stack.size == 1) {
        println("Результат: ${stack.last()}")
    } else {
        println("Ошибка: некорректное выражение.")
    }
}