package com.kamaltata.shimmerapp.tgreefragment

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.kamaltata.shimmerapp.BasePresenterImpl
import com.kamaltata.shimmerapp.firstfragment.ThreeContract
import kotlin.concurrent.thread

class ThreePresenter : BasePresenterImpl<ThreeContract.Screen>(), ThreeContract.Presenter {

    override fun requestData() {
        thread(true) {
            val data = mutableListOf<String>()
            for (i in 0..20) {
                Thread.sleep(100)  //имитация загрузки из сети
                data.add("Данные $i")
            }
            Handler(Looper.getMainLooper()).post {
                screen?.showData(data)
            }
        }
    }
}