package learnyouakotlin.part2

import learnyouakotlin.part1.Session
import learnyouakotlin.part1.Slots
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class SessionsTests {

    companion object {
        val learnYouAKotlin = Session("Learn you a kotlin", "for all the good it will do you", Slots(1, 1))
        val refactoringToStreams = Session("Refactoring to Streams", null, Slots(2, 2))
    }

    val sessions = listOf(learnYouAKotlin, refactoringToStreams)

    @Test
    fun nulls() {
        val session: Session? = Sessions.findWithTitle(sessions, "learn you a kotlin")

        val notNullSession = session as Session
        assertEquals("for all the good it will do you", notNullSession.subtitle)
        assertEquals("for all the good it will do you", session.subtitle)
    }

    @Test
    fun null_safe_access() {
        assertEquals("for all the good it will do you", Sessions.subtitleOf(learnYouAKotlin))
        assertNull(Sessions.subtitleOf(null))
    }

    @Test
    fun elvis() {
        assertEquals("for all the good it will do you", Sessions.subtitleOrPrompt(learnYouAKotlin))
        assertEquals("click to enter subtitle", Sessions.subtitleOrPrompt(refactoringToStreams))
    }
}
