@file:Suppress("UNUSED_PARAMETER")
package lesson2.task2

import lesson1.task1.sqr
import lesson4.task1.sqRoots

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean{
    val numb1 = number / 1000
    val numb2 = (number / 100) % 10
    val numb3 = ((number % 1000) / 10) % 10
    val numb4 = (((number % 1000)) % 100) % 10
    if ((numb1 + numb2) == (numb3 + numb4)) return true
    else return false
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    if (x1 == x2) return true
    if (y1 == y2) return true
    return (Math.abs(x1 - x2) == Math.abs(y1 - y2))
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean{
    return ((sqr(x1 - x2) + sqr(y1 - y2) <= sqr(r2)) && (Math.sqrt(sqr(x1 - x2) + sqr(y1 - y2)) + r1 <= r2))
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean{
    var mini1 = 0
    var mini2 = 0
    if ((a <= b) && (a <= c)) {
        mini1 = a
        mini2 = Math.min(b, c)
    }
    if ((b <= a) && (b <= c)) {
        mini1 = b
        mini2 = Math.min(a, c)
    }
    if ((c <= a) && (c <= b)) {
        mini1 = c
        mini2 = Math.min(a, b)
    }
    return ((mini1 <= r) && (mini2 <= s)) || ((mini1 <= s) && (mini2 <= r))
}
