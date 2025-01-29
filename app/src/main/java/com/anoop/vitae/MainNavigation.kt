package com.anoop.vitae

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anoop.vitae.ui.screens.ResumeScreen
import com.anoop.vitae.ui.screens.ResumeViewModel
import com.anoop.vitae.ui.theme.VitaeTheme

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val onDefaultBackPress: () -> Unit = { navController.popBackStack() }

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            ResumeScreen(
                modifier = Modifier.padding(VitaeTheme.dimensions.large),
                onBack = onDefaultBackPress
            )
        }
    }
}
