@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String{
    if (age%10==1){
        if (age==11) return "$age лет"
        else return "$age год"
    }
    if (age%100==1){
        if (age==111) return "$age лет"
        else return "$age год"
    }
    if (age%10==2){
        if (age==12) return "$age лет"
        else return "$age года"
    }
    if (age%100==2){
        if (age==112) return "$age лет "
        else return "$age года"
    }
    if (age%10==3){
        if (age==13) return "$age лет"
        else return "$age года"
    }
    if (age%100==3){
        if (age==113) return "$age лет"
        else return "&age года"
    }
    if (age%10==4){
        if (age==14) return "$age лет"
        else return "$age года"
    }
    if (age%100==4){
        if (age==114) return "$age лет"
        else return "$age года"
    }
    return "$age лет"

}







/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double{
    val s1=t1*v1
    val s2=t2*v2
    val s3=t3*v3
    val s_sred=(s1+s2+s3)/2
    return if (s_sred<=s1) s_sred/v1
    else if((s_sred>s1)&&(s_sred<=s1+s2)) t1+((s_sred-s1)/v2)
    else t1+t2+((s_sred-s1-s2)/v3)
}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    if ((kingX==rookX1) || (kingY==rookY1)){
        if ((kingX==rookX2)||(kingY==rookY2)) return 3
        else return 1
    }
    if ((kingX==rookX2)||(kingY==rookY2)){
        if ((kingX==rookX1)||(kingY==rookY2)) return 3
        else return 2
    }

    else return 0
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int{
    if((kingX==rookX)||(kingY==rookY)){
        if((Math.abs(kingX-bishopX)==(Math.abs(kingY-bishopY)))) return 3
        else return 1
    }
    if(Math.abs(kingX-bishopX)==(Math.abs(kingY-bishopY))) {
        if((kingX==rookX)||(kingY==rookY)) return 3
        else return 2
    }
    else return 0
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    if ((a + b > c) && (a + c > b) && (a < b + c)) {
        if ((a > b) && (a > c)) {
            if ((sqr(b) + sqr(c)) > sqr(a)) return 0
            if ((sqr(b) + sqr(c)) < sqr(a)) return 2
            if ((sqr(b) + sqr(c)) == sqr(a)) return 1
        }
        if ((b > a) && (b > c)) {
            if ((sqr(a) + sqr(c)) > sqr(b)) return 0
            if ((sqr(a) + sqr(c)) < sqr(b)) return 2
            if ((sqr(a) + sqr(c)) == sqr(b)) return 1
        }
        if ((c > a) && (c > b)) {
            if ((sqr(b) + sqr(a)) > sqr(c)) return 0
            if ((sqr(b) + sqr(a)) < sqr(c)) return 2
            if ((sqr(b) + sqr(a)) == sqr(c)) return 1
        }
        if ((a == b) && (a == c)) return 0
        if ((a == b) && (a > c)) return 0
        if ((b > a) && (b == c)) return 0
        return -1
    } else return -1
}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int{
    if((b>=c)&&(d>a)&&(c>a)&&(b<d)) return b-c
    if ((a>c)&&(b>d)&&(d>a)) return d-a
    if ((d>d)&&(a<c)) return d-c
    if((c<=a)&&(d>=b)) return b-a
    if((b>d)&&(a<c)) return d-c
    if((b<c)&&(d>a)) return -1
    if((a>d)&&(b>c)) return -1
 else return 0
}
