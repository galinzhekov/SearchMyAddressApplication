package com.example.searchmyaddressapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.searchmyaddressapplication.searchAddress.AddressSearchScreen
import com.example.searchmyaddressapplication.searchAddress.SearchAddressViewModel
import com.example.searchmyaddressapplication.ui.theme.SearchMyAddressApplicationTheme


class MainActivity : ComponentActivity() {
    private val viewModel: SearchAddressViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchMyAddressApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AddressSearchScreen(viewModel)
                }
            }
        }
    }
}
