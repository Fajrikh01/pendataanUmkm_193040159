package id.ac.unpas.dataumkm_193040159.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataUmkm(
    @PrimaryKey val id: String,
    val nama_umkm: String,
    val jenis_produk: String,
    val contact_person: String,
    val no_telp: String,
    val alamat: String

)
