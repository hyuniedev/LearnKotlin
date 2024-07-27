package com.example.listtaskapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listtaskapp.ui.theme.ListTaskAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListTaskAppTheme {
                CustomUI()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomUI(modifier: Modifier = Modifier) {
    var tasks = remember {
        mutableStateListOf<Task>()
    }
    var isOpenFAB = remember {mutableStateOf(false)}
    Box {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "Task List",
                            modifier = Modifier.align(Alignment.Center),
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )
            )
            Column(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                tasks.forEach { TaskCard(task = it) }
            }
        }
        FloatingActionButton(
            onClick = {isOpenFAB.value = true},
            modifier = Modifier
                .padding(18.dp)
                .width(50.dp)
                .height(50.dp)
                .align(Alignment.BottomEnd),
            shape = CircleShape,
            containerColor = Color.Blue,
            contentColor = Color.White
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }
    }
    if(isOpenFAB.value){
        var text = remember {
            mutableStateOf("")
        }
        ModalBottomSheet(
            onDismissRequest = {isOpenFAB.value = false},
            sheetState = rememberModalBottomSheetState()
        ) {
            Column(modifier = Modifier.fillMaxWidth().height(200.dp).padding(25.dp)) {
                TextField(
                    value = text.value,
                    onValueChange = {newText -> text.value = newText},
                    placeholder = {Text(text = "Enter name of Task...")},
                    label = { Text(text = "Add your task")},
                    modifier = Modifier.padding(bottom = 30.dp).fillMaxWidth()
                )
                Button(onClick = {
                    val id = if(tasks.size==0) 1 else tasks.size + 1
                    tasks.add(Task(id,text.value))
                    isOpenFAB.value = false
                },
                    modifier = Modifier.fillMaxWidth().height(40.dp)
                ) {
                    Text(text = "Add Task", fontSize = 20.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListTaskAppTheme {
        CustomUI()
    }
}