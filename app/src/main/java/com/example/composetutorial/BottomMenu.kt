package com.example.composetutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

    @Composable
    fun BottomBar(){
        Surface(
            color = MyColors.secondaryColor,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp) // Adjust the radius as needed
        ) {
            BottomIconsRow()
        }
    }

    @Composable
    private fun BottomIconsRow(){
        Row(
            modifier = Modifier.padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_history),
                contentDescription = "History icon",
                colorFilter = ColorFilter.tint(MyColors.primaryColor),
                modifier = Modifier
                    .size(30.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "Add icon",
                colorFilter = ColorFilter.tint(MyColors.primaryColor),
                modifier = Modifier
                    .size(30.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = "Home icon",
                colorFilter = ColorFilter.tint(MyColors.specialColor),
                modifier = Modifier
                    .size(30.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_statistic),
                contentDescription = "Statistic icon",
                colorFilter = ColorFilter.tint(MyColors.primaryColor),
                modifier = Modifier
                    .size(30.dp)
            )
            IconButton(
                imageResId = R.drawable.ic_edit,
                iconSize = 30.dp,
                colorFilter = ColorFilter.tint(MyColors.primaryColor),
                onClick = {  }
            )
        }
    }

    @Composable
    private fun IconButton(
        imageResId: Int,
        iconSize: Dp,
        colorFilter: ColorFilter,
        onClick: () -> Unit
    ) {
        IconButton(onClick = onClick) {
            Image(
                painter = painterResource(imageResId),
                contentDescription = null,
                colorFilter = colorFilter,
                modifier = Modifier.size(iconSize)
            )
        }
    }