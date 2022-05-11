package com.sary.task.core.arch

abstract class BaseUseCase<I, O> {
    abstract fun execute(input: I?): O
}