package com.kelvysb.caquitimer.util

import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

/**
 * Created by kelvys on 18/09/2017.
 */
class clsMessage{

    //Declarations
    //-----------------------------------------------

    @SerializedName("TYPE")
    private var strType: String = ""

    @SerializedName("STATUS")
    private var strStatus: String = ""

    @SerializedName("MESSAGE")
    private var strMessage: String = ""

    @SerializedName("DATA")
    private var strData: List<String> = emptyList()

    @SerializedName("PARAMETERS")
    private var objPatameters: List<clsParameter> = emptyList()
    //-----------------------------------------------

    //Constructor
    //-----------------------------------------------
    fun clsMessage(p_strEntrada : String): clsMessage{
        try{
            return clsMessage().Deserialize(p_strEntrada)
        }catch (ex:Exception){
            throw ex
        }
    }
    init {
        try {
            strType = ""
            strData = mutableListOf()
            objPatameters = mutableListOf()
        }catch (ex:Exception){
            throw ex
        }
    }
    //-----------------------------------------------

    //Funções
    //-----------------------------------------------
    fun Clone(): clsMessage{

        var objRetorno: clsMessage


        try {

            objRetorno = clsMessage(Serialize())
            return objRetorno

        }catch (ex:Exception){
            throw ex
        }
    }

    fun Serialize():String{
        var strRetorno : String = ""
        var objGson : Gson

        try {

            objGson = Gson()
            strRetorno = objGson.toJson(this)
            return strRetorno

        }catch (ex:Exception){
            throw ex
        }
    }

    fun Deserialize(p_strEntrada : String) : clsMessage{

        var objReturn : clsMessage
        var objGson : Gson

        try {

            objGson = Gson()
            objReturn = objGson.fromJson<clsMessage>(p_strEntrada)
            return objReturn

        }catch (ex:Exception){
            throw ex
        }
    }

    fun getParameter(p_strChave : String) : String{

        var strRetorno = ""
        var intAuxIndex : Int

        try {

            intAuxIndex =  objPatameters.indexOfFirst{Para : clsParameter ->  Para.Key.trim().toUpperCase() == p_strChave.trim().toUpperCase()}

            if (intAuxIndex != -1){
                strRetorno = objPatameters[intAuxIndex].Value

            }

            return strRetorno

        }catch (ex:Exception){
            throw ex
        }
    }
    //-----------------------------------------------

    //Properties
    //-----------------------------------------------
    var Type : String
        get() = strType
        set(value) {
            strType = value
        }
    var Data : List<String>
        get() = strData
        set(value) {
            strData = value
        }
    var Parameters : List<clsParameter>
        get() = objPatameters
        set(value) {
            objPatameters = value
        }
    var Status : String
        get() = strStatus
        set(value) {
            strStatus = value
        }
    var Message :  String
        get() = strMessage
        set(value) {
            strMessage = value
        }
    //-----------------------------------------------
}

class clsParameter(p_strKey : String, p_strType: String, p_strValue : String){

    //Declarations
    //-----------------------------------------------
    @SerializedName("KEY")
    private var strKey: String = ""

    @SerializedName("TYPE")
    private var strType: String = ""

    @SerializedName("VALUE")
    private var strValue: String = ""
    //-----------------------------------------------

    //Construtor
    //-----------------------------------------------
    fun clsParameter(p_strKey : String, p_strValue : String): clsParameter = clsParameter(p_strKey, "", p_strValue)
    fun clsParameter(p_strKey : String): clsParameter = clsParameter(p_strKey, "",  "")
    init {
        try {

            strKey = p_strKey
            strType = p_strType
            strValue = p_strValue

        }catch (ex: Exception){
            throw ex
        }

    }
    //-----------------------------------------------

    //Functions
    //-----------------------------------------------
    fun Clone(): clsParameter  {
        var objReturn: clsParameter
        try {
            objReturn = clsParameter(strKey, strType, strValue)
            return objReturn
        }catch (ex:Exception){
            throw ex
        }
    }
    //-----------------------------------------------

    //Properties
    //-----------------------------------------------
    public var Key: String
        get() = strKey
        set(value) {
            strKey = value
        }

    public var Value : String
        get() = strValue
        set(value) {
            strValue = value
        }

    public var Type : String
        get() = strType
        set(value) {
            strType = value
        }
    //-----------------------------------------------
}

class clsDictionary{
    //Declarations
    //-----------------------------------------------
    @SerializedName("KEYS")
    var Keys: List<String> = emptyList()

    @SerializedName("VALUES")
    var Values : List<String> = emptyList()
    //-----------------------------------------------

    //Construtor
    //-----------------------------------------------
    init {

    }
    //-----------------------------------------------

    //functions
    //-----------------------------------------------
    fun Serialize():String{
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

    fun Deserialize(p_strInput : String) : clsDictionary{

        var objReturn : clsDictionary
        var objGson : Gson

        try {

            objGson = Gson()
            objReturn = objGson.fromJson<clsDictionary>(p_strInput)
            return objReturn

        }catch (ex:Exception){
            throw ex
        }
    }

    fun getValue(p_strChave : String) : String{

        var strReturn = ""
        var intAuxIndex : Int

        try {

            intAuxIndex =  Keys.indexOfFirst{ auxChave ->  auxChave.trim().toUpperCase() == p_strChave.trim().toUpperCase()}

            if (intAuxIndex != -1){
                strReturn = Values[intAuxIndex]
            }

            return strReturn

        }catch (ex:Exception){
            throw ex
        }
    }
    //-----------------------------------------------

}