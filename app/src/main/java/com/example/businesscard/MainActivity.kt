package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun CardHeader (name: String, title: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.profilephotoblue)

    Column {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(125.dp)
                .clip(shape = CircleShape)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = name,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,

        )
        Text(
            text = title,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun CardFooter (email: String, linkedin: String, instagram: String, modifier: Modifier = Modifier){
    val emailIcon = painterResource(R.drawable.envelope_solid)
    val instagramIcon = painterResource(R.drawable.instagram)
    val linkedinIcon = painterResource(R.drawable.linkedin)
    val logoModifier = Modifier
        .size(24.dp)

    Column (verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row (horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Image(
                painter = emailIcon,
                contentDescription = null,
                modifier = logoModifier,
                colorFilter = ColorFilter.tint(Color.White),
            )
            Text(
                text = email,
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Row (horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Image(
                painter = instagramIcon,
                contentDescription = null,
                modifier = logoModifier,
                colorFilter = ColorFilter.tint(Color.White),
            )
            Text(
                text = instagram,
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Row (horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Image(
                painter = linkedinIcon,
                contentDescription = null,
                modifier = logoModifier,
                colorFilter = ColorFilter.tint(Color.White),
            )
            Text(
                text = linkedin,
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun CardContent (name: String, title: String, email: String, instagram: String, linkedin: String, modifier: Modifier = Modifier) {
    val bgImage = painterResource(R.drawable.darkgradient)

    Box (modifier = Modifier.fillMaxSize()){
        Image(
            painter = bgImage,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column (modifier = Modifier
            .padding(vertical = 64.dp)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Spacer(modifier = Modifier.height(8.dp))
                CardHeader(name = name, title = title)
            }
            CardFooter(email = email, linkedin = linkedin, instagram = instagram)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
//        CardHeader(name = "Daffa Yuslim", title = "Junior Programmer")
//        CardFooter(email = "andidaffa75@gmail.com", linkedin = "daffayuslim", instagram = "@daffayuslim")
    CardContent(name = "Daffa Yuslim", title = "Junior Programmer", email = "andidaffa75@gmail.com", instagram = "@daffayuslim", linkedin = "daffayuslim")
    }
}