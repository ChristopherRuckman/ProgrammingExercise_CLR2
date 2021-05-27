package com.example.programmingexercise_clr

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.programmingexercise_clr.model.ShoppingBag

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class Testing {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.shopping", appContext.packageName)
    }


    fun getPackageFiltersForWidget() {
        val list: ArrayList<ShoppingBag> = ArrayList()
        `when`(storageHelper.getListFromDb()).thenReturn(list)
        runBlocking {
            presenter.getListOfThings()
        }

    }
//    -- PRESENTER
    suspend fun getListOfThings() {
        asyncTask { storageHelper.getListFromDb() }.await()
            .let { list ->
                view.useTheResult(list)
            }
    }

    fun <T> asyncTask(function: () -> T): Deferred<T> {
        return async(CommonPool) { function() }
    }
//    -- ACTIVITY
    fun getList() {
        launch(Android) {
            presenter.getListOfThings()
        }
    }
}
