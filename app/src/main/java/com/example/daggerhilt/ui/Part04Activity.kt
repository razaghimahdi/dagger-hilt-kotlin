package com.example.daggerhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.daggerhilt.R
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class Part04Activity : AppCompatActivity() {

    /**NOTE: We cannot use interface injected to our constructor then we can use module
     * we have 2 type of module: @Binds, @Provides
     * which @Provides is easier
     * */

    @Inject
    lateinit var someClass8: SomeClass8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part04)

        Toast.makeText(this, someClass8.doAThing(), Toast.LENGTH_SHORT).show()
    }
}

class SomeClass8
@Inject
constructor(
     private  val someInterface2: SomeInterface2,
     //private val gson:Gson //gets compile error
){
    fun doAThing():String{
         return "Look I Got ${someInterface2.getAThing()}"

    }
}

class SomeInterfaceImpl2
@Inject
constructor(): SomeInterface2 {
    override fun getAThing(): String {
        return "A Thing"
    }
}

interface SomeInterface2{
    fun getAThing():String
}


@InstallIn(ActivityComponent::class)
@Module
abstract class MyModule{
    @ActivityScoped
    @Binds
    abstract fun bindSomeDependnecy(
        someInterfaceImpl2: SomeInterfaceImpl2
    ): SomeInterface2

    /*@ActivityScoped
    @Binds
    abstract fun bindGson(
        gson: Gson
    ):Gson*///gets compile error


}
