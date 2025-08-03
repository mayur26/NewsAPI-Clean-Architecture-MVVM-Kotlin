package com.mayur.androidcleanarchitecturemvvm.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.mayur.androidcleanarchitecturemvvm.ui.theme.AndroidCleanArchitectureMVVMTheme
import com.mayur.androidcleanarchitecturemvvm.ui.navigation.NewsNavigation
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCleanArchitectureMVVMTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsNavigation()
                }
            }
        }
    }
}