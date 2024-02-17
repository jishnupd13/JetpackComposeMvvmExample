package com.app.userslistapplicationmvvmsample.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.userslistapplicationmvvmsample.ui.theme.PerlBlack
import com.app.userslistapplicationmvvmsample.ui.theme.fonts
import com.app.userslistapplicationmvvmsample.utils.Nil

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SimpleTopBar(
    title:String="Title",
    isHideBackButton:Boolean = true,
    onClickOnBackButton:(()->Unit)? = Nil){
   Row(
       modifier = Modifier
           .fillMaxWidth()
           .background(color = PerlBlack),
       verticalAlignment = Alignment.CenterVertically
   ) {

       Spacer(modifier = Modifier
           .padding(vertical = 14.dp)
           .height(24.dp)
       )

       if(!isHideBackButton){
           Image(
               imageVector =Icons.Default.ArrowBack ,
               contentDescription =null,
               colorFilter = ColorFilter
                   .tint(color = Color.White),
               modifier = Modifier
                   .padding(start = 14.dp)
                   .clickable {
                       onClickOnBackButton?.invoke()
                   }
           )
       }


       Text(
           text = title,
           modifier = Modifier
               .fillMaxWidth()
               .padding(start = 14.dp,end = 14.dp),
           color = Color.White,
           fontFamily = fonts,
           fontWeight = FontWeight.SemiBold,
           fontSize = 16.sp,
           maxLines = 1,
           overflow = TextOverflow.Ellipsis
       )
   }
}