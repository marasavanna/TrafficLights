package com.example.trafficlights.carInput

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class CarInputViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: CarInputViewModel

    @Before
    fun setUp() {
        viewModel = CarInputViewModel()
    }

    @Test
    fun `check cardModel is not valid when empty`() = runTest {
        viewModel.isCarModelValid.observeForever { }
        viewModel.carModel.value = ""
        assert(viewModel.isCarModelValid.value == false)
    }

    @Test
    fun `check cardModel is not valid when null`() = runTest {
        viewModel.isCarModelValid.observeForever { }
        viewModel.carModel.value = null
        assert(viewModel.isCarModelValid.value == false)
    }

    @Test
    fun `check cardModel is not valid when length is less than 3`() = runTest {
        viewModel.isCarModelValid.observeForever { }
        viewModel.carModel.value = "ab"
        assert(viewModel.isCarModelValid.value == false)
    }

    @Test
    fun `check cardModel is valid when length is 3`() = runTest {
        viewModel.isCarModelValid.observeForever { }
        viewModel.carModel.value = "abd"
        assert(viewModel.isCarModelValid.value == true)
    }

    @Test
    fun `check cardModel is valid when length is greater than 3`() = runTest {
        viewModel.isCarModelValid.observeForever { }
        viewModel.carModel.value = "abdefgcckkk"
        assert(viewModel.isCarModelValid.value == true)
    }
}