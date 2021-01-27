package com.example.daggerhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.daggerhilt.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Part03Activity : AppCompatActivity() {

    @Inject
    lateinit var someClass6: SomeClass6

    @Inject
    lateinit var someClass7: SomeClass7



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part03)

        Toast.makeText(this, someClass6.doThing(), Toast.LENGTH_SHORT).show()

        Toast.makeText(this, someClass7.doAThing(), Toast.LENGTH_SHORT).show()

    }
}

class SomeClass6
@Inject
constructor(
        private val someDependency7: SomeDependency7
){
    fun doThing():String{
        return "${someDependency7.doThing()}"
    }
}

class SomeDependency7
@Inject
constructor(){
    fun doThing():String{
        return "SomeClass7: Test!"
    }
}


class SomeClass7
@Inject
constructor(
        //private  val someInterface1:SomeInterface//We cannot inject interface to constructor or some class which it implemented by interface
){
fun doAThing():String{
    //return "Look I Got ${someInterface1.getAThing()}"
    return "Null Returned, NOTE: We cannot inject interface to constructor "
}
}

class SomeInterfaceImpl
@Inject
constructor(): SomeInterface {
    override fun getAThing(): String {
        return "A Thing"
    }
}

interface SomeInterface{
    fun getAThing():String
}
