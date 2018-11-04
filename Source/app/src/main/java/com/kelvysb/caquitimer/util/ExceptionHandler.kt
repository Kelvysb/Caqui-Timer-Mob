package com.kelvysb.caquitimer.util


import java.io.PrintWriter
import java.io.StringWriter
import android.app.Activity
import android.os.Build

class ExceptionHandler(context : Activity) : Thread.UncaughtExceptionHandler {

    private var myContext : Activity? = null
    private var LINE_SEPARATOR : String = "\n"

    override fun uncaughtException(thread: Thread?, exception: Throwable?) {

        var stackTrace = StringWriter()
        exception!!.printStackTrace(PrintWriter(stackTrace))

        var errorReport = StringBuilder()
        errorReport.append("************ CAUSE OF ERROR ************\n\n")
        errorReport.append(stackTrace.toString())
        errorReport.append("\n************ DEVICE INFORMATION ***********\n")
        errorReport.append("Brand: ")
        errorReport.append(Build.BRAND)
        errorReport.append(LINE_SEPARATOR)
        errorReport.append("Device: ")
        errorReport.append(Build.DEVICE)
        errorReport.append(LINE_SEPARATOR)
        errorReport.append("Model: ")
        errorReport.append(Build.MODEL)
        errorReport.append(LINE_SEPARATOR)
        errorReport.append("Id: ")
        errorReport.append(Build.ID)
        errorReport.append(LINE_SEPARATOR)
        errorReport.append("Product: ")
        errorReport.append(Build.PRODUCT)
        errorReport.append(LINE_SEPARATOR)
        errorReport.append("\n************ FIRMWARE ************\n")
        errorReport.append("SDK: ")
        errorReport.append(Build.VERSION.SDK)
        errorReport.append(LINE_SEPARATOR)
        errorReport.append("Release: ")
        errorReport.append(Build.VERSION.RELEASE)
        errorReport.append(LINE_SEPARATOR)
        errorReport.append("Incremental: ")
        errorReport.append(Build.VERSION.INCREMENTAL)
        errorReport.append(LINE_SEPARATOR)

        Globals.fnMessage(stackTrace.toString(),"Error", "Ok", myContext)
        //val intent = Intent(myContext, thread)
        //intent.putExtra("error", errorReport.toString())
        //myContext!!.startActivity(intent)
        //android.os.Process.killProcess(android.os.Process.myPid())
        //System.exit(10)

    }


    init{
            myContext = context
        }

}