package com.gitTraining

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Test

class FibbonaciEfficientArrayTest {
    @Test
    fun fibbonaci_efficient_array_works_for_small_range() {
        // TODO: Test the negative ranges
        val inputs = (1..10)
        val expectedOutputs = inputs.map { computeFibonacciNumber(it) }
        val outputs = computeFibonacciArray(1, 10, true)
        for ((output, expectedOutput) in outputs.zip(expectedOutputs)) {
            assertThat(output).isEqualTo(expectedOutput)
        }
    }
}
