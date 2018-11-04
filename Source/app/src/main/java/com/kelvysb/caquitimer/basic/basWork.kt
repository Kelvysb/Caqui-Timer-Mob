package com.kelvysb.caquitimer.basic

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Work",
        primaryKeys = arrayOf("Id"))
class basWork(  @SerializedName("ID")
                var Id : Int = 0,

                @SerializedName("NAME")
                var Name : String = "",

                @SerializedName("DESCRIPTION")
                var Description : String = "",

                @SerializedName("START")
                var Start : String = "",

                @SerializedName("FINISH")
                var Finish : String = "",

                @SerializedName("STATE")
                var State : String = "") {

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
    open fun Deserialize(p_strInput : String) : basWork{

        var objReturn : basWork
        var objGson : Gson

        try {

            objGson = Gson()
            objReturn = objGson.fromJson<basWork>(p_strInput)
            return objReturn

        }catch (ex:Exception){
            throw ex
        }
    }

    /**Properties*/

}