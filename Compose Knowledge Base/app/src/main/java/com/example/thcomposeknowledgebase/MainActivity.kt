package com.example.thcomposeknowledgebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thcomposeknowledgebase.ui.theme.THComposeKnowledgeBaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            THComposeKnowledgeBaseTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppEqualFlutter()
                }
            }
        }
    }
}

@Composable
fun GreetingText(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.title1),
            modifier = Modifier
                .padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = stringResource(id = R.string.title2),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp
            ),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(id = R.string.title3),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun GreetingImage(modifier: Modifier = Modifier){
    Image(
        painter = painterResource(id = R.drawable.bg_compose_background),
        contentDescription = null
    )
}
// Exam 1
@Composable
fun CreateTask1(modifier: Modifier = Modifier){
    Column(verticalArrangement = Arrangement.Center) {
        GreetingImage()
        GreetingText()
    }
}
// Exam 2
@Composable
fun CreateTask2(modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(
            id = R.drawable.ic_task_completed),
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.task),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(id = R.string.nice),
            fontSize = 16.sp
        )
    }
}

// Exam 3
@Composable
fun GreetingTask3(modifier: Modifier = Modifier){
    Column(modifier = Modifier.fillMaxSize()) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        ){
            Column(
                modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .background(color = Color(0xFFEADDFF))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.txtComposable),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = stringResource(id = R.string.NdTxtComposable),
                    textAlign = TextAlign.Justify
                )
                Button(onClick = {}) {
                    Text(text = "Hello HyuNie")
                }
            }
            Column(
                modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFD0BCFF))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.imgComposable),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = stringResource(id = R.string.NdImgComposable),
                    textAlign = TextAlign.Justify
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .background(color = Color(0xFFB69DF8))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.rowComposable),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = stringResource(id = R.string.NdRowComposable),
                    textAlign = TextAlign.Justify
                )
            }
            Column(
                modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFF6EDFF))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.columnComposable),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = stringResource(id = R.string.NdColumnComposable),
                    textAlign = TextAlign.Justify
                )
            }
        }
    }
}

// App giong Flutter
@Composable
fun AppEqualFlutter(modifier: Modifier = Modifier){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                boxMethod(name = "Box 1", direction = Alignment.BottomEnd)
                boxMethod(name = "Box 2", direction = Alignment.BottomStart)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                boxMethod(name = "Box 3", direction = Alignment.TopEnd)
                boxMethod(name = "Box 4", direction = Alignment.TopStart)
            }
        }
        boxMethod(name = "Hello World",
            direction = Alignment.Center,
            boxRadius = true,
            Modifier.align(Alignment.Center))
    }
}
@Composable
fun boxMethod(name: String, direction: Alignment, boxRadius: Boolean = false, modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .width(160.dp)
            .height(160.dp)
            .clip(shape = RoundedCornerShape(if (boxRadius)100.dp else 0.dp))
            .background(if (boxRadius) Color.Blue else Color.Green)
    ){
        Text(
            text = name,
            modifier = Modifier.align(direction),
            color = Color.Red,
            fontSize = 24.sp
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    THComposeKnowledgeBaseTheme {
        AppEqualFlutter()
    }
}