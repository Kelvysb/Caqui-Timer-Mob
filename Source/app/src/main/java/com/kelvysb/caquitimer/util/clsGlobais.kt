package com.kelvysb.caquitimer.util

import android.content.DialogInterface
import android.app.AlertDialog
import android.app.Notification.*
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.support.v4.app.NotificationCompat
import android.support.v4.graphics.ColorUtils
import org.apache.commons.codec.digest.DigestUtils



/**
 * Created by kelvys on 18/09/2017.
 */


object Globals {

    //functions
    fun fnNotifify(p_strMessage: String, p_strTitle: String, p_intIcon : Int, p_objContext: Context) {

        val dlgAlert = NotificationCompat.Builder(p_objContext, "Olive")
        val notificationManager = p_objContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        try {
            dlgAlert.setContentTitle(p_strTitle)
            dlgAlert.setContentText(p_strMessage)
            dlgAlert.setSmallIcon(p_intIcon)
            dlgAlert.setCategory(CATEGORY_EVENT)
            dlgAlert.setVibrate(longArrayOf(100, 200, 300, 400, 500, 400, 500, 200, 500))
            notificationManager.notify(1, dlgAlert.build())
        } catch (ex: Exception) {
            throw ex
        }
    }

    fun fnMessageYesNo(p_strMessage: String, p_strTitle: String, p_strButtonYes: String, p_strBottonNo: String, objListenerYes: () -> Unit, objListenerNo: () -> Unit, p_objContext: Context?) {

        val dlgAlert = AlertDialog.Builder(p_objContext)

        try {

            dlgAlert.setMessage(p_strMessage)
            dlgAlert.setTitle(p_strTitle)
            dlgAlert.setCancelable(true)
            dlgAlert.setPositiveButton(p_strButtonYes,
                    DialogInterface.OnClickListener { dialog, which ->
                        dialog.dismiss()
                        objListenerYes.invoke()
                    })

            dlgAlert.setNegativeButton(p_strBottonNo,
                    DialogInterface.OnClickListener { dialog, which ->
                        dialog.dismiss()
                        objListenerNo.invoke()
                    })

            dlgAlert.create().show()

        } catch (ex: Exception) {
            throw ex
        }

    }

    fun fnMessageYesNo(p_strMessage: String, p_strTitle: String, objListenerYes: () -> Unit, objListenerNo: () -> Unit, p_objContext: Context?) {
        try {
            fnMessageYesNo(p_strMessage, p_strTitle, "Sim", "Não", objListenerYes, objListenerNo, p_objContext)
        } catch (ex: Exception) {
            throw ex
        }

    }

    fun fnMessage(p_strMessage: String, p_strTitulo: String, p_strButton: String, p_objContext: Context?) {

        val dlgAlert = AlertDialog.Builder(p_objContext)

        try {

            dlgAlert.setMessage(p_strMessage)
            dlgAlert.setTitle(p_strTitulo)
            dlgAlert.setCancelable(true)
            dlgAlert.setPositiveButton(p_strButton,
                    DialogInterface.OnClickListener { dialog, which ->
                        dialog.dismiss()
                    })
            dlgAlert.create().show()

        } catch (ex: Exception) {
            throw ex
        }
    }

    fun fnMessage(p_strMessage: String, p_strTitle: String, p_objContext: Context?) {
        try {
            fnMessage(p_strMessage, p_strTitle, "Ok", p_objContext)
        } catch (ex: Exception) {
            throw ex
        }
    }

    fun fnHashMD5(p_strInput: String): String {

        var bytAuxPassword: ByteArray
        var strReturn = ""

        try {

            bytAuxPassword = DigestUtils.md5(p_strInput)

            for (b in bytAuxPassword) {
                strReturn += String.format("%02X", b)
            }

            return strReturn

        } catch (ex: Exception) {
            throw ex
        }
    }

    fun fnInvertColor(p_intColor: Int): Int {

        var intReturn: Int
        var objAuxHSL: FloatArray = kotlin.FloatArray(3)

        try {

            ColorUtils.colorToHSL(p_intColor, objAuxHSL)

            objAuxHSL[0] = objAuxHSL[0] - 180

            if (objAuxHSL[0] < 0) {
                objAuxHSL[0] = 360 + objAuxHSL[0]
            }

            intReturn = ColorUtils.HSLToColor(objAuxHSL)

            return intReturn

        } catch (ex: Exception) {
            throw ex
        }
    }

    fun fnCorFontColor(p_intColor: Int): Int {

        var intReturn: Int
        var dblContrast : Double

        try {

            intReturn = Color.WHITE

            dblContrast = ColorUtils.calculateLuminance(p_intColor)

            if(dblContrast > 0.5){
                intReturn = Color.BLACK
            }

            return intReturn

        } catch (ex: Exception) {
            throw ex
        }
    }

    fun fnFormatNumber(p_dblInput :Float, p_intDecimals : Int) : String{

        var strReturn : String

        try{

            strReturn = java.lang.String.format("%.${p_intDecimals}f", p_dblInput)

            return strReturn

        }catch (ex:Exception){
            throw ex
        }

    }

    fun fnFormatNumber(p_dblInput :Float) : String{
        try{
            return fnFormatNumber(p_dblInput, 2)
       }catch (ex:Exception){
           throw ex
       }

    }

}


