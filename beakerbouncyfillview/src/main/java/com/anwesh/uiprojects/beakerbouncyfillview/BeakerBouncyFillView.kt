package com.anwesh.uiprojects.beakerbouncyfillview

/**
 * Created by anweshmishra on 15/01/20.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Color
import android.graphics.Canvas
import android.graphics.RectF

val nodes : Int = 5
val lines : Int = 2
val scGap : Float = 0.02f / (lines + 1)
val strokeFactor : Int = 90
val delay : Long = 20
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#3F51B5")
val backColor : Int = Color.parseColor("#BDBDBD")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawBeakerBouncyFill(scale : Float, size : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val sc1 : Float = sf.divideScale(0, 2)
    val sc2 : Float = sf.divideScale(1, 2)
    for (j in 0..(lines - 1)) {
        save()
        translate(-size * (1f - 2 * j), size)
        rotate(-90f * (1f - 2 * j) * sc1.divideScale(j, lines))
        drawLine(0f, 0f , 2 * size * (1f - 2 * j), 0f, paint)
        restore()
    }
    save()
    translate(-size, size)
    drawRect(RectF(0f, -2 * size * sc2, 2 * size, 0f), paint)
    restore()
}

fun Canvas.drawBBFNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(w / 2, gap * (i + 1))
    drawBeakerBouncyFill(scale, size, paint)
    restore()
}

class BeakerBouncyFillView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}