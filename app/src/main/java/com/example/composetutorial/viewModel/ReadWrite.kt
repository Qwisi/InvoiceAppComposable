package com.example.composetutorial.viewModel

import android.content.Context
import com.example.composetutorial.model.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class ReadWrite(private val fileName: String) {

    fun writeToFile(context: Context, productList: ArrayList<Product>) {
        val jsonString = Gson().toJson(productList)
        val fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)
        val outputStreamWriter = OutputStreamWriter(fileOutputStream)
        outputStreamWriter.write(jsonString)
        outputStreamWriter.close()
    }

    fun readFromFile(context: Context): ArrayList<Product> {
        val productList = ArrayList<Product>()
        if (fileExists(context)) {
            val fileInputStream = context.openFileInput(fileName)
            val inputStreamReader = InputStreamReader(fileInputStream)
            val productListType = object : TypeToken<ArrayList<Product>>() {}.type
            val gson = Gson()
            productList.addAll(gson.fromJson<ArrayList<Product>>(inputStreamReader, productListType))
            inputStreamReader.close()
        }
        return productList
    }

    private fun fileExists(context: Context): Boolean {
        val file = File(context.filesDir, fileName)
        return file.exists()
    }

}