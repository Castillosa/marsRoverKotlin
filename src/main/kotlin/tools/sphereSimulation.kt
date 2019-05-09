package mars.tools

fun sphereSimulation(positionValue:Int,MovementVector:Int, limit:Int):Int {
    var candidate = MovementVector + positionValue
    var spherePosition  = candidate

    when{
        candidate<0 -> spherePosition = limit + candidate + 1 // adding one to allow point 100
        candidate>limit -> spherePosition = candidate - limit - 1 // substracting one because limit to allow point 0
    }
    return spherePosition
}