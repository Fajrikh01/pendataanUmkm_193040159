package id.ac.unpas.dataumkm_193040159.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.dataumkm_193040159.model.DataUmkm

@Database(entities = [DataUmkm::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataUmkmDao(): DataUmkmDao
}