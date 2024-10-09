package org.mathieu.domain.models.location

/**
 * Interface representing a location within a universe or dimension.
 *
 * This interface is used to represent a location in a simplified form, with only the most important
 * information about the location. It can be aggregated in other classes.
 *
 * @property id The unique identifier for the location.
 * @property name The name of the location.
 * @property type The type or category of the location.
 * @property dimension The specific dimension or universe where this location exists.
 */
interface LocationBase {
    val id: Int
    val name: String
    val type: String
    val dimension: String
}