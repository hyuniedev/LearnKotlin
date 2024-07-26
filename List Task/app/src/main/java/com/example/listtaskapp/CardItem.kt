package com.example.listtaskapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Task(val id:Int, val name: String)

@Composable
fun TaskCard(task: Task, modifier: Modifier = Modifier){
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .background(color = Color.Cyan)
            .padding(horizontal = 10.dp)
            .height(55.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = task.name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )
        IconButton(onClick = {}, modifier = Modifier.size(24.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = null,
                tint = Color.DarkGray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCardPreview(){
    TaskCard(Task(1,"Hyu Nie"))
}