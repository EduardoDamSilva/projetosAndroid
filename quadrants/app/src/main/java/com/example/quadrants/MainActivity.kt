package com.example.quadrants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrants.ui.theme.QuadrantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun quadrantFormat(
    title: String,
    content: String,
    backgroundColor: Color,
    modifier : Modifier = Modifier
){

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
//      Centralizar o conteúdo
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = content,
            textAlign = TextAlign.Justify
        )
    }

}




@Composable
fun quadrantsInScreen() {

    Column(Modifier.fillMaxSize()){
        Row(Modifier.weight(1f)) {
            quadrantFormat(
                stringResource(R.string.text_composable),
                stringResource(R.string.text_composable_content),
                Color.Green,
                modifier = Modifier.weight(1f))

            quadrantFormat(
                            stringResource(R.string.image_composable_title),
                stringResource(R.string.image_composable_content),
                Color.Yellow,
                modifier = Modifier.weight(1f))
        }

        Row(Modifier.weight(1f)) {
            quadrantFormat(
                stringResource(R.string.row_composable_title),
                stringResource(R.string.row_composable_content),
                Color.Cyan,
                modifier = Modifier.weight(1f))

            quadrantFormat(
                            stringResource(R.string.column_composable_title),
                stringResource(R.string.column_composable_content),
                Color.LightGray,
                modifier = Modifier.weight(1f))
        }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    QuadrantsTheme {
        quadrantsInScreen()
    }
}