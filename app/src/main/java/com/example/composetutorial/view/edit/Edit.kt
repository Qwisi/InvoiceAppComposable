package com.example.composetutorial.view.edit

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composetutorial.BottomBar
import com.example.composetutorial.MyColors
import com.example.composetutorial.R
import com.example.composetutorial.model.Product
import com.example.composetutorial.viewModel.ReadWrite

    private lateinit var products: List<Product>
    private val readWrite: ReadWrite = ReadWrite("products.json")

    /*@Composable
    fun EditScreen() {
        Surface(
            color = MyColors.primaryColor,
            modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                EditBody()
                BottomBar()
            }
        }
    }*/

    @Composable
    fun EditBody(context: Context) {
        Surface(
            color = MyColors.primaryColor,
            modifier = Modifier
                .fillMaxWidth()
                .height(LocalConfiguration.current.screenHeightDp.dp - 40.dp)
        ) {
            Column {
                LazyColumn {
                    products = readWrite.readFromFile(context)
                    items(products.size) { index ->
                        ItemRow(product = products[index])
                    }
                }
            }
        }
    }

    @Composable
    private fun ItemRow(product: Product){
        Surface(
            color = MyColors.secondaryColor,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(vertical = 5.dp, horizontal = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            ) {
                val modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 2.dp)
                TextInRow(
                    product.name,
                    modifier
                        .width(LocalConfiguration.current.screenWidthDp.dp / 2))
                TextInRow(
                    product.size,
                    modifier
                        .width(LocalConfiguration.current.screenWidthDp.dp / 8))
                TextInRow(
                    "₴${product.price}",
                    modifier
                        .width(LocalConfiguration.current.screenWidthDp.dp / 6))
                Image(
                    painter = painterResource(id = R.drawable.ic_edit_row),
                    contentDescription = "Edit Icon",
                    colorFilter = ColorFilter.tint(MyColors.specialColor),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "Delete Icon",
                    colorFilter = ColorFilter.tint(MyColors.primaryColor),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }

    @Composable
    private fun TextInRow(text: String, modifier: Modifier){
        Text(
            text = text,
            modifier = modifier,
            color = MyColors.textColor
        )
    }

