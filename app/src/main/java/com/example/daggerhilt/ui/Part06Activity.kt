package com.example.daggerhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.daggerhilt.R
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

@AndroidEntryPoint
class Part06Activity : AppCompatActivity() {
    @Inject
    lateinit var someClass10: SomeClass10

    /**NOTE:
     * what happened if 2 different implementations that same interface,2object of same type but they have 2 different properties
     * so how we tell hilt which one to inject and where*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part06)

        Toast.makeText(this, someClass10.doAThing(), Toast.LENGTH_SHORT).show()
        Toast.makeText(this, someClass10.doAThing2(), Toast.LENGTH_SHORT).show()
    }
}



class SomeClass10
@Inject
constructor(
    @Impl1 private  val someInterface4: SomeInterface4,
    @Impl2 private  val someInterface5: SomeInterface5,

    ){
    fun doAThing():String{
        return "Look I Got ${someInterface4.getAThing()}"

    }
    fun doAThing2():String{
        return "Look I Got ${someInterface5.getAThing()}"

    }
}

class SomeInterfaceImpl4
@Inject
constructor(
): SomeInterface4 {
    override fun getAThing(): String {
        return "A Thing "
    }
}

class SomeInterfaceImpl5
@Inject
constructor(
): SomeInterface5 {
    override fun getAThing(): String {
        return "A Thing "
    }
}

interface SomeInterface4{
    fun getAThing():String
}

interface SomeInterface5{
    fun getAThing():String
}


@InstallIn(ApplicationComponent::class)
@Module
class MyModule3{

    @Singleton
    @Provides
    @Impl1
    fun provideSomeInterface():SomeInterface4{
        return SomeInterfaceImpl4()
    }

    @Singleton
    @Provides
    @Impl2
    fun provideSomeInterface2():SomeInterface5{
        return SomeInterfaceImpl5()
    }


}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl2


