package com.kelvysb.caquitimer.basic

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Ignore
import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

@Entity(tableName = "TimeEvent",
        primaryKeys = arrayOf("WorkId","TaskId", "Id"),
        foreignKeys = arrayOf(ForeignKey(entity = basTask::class,
        parentColumns = arrayOf("WorkId", "Id"),
        childColumns = arrayOf("WorkId", "TaskId"),
        onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = basEventType::class,
        parentColumns = arrayOf("Id"),
        childColumns = arrayOf("Type"),
        onDelete = ForeignKey.RESTRICT)))
class basTimeEvent( @SerializedName("WORKID")
                    var WorkId : Int = 0,

                    @SerializedName("TASKID")
                    var TaskId : Int = 0,

                    @SerializedName("ID")
                    var Id : Int = 0,

                    @SerializedName("RELATEDID")
                    var RelatedId : Int = 0,

                    @SerializedName("TYPE")
                    var Type : String = "",

                    @SerializedName("TIME")
                    var Time : String = "",

                    @SerializedName("NAME")
                    var Name : String = "",

                    @SerializedName("OBSERVATION")
                    var Observation : String = "") {

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
    open fun Deserialize(p_strInput : String) : basTask{

        var objReturn : basTask
        var objGson : Gson

        try {

            objGson = Gson()
            objReturn = objGson.fromJson<basTask>(p_strInput)
            return objReturn

        }catch (ex:Exception){
            throw ex
        }
    }

    /**Properties*/

}