package org.mathieu.domain.models.location

import org.mathieu.domain.models.character.Character

/**
 * Represents a specific location within a universe or dimension.
 *
 * @property id The unique identifier for the location.
 * @property name The name of the location.
 * @property type The type or category of the location.
 * @property dimension The specific dimension or universe where this location exists.
 * @property residents A list of [Character] who have been known to reside or appear in this location.
 */
data class Location(
    override val id: Int,
    override val name: String,
    override val type: String,
    override val dimension: String,
    val residents: List<Character>
) : LocationBase