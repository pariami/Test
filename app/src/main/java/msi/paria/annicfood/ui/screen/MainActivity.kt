package msi.paria.annicfood.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import msi.paria.annicfood.ui.screen.components.AppContent
import msi.paria.annicfood.ui.viewmodel.PersonViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val personViewModel: PersonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent(personViewModel)
        }
    }
}