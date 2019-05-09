package com.ddubson.junit5

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals


import mars.rover.Rover
import mars.commnads.*

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
        rover.execute(arrayOf(TurnRightCommand()))
        assertEquals("E", rover.orientation, "E orientation expeted, getted ${rover.orientation}")
    }

    @Test
    fun TurnLeftCommandTest() {

        var rover = Rover(0,0,"N")
        rover.execute(arrayOf(TurnLeftCommand()))
        assertEquals("W", rover.orientation, "W orientation expeted, getted ${rover.orientation}")
    }

    @Test
    fun ForwardCommandTest() {
        var rover = Rover(1,1,"N")
        rover.execute(arrayOf(ForwardCommand()))
        assertEquals(2, rover.y)

        rover = Rover(1,1,"E")
        rover.execute(arrayOf(ForwardCommand()))
        assertEquals(2, rover.x)

        rover = Rover(1,1,"S")
        rover.execute(arrayOf(ForwardCommand()))
        assertEquals(0, rover.y)

        rover = Rover(1,1,"W")
        rover.execute(arrayOf(ForwardCommand()))
        assertEquals(0, rover.x)
    }
    @Test
    fun BackwardCommandTest() {
        var rover = Rover(1,1,"N")
        rover.execute(arrayOf(BackwardCommand()))
        assertEquals(0, rover.y)

        rover = Rover(1,1,"E")
        rover.execute(arrayOf(BackwardCommand()))
        assertEquals(0, rover.x)

        rover = Rover(1,1,"S")
        rover.execute(arrayOf(BackwardCommand()))
        assertEquals(2, rover.y)

        rover = Rover(1,1,"W")
        rover.execute(arrayOf(BackwardCommand()))
        assertEquals(2, rover.x)
    }
}