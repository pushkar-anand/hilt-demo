package com.example.hiltdemo.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.hiltdemo.data.AppDB
import com.example.hiltdemo.data.entity.Word
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.concurrent.Executors

@Module
@InstallIn(ApplicationComponent::class)
object DBModule {

    lateinit var appDB: AppDB

    private val executor = Executors.newSingleThreadExecutor()

    @Provides
    fun provideDatabase(
        @ApplicationContext appContext: Context
    ): AppDB {
        appDB = Room.databaseBuilder(
            appContext,
            AppDB::class.java,
            "demo.db"
        ).fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val dao = appDB.wordDao()

                    executor.execute {
                        var word = Word(0, "Hey")
                        dao.insert(word)

                        word = Word(0, "the")
                        dao.insert(word)

                        word = Word(0, "app")
                        dao.insert(word)

                        word = Word(0, "worked")
                        dao.insert(word)
                    }
                }
            })
            .build()

        return appDB
    }

}
