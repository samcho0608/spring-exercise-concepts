package com.samcho.springexercise.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
//@Component
class TimeTraceAop {

    // since the specified path below includes initialization of AOP instance within Configuration class, we must exclude that class to avoid cyclical dependency
    @Around("execution(* com.samcho.springexercise..*(..)) && !target(com.samcho.springexercise.SpringExerciseConfig)")
//    @Around("execution(* com.samcho.springexercise..*(..))")
    fun execute(jointPoint: ProceedingJoinPoint): Any? {
        val start = System.currentTimeMillis()
        println("START: $jointPoint")
        try {
            return jointPoint.proceed()
        } finally {
            val finish = System.currentTimeMillis()
            val timeMs = finish - start
            println("END: $jointPoint $timeMs ms")
        }
    }
}