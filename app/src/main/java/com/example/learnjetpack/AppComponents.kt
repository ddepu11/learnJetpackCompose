package com.example.learnjetpack

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HelloWorld(param: String) {
    TextComponent(
        value = param,
        size = 20.sp,
        textColor = Color.DarkGray,
        weight = FontWeight.Medium,
        maxLines = 3
    )
}

//@Preview(showBackground = true)
//@Composable
//fun HelloWorldPreviewForComponent(name: String = "Hello Rohan Kumar!") {
//    HelloWorld(name)
//}

//@Preview(showSystemUi = true)
//@Composable
//fun HelloWorldPreview(name: String = "Hello Rohan Kumar!") {
//    HelloWorld(name)
//}

@Composable
fun TextComponent(
    value: String,
    size: TextUnit,
    textColor: Color,
    weight: FontWeight = FontWeight.Normal,
    textStyle: FontStyle = FontStyle.Normal,
    maxLines: Int? = null
) {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(align = Alignment.Top)
            .background(Color.Cyan)
            .alpha(0.8f)
            .border(width = 1.dp, color = Color.Magenta, shape = RoundedCornerShape(8.dp)),
        text = value.repeat(15),
        fontSize = size,
        color = textColor,
        fontWeight = weight,
        fontStyle = textStyle,
        maxLines = maxLines ?: Int.MAX_VALUE,
        overflow = TextOverflow.Ellipsis
    )
}

//@Preview(showSystemUi = true)
//@Composable
//fun TextComponentPreview() {
//    TextComponent(
//        value = "Hello mohan!!!",
//        size = 20.sp,
//        textColor = Color.DarkGray,
//        weight = FontWeight.Medium,
//        maxLines = 3
//    )
//}

@Composable
fun SimpleButton() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(68.dp),
        onClick = {
            Log.d("TAG", "SimpleButton: Clicked")
        },
        shape = RoundedCornerShape(12.dp),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = "Click Here!",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SimpleButtonPreview() {
//    SimpleButton()
//}


@Composable
fun ImageComponent() {
    Image(
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape),
        painter = painterResource(id = R.drawable.bird),
        contentDescription = "Bird!",
        contentScale = ContentScale.Crop
    )
}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ImageComponentPreview() {
//    ImageComponent()
//}
//

@Composable
fun BlogCategory(img: Int, title: String, description: String) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "Dummy User",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f),
                contentScale = ContentScale.Crop
            )

            ItemDescription(title, description, Modifier.weight(.8f))
        }

    }
}

@Composable
private fun ItemDescription(title: String, description: String, modifier: Modifier) {
    Column(modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black
        )
        Text(
            text = description,
            fontWeight = FontWeight.Light,
            color = Color.Gray,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0x000)
@Composable
fun BlogCategoryPreview() {
    BlogCategory(img = R.drawable.dummyuser, "Programming", "Learn Different Languages")
}