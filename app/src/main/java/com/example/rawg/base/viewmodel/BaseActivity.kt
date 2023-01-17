package com.example.rawg.base.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.rawg.utils.showSnackBar

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    protected lateinit var binding: VB

    abstract fun inflateLayout(layoutInflater: LayoutInflater): VB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateLayout(layoutInflater)
        setContentView(binding.root)
    }

    fun showSnackBar(view: View, message:String, action: String = "", actionListener: () -> Unit = {}){
        view.showSnackBar(message, action, actionListener)
    }
}