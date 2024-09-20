package com.example.learnjetpack

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VerticleScreen() {
    var count = 0;

    Column(
        modifier = Modifier
            .padding(vertical = 20.dp)
            .background(Color.Cyan)
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(18.dp),
    ) {
        Text(text = "Counter: $count", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "Please enter your name:", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(40.dp))

        TextFieldComponents()
        Spacer(modifier = Modifier.height(40.dp))

        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                count++
                Log.d("TAG", "$count")
            }) {
            Text(text = "Increase Counter", textAlign = TextAlign.Center, fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(10.dp))


        SimpleButton()
        Spacer(modifier = Modifier.height(10.dp))
        ImageComponent()

    }
}

@Preview(showBackground = true)
@Composable
fun VerticleScreenPreview() {
    VerticleScreen()
}

@Composable
fun TextFieldComponents() {

    var text by remember {
        mutableStateOf("")
    }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = {
            text = it
        },
        textStyle = TextStyle(
            color = Color.DarkGray,
            fontSize = 23.sp
        ),
        label = {
            Text(text = "Please enter your text!")
        },
        keyboardOptions = KeyboardOptions(
            autoCorrect = true,
            keyboardType = KeyboardType.Password,
        )
    )
}

@Preview()
@Composable
fun TextFieldComponentPreview() {
    TextFieldComponents()
}