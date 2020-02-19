package com.vandana.nasapictures.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.vandana.nasapictures.NasaPictureApplication
import com.vandana.nasapictures.di.component.ActivityComponent
import com.vandana.nasapictures.di.component.DaggerActivityComponent
import com.vandana.nasapictures.di.module.ActivityModule
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setupView(savedInstanceState)
        viewModel.onCreate()
    }





    private fun buildActivityComponent() =
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as NasaPictureApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()


    fun showMessage(message: String) = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    //to setup the UI
    @LayoutRes
    protected abstract fun provideLayoutId() : Int

    protected abstract fun setupView(savedInstanceState: Bundle?)

    //to inject dagger dependencies
    protected abstract fun injectDependencies(activityComponent: ActivityComponent)
}