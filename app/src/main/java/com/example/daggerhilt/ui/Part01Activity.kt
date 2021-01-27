package com.example.daggerhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.daggerhilt.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Part01Activity : AppCompatActivity() {

    //Constructor Injection,Field Injection

    /**NOTE: Field Injection*/
    @Inject
    lateinit var someClass1: SomeClass1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part01)

        Toast.makeText(this, someClass1.doThing(), Toast.LENGTH_SHORT).show()


        Toast.makeText(this, someClass1.doThing2(), Toast.LENGTH_SHORT).show()

    }


}

class SomeClass1
@Inject
constructor(
    private val someClass2: SomeClass2
    /**NOTE: Constructor Injection*/
){
    fun doThing():String{
        return "SomeClass1: Test!"
    }

    fun doThing2():String{
        return someClass2.doThing()
    }
}

class SomeClass2/**We gonna pass this class as a dependency to SomeClass1*/
@Inject
constructor(){
    fun doThing():String{
        return "SomeClass2: Test!"
    }
}