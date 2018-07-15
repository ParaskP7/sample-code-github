package io.petros.github.data

import android.content.Context
import android.support.annotation.ColorRes
import android.support.annotation.IntegerRes
import android.support.v4.content.ContextCompat

/* CONTEXT */

fun Context.getLong(@IntegerRes id: Int): Long = resources.getInteger(id).toLong()

fun Context.getColorCompat(@ColorRes resource: Int): Int = ContextCompat.getColor(this, resource)
