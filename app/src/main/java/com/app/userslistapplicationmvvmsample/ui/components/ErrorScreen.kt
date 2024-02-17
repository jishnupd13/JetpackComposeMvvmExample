package com.app.userslistapplicationmvvmsample.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.userslistapplicationmvvmsample.ui.theme.PerlBlack
import com.app.userslistapplicationmvvmsample.ui.theme.fonts

@Composable
fun ErrorScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Sorry! Something went Wrong",
            fontFamily = fonts,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = PerlBlack,
            modifier = Modifier
                .padding(horizontal = 14.dp)
                .fillMaxWidth()
        )
    }
}