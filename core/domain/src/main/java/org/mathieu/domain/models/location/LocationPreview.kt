package org.mathieu.domain.models.location

/**
 * Represents a specific location within a universe or dimension.
 *
 * @property id The unique identifier for the location.
 * @property name The name of the location.
 * @property type The type or category of the location.
 * @property dimension The specific dimension or universe where this location exists.
 */
class LocationPreview(
    override val id: Int,
    override val name: String,
    override val type: String,
    override val dimension: String
) : LocationBase
