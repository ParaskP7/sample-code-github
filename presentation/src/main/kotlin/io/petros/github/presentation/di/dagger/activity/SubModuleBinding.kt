package io.petros.github.presentation.di.dagger.activity

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import io.petros.github.presentation.feature.navigator.ActivityLauncher
import io.petros.github.presentation.feature.navigator.ActivityNavigator
import io.petros.github.presentation.feature.navigator.Launcher
import io.petros.github.presentation.feature.navigator.Navigator

@Module
interface SubModuleBinding<in Activity : AppCompatActivity> {

    @Binds
    fun bindActivity(activity: Activity): AppCompatActivity

    @Binds
    fun bindNavigator(navigator: ActivityNavigator): Navigator

    @Binds
    fun bindLauncher(launcher: ActivityLauncher): Launcher

}
