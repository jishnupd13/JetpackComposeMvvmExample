package com.app.userslistapplicationmvvmsample.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.app.userslistapplicationmvvmsample.R
import com.app.userslistapplicationmvvmsample.models.users.User
import com.app.userslistapplicationmvvmsample.ui.theme.PerlBlack
import com.app.userslistapplicationmvvmsample.ui.theme.fonts
import com.app.userslistapplicationmvvmsample.ui.theme.holidayColor
import com.app.userslistapplicationmvvmsample.utils.Empty
import com.app.userslistapplicationmvvmsample.utils.Nil


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun UsersItem(
    item: User? = Nil,
    onClickCardItem:((item:User?)->Unit)? = Nil
){
    Card(
        modifier = Modifier
            .padding(
                start = 14.dp,
                bottom = 8.dp,
                end = 14.dp
            )
            .clickable {
                onClickCardItem?.invoke(item)
            }
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(3.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(item?.image)
                    .crossfade(true)
                    .build(),
                contentDescription = Nil,
                placeholder = painterResource(id = R.drawable.place_holder),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 14.dp, top = 8.dp, bottom = 8.dp)
                    .size(72.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier
                    .padding(end = 14.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "${item?.firstName?: Empty} ${item?.lastName?: Empty}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = fonts,
                    color = PerlBlack,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 14.dp, start = 8.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = item?.email?: Empty,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = fonts,
                    color = holidayColor,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp, start = 8.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = item?.phone?: Empty,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = fonts,
                    color = holidayColor,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp, start = 8.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }


}