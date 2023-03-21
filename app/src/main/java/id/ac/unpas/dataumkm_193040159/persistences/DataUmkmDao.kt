package id.ac.unpas.dataumkm_193040159.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.unpas.dataumkm_193040159.model.DataUmkm

@Dao
interface DataUmkmDao {
    @Query("SELECT * FROM DataUmkm")
    fun loadAll(): LiveData<List<DataUmkm>>

    @Query("SELECT * FROM DataUmkm WHERE id = :id")
    fun find(id: String) : DataUmkm?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: DataUmkm)

    @Delete
    fun delete(item: DataUmkm)
}