package com.example.daggerhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.daggerhilt.R
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class Part02Activity : AppCompatActivity() {
    //Scoping With Hilt

    @Inject
    lateinit var someClass3: SomeClass3
    @Inject
    lateinit var someClass4: SomeClass4
    //@Inject
    //lateinit var someClass5: SomeClass5//This is NOT Going To Compile, because we doing this in a activity and someClass5 is annotated bt FragmentScoped

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part02)

        Toast.makeText(this, someClass3.doThing(), Toast.LENGTH_SHORT).show()
        Toast.makeText(this, someClass4.doThing(), Toast.LENGTH_SHORT).show()
        //Toast.makeText(this, someClass5.doThing(), Toast.LENGTH_SHORT).show()

    }
}

@AndroidEntryPoint
class myFragment:Fragment(){
    @Inject
    lateinit var someClass: SomeClass3//This is Going To Compile
    @Inject
    lateinit var someClass4: SomeClass4//This is Going To Compile
    @Inject
    lateinit var someClass5: SomeClass5//This is NOT Going To Compile, because we doing this in a activity and someClass5 is annotated bt FragmentScoped


}


@Singleton
class SomeClass3
@Inject
constructor(){
    fun doThing():String{
        return "SomeClass3: Test!"
    }

}

@ActivityScoped
class SomeClass4
@Inject
constructor(){
    fun doThing():String{
        return "SomeClass4: Test!"
    }

}

@FragmentScoped
class SomeClass5
@Inject
constructor(){
    fun doThing():String{
        return "SomeClass5: Test!"
    }

}