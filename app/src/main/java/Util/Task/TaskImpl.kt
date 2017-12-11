package Util.Task

import Util.Network.Network
import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import java.io.BufferedInputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by Administrator on 2017/12/10.
 */
class TaskImpl(context:Context?) : AsyncTask<String, Int, String>() {

    var applicationContext = context

    override fun doInBackground(vararg p0: String?): String {
        val stringBuffer = StringBuffer()
//        val url = URL("http://192.168.0.4:8080/crawer/test")
        val url = URL(p0[0])
        val con = url.openConnection() as HttpURLConnection
        con.requestMethod = "GET"
        con.connect()
        val inputStream = InputStreamReader(con.inputStream)
        val strList = inputStream.readLines()
        for(one in strList){
            stringBuffer.append(one)
        }
        Network.staticStr = stringBuffer.toString()
        return stringBuffer.toString()
    }

    override fun onPostExecute(result:String){
        Toast.makeText(this.applicationContext, result,Toast.LENGTH_SHORT).show()
    }
}