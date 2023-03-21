package id.ac.unpas.dataumkm_193040159.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import id.ac.unpas.dataumkm_193040159.model.DataUmkm
import id.ac.unpas.dataumkm_193040159.persistences.DataUmkmDao
import id.ac.unpas.dataumkm_193040159.ui.theme.Green1
import id.ac.unpas.dataumkm_193040159.ui.theme.Red1
import kotlinx.coroutines.launch

@Composable
fun FormPendataanUmkm(dataUmkmDao: DataUmkmDao) {
    val nama_umkm = remember { mutableStateOf(TextFieldValue(""))}
    val jenis_produk = remember { mutableStateOf(TextFieldValue(""))}
    val contact_person = remember { mutableStateOf(TextFieldValue(""))}
    val no_telp = remember { mutableStateOf(TextFieldValue(""))}
    val alamat = remember { mutableStateOf(TextFieldValue(""))}

    val scope = rememberCoroutineScope()

    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {

        OutlinedTextField(
            label = { Text(text = "Nama UMKM") },
            value = nama_umkm.value,
            onValueChange = {
                nama_umkm.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Nama UMKM")}
        )

        OutlinedTextField(
            label = { Text(text = "Jenis Produk") },
            value = jenis_produk.value,
            onValueChange = {
                jenis_produk.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Jenis Produk")}
        )

        OutlinedTextField(
            label = { Text(text = "Contact Person") },
            value = contact_person.value,
            onValueChange = {
                contact_person.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Nama") }
        )

        OutlinedTextField(
            label = { Text(text = "No Telp") },
            value = no_telp.value,
            onValueChange = {
                no_telp.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            placeholder = { Text(text = "08xxxxxxxxxx") }
        )

        OutlinedTextField(
            label = { Text(text = "Alamat") },
            value = alamat.value,
            onValueChange = {
                alamat.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Alamat") }
        )

        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Green1,
            contentColor = Red1
        )

        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Red1,
            contentColor = Green1
        )

        Row (modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                val id = uuid4().toString()
                val item = DataUmkm(id, nama_umkm.value.text, jenis_produk.value.text, contact_person.value.text, no_telp.value.text, alamat.value.text)
                scope.launch {
                    dataUmkmDao.insertAll(item)
                }
                nama_umkm.value = TextFieldValue("")
                jenis_produk.value = TextFieldValue("")
                contact_person.value = TextFieldValue("")
                no_telp.value = TextFieldValue("")
                alamat.value = TextFieldValue("")
            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }

            Button(modifier = Modifier.weight(5f), onClick = {
                nama_umkm.value = TextFieldValue("")
                jenis_produk.value = TextFieldValue("")
                contact_person.value = TextFieldValue("")
                no_telp.value = TextFieldValue("")
                alamat.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}