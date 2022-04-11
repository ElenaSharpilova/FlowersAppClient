package android.example.flowerschemistry.data.database

import android.content.Context
import android.example.flowerschemistry.data.models.BouquetCatalogItemItem
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(entities = [BouquetCatalogItemItem::class], version = 1, exportSchema = false)
abstract class LocalDataBase : RoomDatabase() {

    /*abstract fun databaseDao(): DatabaseDAO

    companion object {
        @Volatile
        private var INSTANCE: LocalDataBase? = null

        fun getDatabase(context: Context): LocalDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocalDataBase::class.java,
                    "cart_bouquets"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }*/
}