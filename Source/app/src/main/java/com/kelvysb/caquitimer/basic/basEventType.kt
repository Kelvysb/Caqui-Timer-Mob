package com.kelvysb.caquitimer.basic

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

@Entity(tableName = "EventType",
        primaryKeys = arrayOf("Id"))
class basEventType( @SerializedName("ID")
                    var Id : Int = 0,

                    @SerializedName("NAME")
                    var Name : String = "",

                    @SerializedName("TYPE")
                    var Type : String = "") {

    /**Declarations*/



    /**Constructor*/


    /**Functions*/
    @Ignore
    open fun Serialize():String{
        var strReturn : String = ""
        var objGson : Gson

        try {

            objGson = Gson()
            strReturn = objGson.toJson(this)
            return strReturn

        }catch (ex:Exception){
            throw ex
        }
    }

    @Ignore
    open fun Deserialize(p_strInput : String) : basEventType{

        var objReturn : basEventType
        var objGson : Gson

        try {

            objGson = Gson()
            objReturn = objGson.fromJson<basEventType>(p_strInput)
            return objReturn

        }catch (ex:Exception){
            throw ex
        }
    }

    /**Properties*/

}