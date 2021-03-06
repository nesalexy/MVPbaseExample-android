package com.example.testmoduleapp.di

import android.app.Application
import com.example.testmoduleapp.App
import com.example.testmoduleapp.di.modules.ActivityBindingModule
import com.example.testmoduleapp.di.modules.MainModule
import com.example.testmoduleapp.ui.activities.main.MainActivity
import com.example.utilities.di.UtilsComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
            modules = [
                    AndroidInjectionModule::class,
                    ActivityBindingModule::class,
                    MainModule::class // test module
            ],
            dependencies = [UtilsComponent::class]

    )

@AppScope
interface AppComponent: AndroidInjector<App> {
    // inject to ...
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun utilsComponent(utilsComponent: UtilsComponent): AppComponent.Builder

        fun build(): AppComponent
    }
}