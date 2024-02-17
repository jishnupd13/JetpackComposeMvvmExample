package com.app.userslistapplicationmvvmsample.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.userslistapplicationmvvmsample.ui.theme.PerlBlack
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToHomeScreen:()->Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = PerlBlack),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LaunchedEffect(key1 = Unit){
            delay(3000)
            navigateToHomeScreen.invoke()
        }
        Image(
            imageVector =Icons.Filled.Info ,
            contentDescription = null,
            modifier = Modifier
                .height(72.dp)
                .width(72.dp),
            colorFilter = ColorFilter
                .tint(color = Color.White)

        )
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SplashScreenPreview(){
    SplashScreen {}
}