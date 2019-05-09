package com.ddubson.junit5

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals


import mars.rover.Rover

class RoverTest {
    companion object {
        @BeforeAll
        @JvmStatic
        fun beforeAllTestCases() {
            println("Runs once before all test cases.")
        }

        @AfterAll
        @JvmStatic
        fun afterAllTestCases() {
            println("Runs once after all test cases.")
        }
    }

    @Test
    fun creationTestCase() {

        var rover = Rover(0,0,"S")
        assertEquals(0, rover.x)
        assertEquals(0, rover.y)
        assertEquals("S", rover.orientation, "S orientation expeted, getted ${rover.orientation}")
    }

    @Test
    fun TurnRightCommandTest() {

        var rover = Rover(0, 0, "N")
        rover.execute(arrayOf("R"))
        assertEquals("E", rover.orientation)

        rover.execute(arrayOf("R"))
        assertEquals("S", rover.orientation)

        rover.execute(arrayOf("R"))
        assertEquals("W", rover.orientation)

        rover.execute(arrayOf("R"))
        assertEquals("N", rover.orientation)
    }

    @Test
    fun TurnLeftCommandTest() {

        var rover = Rover(0,0,"N")
        rover.execute(arrayOf("L"))
        assertEquals("W", rover.orientation, "W orientation expeted, getted ${rover.orientation}")

        rover.execute(arrayOf("L"))
        assertEquals("S", rover.orientation)

        rover.execute(arrayOf("L"))
        assertEquals("E", rover.orientation)

        rover.execute(arrayOf("L"))
        assertEquals("N", rover.orientation)
    }

    @Test
    fun ForwardCommandTest() {
        var rover = Rover(1,1,"N")
        rover.execute(arrayOf("F"))
        assertEquals(2, rover.y)

        rover = Rover(1,1,"E")
        rover.execute(arrayOf("F"))
        assertEquals(2, rover.x)

        rover = Rover(1,1,"S")
        rover.execute(arrayOf("F"))
        assertEquals(0, rover.y)

        rover = Rover(1,1,"W")
        rover.execute(arrayOf("F"))
        assertEquals(0, rover.x)
    }
    @Test
    fun BackwardCommandTest() {
        var rover = Rover(1,1,"N")
        rover.execute(arrayOf("B"))
        assertEquals(0, rover.y)

        rover = Rover(1,1,"E")
        rover.execute(arrayOf("B"))
        assertEquals(0, rover.x)

        rover = Rover(1,1,"S")
        rover.execute(arrayOf("B"))
        assertEquals(2, rover.y)

        rover = Rover(1,1,"W")
        rover.execute(arrayOf("B"))
        assertEquals(2, rover.x)
    }

    @Test
    fun MultiCommandTest() {
        var rover = Rover(2,2,"N")
        rover.execute(arrayOf("B","F","R","F"))
        assertEquals(2, rover.y)
        assertEquals(3, rover.x)
        assertEquals("E", rover.orientation)
    }

    @Test
    fun SphereSimulutaionTest() {
        var rover = Rover(100,100,"N")
        rover.execute(arrayOf("F","R","F"))
        assertEquals(0, rover.y)
        assertEquals(0, rover.x)

        rover = Rover(100,100,"S")
        rover.execute(arrayOf("B","R","B"))
        assertEquals(0, rover.y)
        assertEquals(0, rover.x)


        rover = Rover(0,0,"N")
        rover.execute(arrayOf("B","R","B"))
        assertEquals(100, rover.y)
        assertEquals(100, rover.x)

        rover = Rover(0,0,"S")
        rover.execute(arrayOf("F","R","F"))
        assertEquals(100, rover.y)
        assertEquals(100, rover.x)
    }
}