package org.mathieu.data.repositories

import org.mathieu.data.local.LocationLocal
import org.mathieu.data.local.objects.toModel
import org.mathieu.data.local.objects.toRealmObject
import org.mathieu.data.remote.LocationApi
import org.mathieu.domain.models.location.Location
import org.mathieu.domain.repositories.LocationRepository

internal class LocationRepositoryImpl(
    private val locationLocal: LocationLocal,
    private val locationAPI: LocationApi
) : LocationRepository {

    override suspend fun getLocation(id: Int): Location =
        locationLocal.getLocation(id)?.toModel() ?:
            locationAPI.getLocation(id)?.let {
                response -> val obj = response.toRealmObject()
                locationLocal.insert(obj)
                obj.toModel()
            }
        ?: throw Exception("Location not found")
}