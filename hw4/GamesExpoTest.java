package hw4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GamesExpoTest {

    @Test
    void canParticipateInStorytelling() {
        GamesExpo.age = 7;
        GamesExpo.gender = "boy";
        assertTrue(GamesExpo.canParticipateInStorytelling(GamesExpo.age, GamesExpo.gender));
    }

    @Test
    void canParticipateInDrawing() {
        GamesExpo.age = 7;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInDrawing(GamesExpo.age, GamesExpo.gender));
    }

    @Test
    void canParticipateInQuiz() {
        GamesExpo.age = (int) (0.5*11);
        GamesExpo.gender = "boy";
        assertFalse(GamesExpo.canParticipateInQuiz(GamesExpo.age, GamesExpo.gender));
    }
    @Test
    void canParticipateInQuiz2() {
        GamesExpo.age = 12;
        GamesExpo.gender = "boy";
        assertTrue(GamesExpo.canParticipateInQuiz(GamesExpo.age, GamesExpo.gender));
    }

    @Test
    void canParticipateInEssayWriting() {
        GamesExpo.age = (int)(0.5*10);
        GamesExpo.gender = "girl";
        assertFalse(GamesExpo.canParticipateInEssayWriting(GamesExpo.age, GamesExpo.gender));
    }

    @Test
    void canParticipateInEssayWriting2() {
        GamesExpo.age = 12;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInEssayWriting(GamesExpo.age, GamesExpo.gender));
    }

    @Test
    void canParticipateInRhyming() {
        GamesExpo.age = 7;
        assertFalse(GamesExpo.canParticipateInRhyming(GamesExpo.age));
    }

    @Test
    void canParticipateInRhyming2() {
        GamesExpo.age = 5;
        assertTrue(GamesExpo.canParticipateInRhyming(GamesExpo.age));
    }

    @Test
    void canParticipateInPoetry() {
        GamesExpo.age = 19;
        assertFalse(GamesExpo.canParticipateInPoetry(GamesExpo.age));
    }

    @Test
    void canParticipateInPoetry2() {
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