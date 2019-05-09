import mars.commnads.ForwardCommand
import mars.rover.Rover
fun main(){
    //Application entry point
    var r = Rover(0,0,"N")
    r.execute(arrayOf(ForwardCommand()))
    println(r.y)
}