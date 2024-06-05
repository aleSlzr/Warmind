package com.aliaslzr.warmind.utils

interface Mapper<I, O, AA> {
    fun transform(input: I, additionalArg: AA? = null): O
}
