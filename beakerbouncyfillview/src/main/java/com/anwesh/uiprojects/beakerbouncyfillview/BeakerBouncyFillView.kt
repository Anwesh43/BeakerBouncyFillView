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

val nodes : Int = 5
val lines : Int = 2
val scGap : Float = 0.02f / (lines + 1)
val strokeFactor : Int = 90
val delay : Long = 20
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#3F51B5")
val backColor : Int = Color.parseColor("#BDBDBD")
