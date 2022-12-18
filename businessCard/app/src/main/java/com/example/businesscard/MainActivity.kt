package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ContentMain(stringResource(R.string.title_text))
                    Contact()
                }
            }
        }
    }
}



@Composable
fun ContentMain(fullName: String) {
    val image = painterResource(R.drawable.party)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.Yellow)
            .padding(16.dp)
    )
    {

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
        )

        Text(
            text = fullName,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,

        )

        Text(
            text = stringResource(R.string.subtitle_text),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,

        )
    }




}

@Composable
fun Contact(){
    val iconGmail = painterResource(R.drawable.google)
    val iconInstragram = painterResource(R.drawable.instagram)
    val iconPhone = painterResource(R.drawable.phone)


    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxHeight()
            .padding(bottom = 20.dp)
    ){
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 80.dp, end = 80.dp, bottom = 6.dp)
        ){
            Image(
                painter = iconGmail,
                contentDescription = null
            )

            Text(
                text = stringResource(R.string.email_user),
                fontSize = 20.sp
            )

        }
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 80.dp, end = 80.dp, bottom = 6.dp)
        ){
            Image(
                painter = iconPhone,
                contentDescription = null
            )

            Text(
                text = stringResource(R.string.number_phone),
                fontSize = 20.sp
            )

        }
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 80.dp, end = 80.dp, bottom = 6.dp)
        ){
            Image(
                painter = iconInstragram,
                contentDescription = null
            )

            Text(
                text = stringResource(R.string.instragram_user),
                fontSize = 20.sp
            )

        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        ContentMain(stringResource(R.string.title_text))
        Contact()
    }
}