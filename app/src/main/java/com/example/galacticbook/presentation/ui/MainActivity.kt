package com.example.galacticbook.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.galacticbook.domain.GalacticViewModel
import com.example.galacticbook.model.CharacterDetailsScreenRoute
import com.example.galacticbook.model.HomeScreenRoute
import com.example.galacticbook.presentation.theme.GalacticBookTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            GalacticBookTheme {
                val navController = rememberNavController()

                val viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
                    "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
                }
                val viewmodel = hiltViewModel<GalacticViewModel>(viewModelStoreOwner)

                Scaffold { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = HomeScreenRoute
                    ) {
                        composable<HomeScreenRoute> {
                            HomeScreen(
                                modifier = Modifier.padding(innerPadding),
                                viewModel = viewmodel,
                                onCharacterClick = { id ->
                                    navController.navigate(CharacterDetailsScreenRoute(id))
                                }
                            )
                        }
                        composable<CharacterDetailsScreenRoute> {
                            val args = it.toRoute<CharacterDetailsScreenRoute>()
                            CharacterDetailsScreen(
                                modifier = Modifier.padding(innerPadding),
                                id = args.id,
                                viewModel = viewmodel,
                                onBack = {

                                }
                            )
                        }
                    }
                }
            }
        }
    }
}