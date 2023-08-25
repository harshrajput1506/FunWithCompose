package com.example.funwithcompose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funwithcompose.ui.theme.FunWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FunWithComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    listView()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun listView() {
    Column {
        listItem(name = "Harsh", profile = "Android Developer", resId = R.drawable.avatar, modifier = Modifier)
        listItem(name = "Sakshi", profile = "Web Developer", resId = R.drawable.avatar1, modifier = Modifier)
        listItem(name = "Vishesh", profile = "Blockchain Developer", resId = R.drawable.avatar2, modifier = Modifier)
        listItem(name = "Priya", profile = "Web Developer", resId = R.drawable.avatar3, modifier = Modifier)
        listItem(name = "Yash", profile = "App Developer", resId = R.drawable.avatar4, modifier = Modifier)
        listItem(name = "Aruni", profile = "Ios Developer", resId = R.drawable.avatar5, modifier = Modifier)
    }
}



@Composable
fun listItem(name: String, profile: String, resId: Int, modifier: Modifier) {

    val ctx = LocalContext.current

    Row(modifier.padding(12.dp)) {
        Image(
            painter = painterResource(id = resId),
            contentDescription = null,
            modifier = Modifier.clickable { nextScreen(ctx) }
                .size(40.dp)

        )
        Column(Modifier.padding(8.dp)) {
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 24.sp, color = Color.White)
            Text(text = profile, fontSize = 12.sp, color = Color.Gray)
        }
    }

}

private fun nextScreen(ctx : Context) {
    val intent : Intent = Intent(ctx, HomeActivity::class.java)
    ctx.startActivity(intent)
}