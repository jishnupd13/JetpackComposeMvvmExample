package com.app.userslistapplicationmvvmsample.ui.user_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.app.userslistapplicationmvvmsample.R
import com.app.userslistapplicationmvvmsample.models.users.Address
import com.app.userslistapplicationmvvmsample.models.users.Bank
import com.app.userslistapplicationmvvmsample.models.users.Company
import com.app.userslistapplicationmvvmsample.models.users.Hair
import com.app.userslistapplicationmvvmsample.models.users.User
import com.app.userslistapplicationmvvmsample.ui.components.ErrorScreen
import com.app.userslistapplicationmvvmsample.ui.components.ProgressBar
import com.app.userslistapplicationmvvmsample.ui.components.SimpleTopBar
import com.app.userslistapplicationmvvmsample.ui.theme.PerlBlack
import com.app.userslistapplicationmvvmsample.ui.theme.fonts
import com.app.userslistapplicationmvvmsample.ui.theme.holidayColor
import com.app.userslistapplicationmvvmsample.utils.Empty
import com.app.userslistapplicationmvvmsample.utils.NetworkResult
import com.app.userslistapplicationmvvmsample.utils.Nil
import com.app.userslistapplicationmvvmsample.viewmodels.user_details.UserDetailsViewModel

@Composable
fun UserDetails(id:Int = 0,viewModel: UserDetailsViewModel, onClickOnBackButton:(()->Unit)?){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        val data =  viewModel.userMutableStateFlow.collectAsState()

        LaunchedEffect(key1 = Unit){
            viewModel.fetchUsers(id = id)
        }

        SimpleTopBar(isHideBackButton = false, title = "Details"){
            onClickOnBackButton?.invoke()
        }

        when(data.value){

            is NetworkResult.Loading->{
                ProgressBar()
            }

            is NetworkResult.Success->{
                data.value.data?.let {user->
                    UserDetails(item = user)
                }

            }

            is NetworkResult.Error->{
                ErrorScreen()
            }
        }
    }
}

@Composable
fun UserDetails(item:User){
    LazyColumn(modifier = Modifier.fillMaxSize()){
        item {

            Spacer(
                modifier =
                Modifier
                    .padding(top = 14.dp)
                    .fillMaxWidth())

            HeaderSection(imageUrl = item.image?: Empty,
                name = "${item.firstName} ${item.lastName}")
        }

        item {
            GeneralInfoSection(
                email = item.email,
                phoneNumber = item.phone,
                company = item.company?.name
            )
        }

        item {
            BodyDetails(
                bloodGroup = item.bloodGroup,
                height = item.height.toString(),
                weight = item.weight.toString(),
                eyeColor = item.eyeColor,
                hair = item.hair
            )
        }

        item.address?.let {address->
            item {
                AddressDetails(item = address)
            }
        }

        item.bank?.let {bank ->
           item {
               CardDetails(bank)
           }
        }

        item.company?.let {company ->
            item {
                CompanyDetails(company)
            }
        }

        item {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(14.dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CompanyDetails(item:Company? = Nil){
    Column(
        modifier = Modifier
            .padding(horizontal = 14.dp)
            .fillMaxWidth()
    ) {
        TitleComponent("Company Details")

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(14.dp)
        )

        RowComponent(title = "Name", value = item?.name?: Empty)
        RowComponent(title = "Department", value = item?.department?: Empty)
        RowComponent(title = "City", value = item?.address?.city?: Empty)
        RowComponent(title = "Postal Code", value = item?.address?.postalCode?: Empty)
        RowComponent(title = "State", value = item?.address?.state?: Empty)

    }
}

@Composable
@Preview(showBackground = true)
fun CardDetails(item:Bank? = Nil){

    Column(
        modifier = Modifier
            .padding(horizontal = 14.dp)
            .fillMaxWidth()
    ) {
        TitleComponent("Card Details")

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(14.dp)
        )

        RowComponent(title = "Card Number", value = item?.cardNumber?: Empty)
        RowComponent(title = "Card Type", value = item?.cardType?: Empty)
        RowComponent(title = "Currency", value = item?.currency?: Empty)
        RowComponent(title = "Iban", value = item?.iban?: Empty)
    }
}

@Composable
@Preview(showBackground = true)
fun GeneralInfoSection(
    email:String? = Empty,
    phoneNumber:String? = Empty,
    company:String? = Empty
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = email?: Empty,
            modifier = Modifier
                .fillMaxWidth(),
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            color = holidayColor,
            textAlign = TextAlign.Center
        )

        Text(
            text = phoneNumber?: Empty,
            modifier = Modifier
                .fillMaxWidth(),
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            color = holidayColor,
            textAlign = TextAlign.Center
        )

        Text(
            text = company?: Empty,
            modifier = Modifier
                .fillMaxWidth(),
            fontFamily = fonts,
            fontWeight = FontWeight.Medium,
            color = holidayColor,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun AddressDetails(item: Address){
    Column(
        modifier = Modifier
            .padding(horizontal = 14.dp)
            .fillMaxWidth()
    ) {

        TitleComponent("Address Details")

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(14.dp)
        )

        RowComponent(title = "Address", value = item.address?: Empty)
        RowComponent(title = "City", value = item.city?: Empty)
        RowComponent(title = "Postal Code", value = item.postalCode?: Empty)
        RowComponent(title = "State", value = item.state?: Empty)

    }
}


@Composable
fun BodyDetails(
    bloodGroup:String?= Empty,
    height:String?= Empty,
    weight:String? = Empty,
    eyeColor:String? = Empty,
    hair:Hair? = Nil
){
    Column(
        modifier = Modifier
            .padding(horizontal = 14.dp)
            .fillMaxWidth()
    ) {

        TitleComponent("Body Details")
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(14.dp)
        )
        RowComponent(title = "Blood Group", value = bloodGroup?: Empty)
        RowComponent(title = "Weight", value = weight?: Empty)
        RowComponent(title = "Height", value = height?: Empty)
        RowComponent(title = "Eye Color", value = eyeColor?: Empty)
        RowComponent(title = "Hair Type", value = "${hair?.color?: Empty} ${hair?.type?: Empty}")
    }
}

@Composable
@Preview(showBackground = true)
fun TitleComponent(title: String? = Nil){
   Text(
       text = title?: Empty,
       fontFamily = fonts,
       fontWeight = FontWeight.SemiBold,
       color = PerlBlack,
       fontSize = 18.sp,
       modifier = Modifier
           .fillMaxWidth()
           .padding(
               top = 14.dp
           )
   )
}


@Composable
@Preview(showBackground = true)
fun RowComponent(title:String="",value:String=""){
    Row(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontFamily = fonts,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = holidayColor,
            modifier = Modifier.weight(1f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )


        Text(
            text = value,
            fontFamily = fonts,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = PerlBlack,
            modifier = Modifier.weight(1f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
@Preview( showBackground =true )
fun HeaderSection(
    imageUrl:String = Empty,
    name:String = Empty
){

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AsyncImage(
            model = ImageRequest
                .Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = Nil,
            placeholder = painterResource(id = R.drawable.place_holder),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(start = 14.dp, top = 8.dp, bottom = 8.dp)
                .size(120.dp)
                .clip(CircleShape)
        )

        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = fonts,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(horizontal = 14.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(14.dp)
        )
    }


}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun UserDetailsScreenPreview(){
    val userViewModel:UserDetailsViewModel = hiltViewModel()
    UserDetails(
        id = 1,
        viewModel = userViewModel,
        onClickOnBackButton = Nil
    )
}
