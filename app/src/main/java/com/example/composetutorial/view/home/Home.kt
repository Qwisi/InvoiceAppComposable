package com.example.composetutorial.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composetutorial.BottomBar
import com.example.composetutorial.MyColors
import com.example.composetutorial.R

@Composable
    private fun HomeScreen() {
        Surface(
            color = MyColors.primaryColor,
            modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                HomeBody()
                BottomBar()
            }
        }
    }

    @Composable
    fun HomeBody() {
        Surface(
            color = MyColors.primaryColor,
            modifier = Modifier
                .fillMaxWidth()
                .height(LocalConfiguration.current.screenHeightDp.dp - 40.dp)
        ) {
            // Calculate size of cards based on screen width
            val width = LocalConfiguration.current.screenWidthDp.dp.div(1.08.dp)
            val paddingValue = width.div(16.6f).div(3f).dp
            val leftWidth = width.div(1.428f).dp
            val leftHeight = width.div(3.33f).dp
            Row (
                modifier = Modifier
                    .padding(all = paddingValue)
            ){
                Column (
                    modifier = Modifier
                        .padding(end = paddingValue)
                ){
                    LeftCard(leftWidth, leftHeight)
                    Text(text = "Invoice app")
                }
                RightCard(leftHeight, leftWidth)
            }
        }
    }

    @Composable
    private fun LeftCard(width: Dp, height: Dp){
        val listOfItems = arrayListOf("Item1", "Item2", "Item3", "Item4", "Item5")
        Surface (
            color = MyColors.secondaryColor,
            shape = RoundedCornerShape(size = 16.dp),
            modifier = Modifier
                .width(width)
                .height(height)
        ){
            Column {
                Text(
                    text = "The most popular products",
                    color = MyColors.textColor,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(vertical = 5.dp, horizontal = 5.dp)
                        .align(Alignment.CenterHorizontally)
                )
                LazyColumn (modifier = Modifier.padding(start = 15.dp)){
                    items(listOfItems) { item ->
                        Text(
                            text = item,
                            color = MyColors.textColor,
                            modifier = Modifier.padding()
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun RightCard(width: Dp, height: Dp){
        Surface (
            color = MyColors.secondaryColor,
            shape = RoundedCornerShape(size = 16.dp),
            modifier = Modifier
                .width(width)
                .height(height)
        ){
            Column {
                Image(
                    painter = painterResource(id = R.drawable.ic_settings),
                    contentDescription = "Settings icon",
                    colorFilter = ColorFilter.tint(MyColors.primaryColor),
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 10.dp, end = 10.dp, bottom = 20.dp)
                )
                val modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(horizontal = 10.dp)
                BlockOfText("3 493 120₴", "Total amount", modifier)
                BlockOfText("2 569", "Product sales count", modifier)
            }
        }
    }

    @Composable
    private fun BlockOfText(textUp: String, textDown: String, modifier: Modifier){
        Text(
            text = textUp,
            fontWeight = FontWeight.Bold,
            color = MyColors.textColor,
            modifier = modifier
        )
        Text(
            text = textDown,
            color = MyColors.textColor,
            modifier = modifier
                .padding(bottom = 20.dp)
        )
    }
