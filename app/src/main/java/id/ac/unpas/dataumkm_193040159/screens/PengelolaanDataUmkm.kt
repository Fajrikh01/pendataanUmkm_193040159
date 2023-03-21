package id.ac.unpas.dataumkm_193040159.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.room.Room
import id.ac.unpas.dataumkm_193040159.model.DataUmkm
import id.ac.unpas.dataumkm_193040159.persistences.AppDatabase

@Composable
fun PengelolaanDataUmkm() {
    val context = LocalContext.current

    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "pendataan-umkm"
    ).build()

    val dataUmkmDao = db.dataUmkmDao()

    val list : LiveData<List<DataUmkm>> = dataUmkmDao.loadAll()
    val items : List<DataUmkm> by list.observeAsState(initial = listOf())

    Column(modifier = Modifier.fillMaxWidth()) {
        FormPendataanUmkm(dataUmkmDao)

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = items, itemContent = { item ->

                Row(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()) {
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Nama UMKM", fontSize = 14.sp)
                        Text(text = item.nama_umkm, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Jenis Produk", fontSize = 14.sp)
                        Text(text = item.jenis_produk, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Contact Person", fontSize = 14.sp)
                        Text(text = item.contact_person, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "No Telp", fontSize = 14.sp)
                        Text(text = item.no_telp, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Alamat", fontSize = 14.sp)
                        Text(text = item.alamat, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }

                Divider(modifier = Modifier.fillMaxWidth())
            })
        }
    }
}