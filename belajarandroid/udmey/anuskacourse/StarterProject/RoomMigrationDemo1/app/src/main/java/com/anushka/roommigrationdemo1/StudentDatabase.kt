package com.anushka.roommigrationdemo1

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.DeleteColumn
import androidx.room.RenameColumn
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec

@Database(entities = [Student::class],
    version = 5,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3),
        AutoMigration(from = 3, to = 4, spec = StudentDatabase.Migration3to4::class),
        AutoMigration(from = 4, to = 5, spec = StudentDatabase.Migration4to6::class)
    ]
    //exportSchema = false
    )
abstract class StudentDatabase : RoomDatabase() {

    abstract val subscriberDAO : StudentDAO

    @RenameColumn(tableName = "student_info", fromColumnName = "student_course", toColumnName = "course_name")
    class Migration3to4 : AutoMigrationSpec

    @DeleteColumn(tableName = "student_info", columnName = "student_email")
    class Migration4to6 : AutoMigrationSpec

    companion object{
      @Volatile
      private var INSTANCE : StudentDatabase? = null
          fun getInstance(context: Context):StudentDatabase{
              synchronized(this){
                  var instance = INSTANCE
                      if(instance==null){
                          instance = Room.databaseBuilder(
                                 context.applicationContext,
                              StudentDatabase::class.java,
                                 "student_data_database"
                          ).build()
                          INSTANCE = instance
                      }
                  return instance
              }
          }
    }
}

