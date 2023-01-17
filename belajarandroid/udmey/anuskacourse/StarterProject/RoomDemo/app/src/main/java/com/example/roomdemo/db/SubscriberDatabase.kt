package com.example.roomdemo.db

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec

@Database(entities = [Subscriber::class],
    version = 2,
    autoMigrations = [
        AutoMigration(from = 1, to = 2, spec = SubscriberDatabase.Migration1to2::class)
    ]
)
abstract class SubscriberDatabase : RoomDatabase() {

    abstract val subscriberDao : SubscriberDao
//
    @RenameColumn(tableName = "subscriber_data_table", fromColumnName = "subscriber_id", toColumnName = "subscriber_name")
    @RenameColumn(tableName = "subscriber_data_table", fromColumnName = "subscriber_name", toColumnName = "subscriber_id")
    class Migration1to2 : AutoMigrationSpec

    companion object{
        @Volatile
        private var INSTANCE : SubscriberDatabase? = null
            fun getInstance(context: Context):SubscriberDatabase{
                synchronized(this){
                    var instance = INSTANCE
                        if(instance == null){
                            instance = Room.databaseBuilder(
                                context.applicationContext,
                                SubscriberDatabase::class.java,
                                "subscriber_data_database"
                            ).build()
                            INSTANCE = instance
                        }
                    return instance
                }
            }
    }

}