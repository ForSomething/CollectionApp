package com.collectionapp.my.collectionapp

import Util.Network.Network
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.R.menu
import android.content.Context
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import android.net.ConnectivityManager
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = getMenuInflater()
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val textView = findViewById<TextView>(R.id.stateTextView)
        textView.text = "change"
        val connMgr = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = Network()
        val param:Map<String,Object>? = null
        network.buildConnect(this.applicationContext,connMgr,"http://192.168.0.4:8080/crawer/test",param)
        val errStr = network.doRequest()
        if("" != errStr){
            Toast.makeText(this.applicationContext, errStr,Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
