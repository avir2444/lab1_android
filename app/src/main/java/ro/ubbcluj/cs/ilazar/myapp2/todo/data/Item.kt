package ro.ubbcluj.cs.ilazar.myapp2.todo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jucatori")
data class Item(
    @PrimaryKey @ColumnInfo(name = "_id") val _id: String,
    @ColumnInfo(name = "nume") var nume: String,
    @ColumnInfo(name = "varsta") var varsta: String,
    @ColumnInfo(name = "echipa") var echipa: String,
    @ColumnInfo(name = "pozitie") var pozitie: String
) {
    override fun toString(): String = nume
}