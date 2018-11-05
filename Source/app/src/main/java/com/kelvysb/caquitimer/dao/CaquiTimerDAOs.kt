package com.kelvysb.caquitimer.dao

import android.arch.persistence.room.*
import android.content.Context
import com.kelvysb.caquitimer.basic.basEventType
import com.kelvysb.caquitimer.basic.basTask
import com.kelvysb.caquitimer.basic.basTimeEvent
import com.kelvysb.caquitimer.basic.basWork
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CaquiTimerDAOProvider {

    @Singleton
    @Provides
    fun provideDatabase(context: Context) : CaquiTimerRepository {

        return Room.databaseBuilder(
            context,
            CaquiTimerRepository::class.java,
            "caquitimer.db"
        ).fallbackToDestructiveMigration().build()

    }

    @Singleton
    @Provides
    fun EventType(db: CaquiTimerRepository) : IEventTypeDAO {
        return db.EventTypeDAO()
    }

    @Singleton
    @Provides
    fun Work(db: CaquiTimerRepository) : IWorkDAO {
        return db.WorkDAO()
    }

    @Singleton
    @Provides
    fun Task(db: CaquiTimerRepository) : ITaskDAO {
        return db.TaskDAO()
    }

    @Singleton
    @Provides
    fun TimeEvent(db: CaquiTimerRepository) : ITimeEventDAO {
        return db.TimeEventDAO()
    }

}

@Database(entities = arrayOf(basEventType::class,basWork::class,
            basTask::class, basTimeEvent::class), version = 1)

abstract class CaquiTimerRepository : RoomDatabase() {
    abstract fun EventTypeDAO(): IEventTypeDAO
    abstract fun WorkDAO(): IWorkDAO
    abstract fun TaskDAO(): ITaskDAO
    abstract fun TimeEventDAO(): ITimeEventDAO
}

@Dao
interface IEventTypeDAO{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun Add(Objeto : basEventType)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun Add(Objetos : List<basEventType>)

    @Update
    fun Update(Objeto : basEventType)

    @Delete
    fun sbDelete(Objeto : basEventType)

    @Update
    fun Update(Objeto : List<basEventType>)

    @Query("Select * from EventType")
    fun SelectAll() : List<basEventType>

    @Query("Select * from EventType where Id = :p_intId")
    fun SelectById(p_intId : Int) : List<basEventType>

    @Query("Select COUNT(*) from EventType")
    fun fnQtdReg() : List<Int>

}

@Dao
interface IWorkDAO{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun Add(Objeto : basWork)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun Add(Objetos : List<basWork>)

    @Update
    fun Update(Objeto : basWork)

    @Delete
    fun sbDelete(Objeto : basWork)

    @Update
    fun Update(Objeto : List<basWork>)

    @Query("Select * from Work")
    fun SelectAll() : List<basWork>

    @Query("Select * from Work where Id = :p_intId")
    fun SelectById(p_intId : Int) : List<basWork>

    @Query("Select * from Work where State = :p_strState")
    fun SelectByState(p_strState : String) : List<basWork>

    @Query("Select * from Work where Start = :p_strStart")
    fun SelectByStart(p_strStart : String) : List<basWork>

    @Query("Select COUNT(*) from Work")
    fun fnQtdReg() : List<Int>

}

@Dao
interface ITaskDAO{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun Add(Objeto : basTask)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun Add(Objetos : List<basTask>)

    @Update
    fun Update(Objeto : basTask)

    @Delete
    fun sbDelete(Objeto : basTask)

    @Update
    fun Update(Objeto : List<basTask>)

    @Query("Select * from Task")
    fun SelectAll() : List<basTask>

    @Query("Select * from Task where WorkId = :p_intWorkId")
    fun SelectByWorkId( p_intWorkId : Int) : List<basTask>

    @Query("Select * from Task where WorkId = :p_intWorkId and Id = :p_intId")
    fun SelectById( p_intWorkId : Int, p_intId : Int) : List<basTask>

    @Query("Select * from Task where State = :p_strState")
    fun SelectByState(p_strState : String) : List<basTask>

    @Query("Select * from Task where Start = :p_strStart")
    fun SelectByStart(p_strStart : String) : List<basTask>

    @Query("Select COUNT(*) from Task")
    fun fnQtdReg() : List<Int>

}

@Dao
interface ITimeEventDAO{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun Add(Objeto : basTimeEvent)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun Add(Objetos : List<basTimeEvent>)

    @Update
    fun Update(Objeto : basTimeEvent)

    @Delete
    fun sbDelete(Objeto : basTimeEvent)

    @Update
    fun Update(Objeto : List<basTimeEvent>)

    @Query("Select * from TimeEvent")
    fun SelectAll() : List<basTimeEvent>

    @Query("Select * from TimeEvent where WorkId = :p_intWorkId")
    fun SelectByWorkId(p_intWorkId : Int) : List<basTimeEvent>

    @Query("Select * from TimeEvent where WorkId = :p_intWorkId and TaskId = :p_intTaskId")
    fun SelectByTaskId(p_intWorkId : Int, p_intTaskId : Int) : List<basTimeEvent>

    @Query("Select * from TimeEvent where WorkId = :p_intWorkId and TaskId = :p_intTaskId and Id = :p_intId")
    fun SelectById( p_intWorkId : Int, p_intTaskId : Int, p_intId : Int) : List<basTimeEvent>

    @Query("Select COUNT(*) from TimeEvent")
    fun fnQtdReg() : List<Int>

}
