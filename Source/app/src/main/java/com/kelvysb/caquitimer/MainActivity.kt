package com.kelvysb.caquitimer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kelvysb.caquitimer.bo.CaquiTimerBO
import com.kelvysb.caquitimer.util.Globals
import kotlin.system.exitProcess
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity()
{

    private var PERMISSION_REQUEST : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        try
        {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            doAsync({ex ->
                        callingActivity.run{runOnUiThread {
                            ErrorHandler(ex.message!!)
                            Exit()
                        } }
                    },
                    {
                        try{
                            CaquiTimerBO.Initialize()
                        }catch (ex:Exception){
                            callingActivity.run{runOnUiThread {
                                ErrorHandler(ex.message!!)
                                Exit()
                            } }
                        }
                    })


        }catch (ex : java.lang.Exception)
        {
            Globals.fnMessage(ex.message!!, resources.getString(R.string.app_name), this)
            Exit()
        }

    }

    private fun About(){

        var objIntent : Intent

        try
        {
            //objIntent = Intent(this, atvAbout::class.java)
            //startActivity(objIntent)
        }catch (ex:Exception)
        {
            Globals.fnMessage(ex.message!!, resources.getString(R.string.app_name), this)
        }
    }

    override fun onBackPressed()
    {
        try {
            Exit()
        }catch (ex:Exception)
        {
            Globals.fnMessage(ex.message!!, resources.getString(R.string.app_name), this)
        }
    }

    private fun Exit()
    {
        try
        {
            finish()
            exitProcess(0)
            application.onTerminate()
        }catch (ex:Exception)
        {

        }
    }

    private fun ErrorHandler(error: String){
        Globals.fnMessage(error, resources.getString(R.string.app_name), this)
    }

}
