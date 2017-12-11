package Util.Network

import Util.Task.TaskImpl
import android.content.Context
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.widget.Toast

/**
 * Created by Administrator on 2017/12/10.
 */
class Network {
    companion object{
        var staticStr = "not change"
    }
    var connectManager:ConnectivityManager? = null
    var url:String? = null
    var param:Map<String,Object>? = null
    var task:TaskImpl? = null

    fun buildConnect(context:Context,connectManager: ConnectivityManager,url:String?,param:Map<String,Object>?){
        this.connectManager = connectManager
        this.url = url
        this.param = param
        this.task = TaskImpl(context)
    }

    fun doRequest():String{
        if(task != null){
            val networkInfo = connectManager?.activeNetworkInfo
            if(networkInfo != null && networkInfo.isConnected){
                task?.execute(url)
            }
            return ""
        }
        return "please invoke method \"buildConnect\" before doRequest"
    }
}