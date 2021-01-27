package com.example.daggerhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.daggerhilt.R
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class Part05Activity : AppCompatActivity() {
    @Inject
    lateinit var someClass9: SomeClass9
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part05)

        Toast.makeText(this, someClass9.doAThing(), Toast.LENGTH_SHORT).show()
    }
}



class SomeClass9
@Inject
constructor(
    private  val someInterface3: SomeInterface3,
    private val gson: Gson
){
    fun doAThing():String{
        return "Look I Got ${someInterface3.getAThing()}"

    }
}

class SomeInterfaceImpl3
@Inject
constructor(
    private val someDependency:String
): SomeInterface3 {
    override fun getAThing(): String {
        return "A Thing and $someDependency"
    }
}

interface SomeInterface3{
    fun getAThing():String
}


@InstallIn(ApplicationComponent::class)
@Module
 class MyModule2{

    @Singleton
    @Provides
    fun provideSomeString():String{
        return "Some String"
    }

    @Singleton
    @Provides
    fun provideSomeInterface(
        someString:String
    ):SomeInterface3{
        return SomeInterfaceImpl3(someString)
    }

    @Singleton
    @Provides
    fun provideGson():Gson{
        return Gson()
    }


}
