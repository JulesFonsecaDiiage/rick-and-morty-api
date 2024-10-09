package org.mathieu.data.local

import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.mathieu.data.local.objects.LocationObject

/**
 * Local data source for location data. This class provides methods to interact with the local
 * @param database The Realm database instance used to interact with the local data source.
 */
internal class LocationLocal(private val database: RealmDatabase) {

    suspend fun getLocations(): Flow<List<LocationObject>> = database.use {
        query<LocationObject>().find().asFlow().map { it.list }
    }

    suspend fun getLocation(id: Int): LocationObject? = database.use {
        query<LocationObject>("id == $id").first().find()
    }

    suspend fun insert(location: LocationObject) {
        database.write {
            copyToRealm(location, UpdatePolicy.ALL)
        }
    }
}