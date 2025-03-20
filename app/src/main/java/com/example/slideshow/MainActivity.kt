package com.example.slideshow

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import com.example.slideshow.ui.theme.SlideShowTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlideShowTheme {
                SlideShowWithButton()

            }
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun SlideShowWithButton(modifier: Modifier = Modifier) {
        var result by remember { mutableStateOf(1) }
        // New state for the text field content
        var textFieldValue by remember { mutableStateOf("1") }

        val imageResource = when (result) {
            1 -> R.drawable.img_1
            2 -> R.drawable.img_2
            3 -> R.drawable.img_3
            else -> R.drawable.img_4
        }
        val captionResource = when(result){
            1->R.string.caption_1
            2->R.string.caption_2
            3->R.string.caption_3
            else->R.string.caption_4



        }

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
           Text(text = stringResource(captionResource))
            Row(modifier = modifier) {
                Button(
                    onClick = {
                        result -= 1
                        textFieldValue = result.toString() // Sync text field when button is used
                    },
                    enabled = result > 1,
                    modifier = Modifier.size(width = 80.dp, height = 50.dp)
                ) {
                    Text(stringResource(R.string.prev_button))
                }
                Button(
                    onClick = {
                        result += 1
                        textFieldValue = result.toString() // Sync text field when button is used
                    },
                    enabled = result < 4,
                    modifier = Modifier.size(width = 80.dp, height = 50.dp)
                ) {
                    Text(stringResource(R.string.next_button))
                }
            }
            Spacer(modifier = Modifier.height(100.dp))
            EditSlideNumber(
                res = textFieldValue,
                onValueChange = { newText ->
                    textFieldValue = newText // Allow user to modify text freely
                    newText.toIntOrNull()?.let { result = it } // Update slide only if valid
                }
            )
        }
    }

    @Composable
    fun EditSlideNumber(
        res: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier
    ) {
        TextField(
            value = res,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            label = { Text(stringResource(R.string.slide_number)) },
            modifier = modifier
        )
    }



}
