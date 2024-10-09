package org.mathieu.domain.repositories

import org.mathieu.domain.models.location.Location

/**
 * Interface for the data layer to interact with locations
 *
 * This interface is used to define the contract between the data layer and the domain layer for locations
 */
interface LocationRepository {

    /**
     * Get a location by its id
     * @param id The id of the location
     * @return [Location] The location
     */
    suspend fun getLocation(id: Int): Location
}