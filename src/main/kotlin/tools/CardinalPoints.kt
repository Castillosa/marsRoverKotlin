package mars.tools

import java.awt.ComponentOrientation

enum class CardinalPoints(val degrees: Int) {
    N(0),
    E(90),
    S(180),
    W(270);

    companion object {
        fun getOrientation(degrees: Int): String =  requireNotNull(values().find { it.degrees == degrees }?.name) { "No Orientation implemented for $degrees degrees" }
        fun getDegrees(orientation: String): Int =  requireNotNull(valueOf(orientation).degrees) { "No Orientation implemented for $orientation" }
    }
}