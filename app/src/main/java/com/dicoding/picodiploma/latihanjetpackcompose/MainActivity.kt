package com.dicoding.picodiploma.latihanjetpackcompose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.dicoding.picodiploma.latihanjetpackcompose.ui.theme.LatihanJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LatihanJetpackComposeTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopBar (context=LocalContext.current, content = {
                        JetIphoneApp(context=LocalContext.current)
                    })

                }
            }
        }
    }
    }
@Composable
fun TopBar(content: @Composable () -> Unit,context: Context) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Iphone List App") },
                actions = {
                    IconButton(onClick = {context.startActivity(Intent(context,ProfileActivity::class.java)) }) {
                        Icon(Icons.Default.AccountCircle, contentDescription = "about_page")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            JetIphoneApp(context = LocalContext.current)
        }

    }
}


@Preview
@Composable
fun AccountPagePreview() {
    TopBar (context=LocalContext.current, content = {
        JetIphoneApp(context=LocalContext.current)
    })
}

