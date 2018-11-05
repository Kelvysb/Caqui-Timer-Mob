package com.kelvysb.caquitimer.bo

import android.content.Context
import android.util.Log
import com.kelvysb.caquitimer.dao.CaquiTimerDAOProvider
import com.kelvysb.caquitimer.dao.CaquiTimerRepository
import com.kelvysb.caquitimer.util.ApplicationContextProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object CaquiTimerBO {

    /*Declarations*/
    var objRepository: CaquiTimerRepository? = null


    /*Construcotor*/



    /*Functions*/
    @Singleton
    @Provides
    fun Initialize() : Boolean{

        var blnReturn : Boolean = false

        try {

            objRepository = CaquiTimerDAOProvider().provideDatabase(ApplicationContextProvider.getContext())




            return blnReturn

        }catch(ex:Exception){
            objRepository = null
            throw ex
        }
    }


    /*Properties*/
    @Singleton
    val STATE_KEY : String = "STATECAQUI"
}