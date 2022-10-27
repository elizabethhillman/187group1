package hw4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GamesExpoTest {

    @Test
    void canParticipateInStorytelling() {
        GamesExpo.age = 8;
        GamesExpo.gender = "boy";
        assertTrue(GamesExpo.canParticipateInStorytelling(GamesExpo.age, GamesExpo.gender));
    }

    @Test
    void canParticipateInDrawing() {
        GamesExpo.age = 8;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInDrawing(GamesExpo.age, GamesExpo.gender));
    }

    @Test
    void canParticipateInQuiz() {
        GamesExpo.age = 12;
        GamesExpo.gender = "boy";
        assertTrue(GamesExpo.canParticipateInQuiz(GamesExpo.age, GamesExpo.gender));
    }

    @Test
    void canParticipateInEssayWriting() {
        GamesExpo.age = 12;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInEssayWriting(GamesExpo.age, GamesExpo.gender));
    }

    @Test
    void canParticipateInRhyming() {
        GamesExpo.age = 5;
        assertTrue(GamesExpo.canParticipateInRhyming(GamesExpo.age));
    }

    @Test
    void canParticipateInPoetry() {
        GamesExpo.age = 21;
        assertTrue(GamesExpo.canParticipateInPoetry(GamesExpo.age));
    }

    @Test
    void canNotParticipate()
    {
        GamesExpo.age = 17;
        assertTrue(GamesExpo.canNotParticipate(GamesExpo.age));
    }
}