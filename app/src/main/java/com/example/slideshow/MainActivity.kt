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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slideshow.Model.Team
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.ui.platform.LocalLayoutDirection
import com.example.slideshow.Data.DataSource


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlideShowTheme {
                ScrollApp()

            }
        }
    }

    @Composable
    fun ScrollApp(){
        val layoutDirection = LocalLayoutDirection.current
        Surface { ScrollList(
            scrollList = DataSource().loadData()
        ) }

    }
    @Composable
    fun ScrollCard(team: Team, modifier: Modifier=Modifier){
        Column() {
            Image(
                painter = painterResource(team.imageResourceId),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(team.stringResourceId),

                )
        }
    }
    @Composable
    fun ScrollList(scrollList: List<Team>,modifier: Modifier = Modifier){
        LazyColumn (modifier=modifier){
            items(scrollList){scroll ->
                ScrollCard(
                    team = scroll,
                    modifier = Modifier.padding(8.dp)


                    )
            }

        }
    }


}
