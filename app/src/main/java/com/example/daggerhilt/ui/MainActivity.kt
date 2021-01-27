package com.example.daggerhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerhilt.R
import com.example.daggerhilt.adapter.MainAdapter
import com.example.daggerhilt.model.InfoMain
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = MainAdapter(this, getData())
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(this)


    }



    private fun getData(): List<InfoMain> {
        val data = listOf<InfoMain>(
            InfoMain("Part01:Constructor Injection,Field Injection"),
            InfoMain("Part02:Scoping With Hilt"),
            InfoMain("Part03:Issues of dagger hilt"),
            InfoMain("Part04:Modules, Binds and Provides,Part01"),
            InfoMain("Part05:Modules, Binds and Provides,Part02"),
            InfoMain("Part06:Providing instance of the same type"),
        )
        return data
    }



}