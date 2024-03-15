package com.android.weemarvel.common.base

interface Mapper<F,T> {
    fun mapFrom(from:F):T
}