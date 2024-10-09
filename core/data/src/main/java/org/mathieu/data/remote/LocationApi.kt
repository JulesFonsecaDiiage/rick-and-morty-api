package org.mathieu.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import org.mathieu.data.remote.responses.LocationResponse

internal class LocationApi(private val client : HttpClient) {

    /**
     * Get a location by its id.
     *
     * @param id The id of the location
     * @return [LocationResponse] The location
     */
    suspend fun getLocation(id: Int): LocationResponse? =
        client.get("location/$id").accept(HttpStatusCode.OK, HttpStatusCode.NotFound).body()
}