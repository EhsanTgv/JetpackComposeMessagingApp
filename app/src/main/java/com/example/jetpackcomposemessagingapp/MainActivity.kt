package com.example.jetpackcomposemessagingapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.animatedVectorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposemessagingapp.ui.theme.JetpackComposeMessagingAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeMessagingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    messageListTopBar("Android")
                }
            }
        }
    }
}

@Composable
fun messageListTopBar(title: String) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
        },
        actions = {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "",
                modifier = Modifier.padding(start = 10.dp, end = 8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_options_menu),
                contentDescription = "",
                modifier = Modifier.padding(start = 10.dp, end = 8.dp)
            )
        },
        backgroundColor = Color.White
    )
}

@Composable
fun floatingButton(fabClick: () -> Unit) {
    FloatingActionButton(onClick = { fabClick() }) {
        Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeMessagingAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            messageListTopBar("Android")
        }
    }
}