package com.mathiasbrandt.aphelion.di

import com.mathiasbrandt.aphelion.fragments.ConversationsListFragment
import com.mathiasbrandt.aphelion.viewmodels.ConversationDetailsViewModel
import com.mathiasbrandt.aphelion.viewmodels.ConversationsViewModel
import dagger.Component
import javax.inject.Singleton

/**
The component is used to connect objects to their dependencies,
typically by use of overridden inject() methods.

In order to use the component, it must be accessible from the parts of the app that need injection.
Typically, that will happen from the app Application subclass
 */
@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(target: ConversationsListFragment)
    fun inject(target: ConversationsViewModel)
    fun inject(target: ConversationDetailsViewModel)
}