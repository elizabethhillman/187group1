package hw4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GamesExpoTest {

    //Test 1: If the user is a boy and has an age on the inclusive boundary, then they should be able to compete in story telling
    @Test
    void canParticipateInStorytelling() {
        GamesExpo.age = 7;
        GamesExpo.gender = "boy";
        assertTrue(GamesExpo.canParticipateInStorytelling(GamesExpo.age, GamesExpo.gender));
    }

    //Test 2: If the user is a girls and has an age on the inclusive boundary, then they should be able to compete in drawing
    @Test
    void canParticipateInDrawing() {
        GamesExpo.age = 7;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInDrawing(GamesExpo.age, GamesExpo.gender));
    }

    //Test 3: If the constant coefficients of the variable age take up the wrong value, then the user’s age will no longer be within the range to be eligible to compete in quiz
    @Test
    void canParticipateInQuiz() {
        GamesExpo.age = (int) (0.5*11);
        GamesExpo.gender = "boy";
        assertFalse(GamesExpo.canParticipateInQuiz(GamesExpo.age, GamesExpo.gender));
    }

    //Test 4: If the user is a boy and is within the boundary domain of age 11-15 years old, then they should be able to compete in quiz
    @Test
    void canParticipateInQuiz2() {
        GamesExpo.age = 12;
        GamesExpo.gender = "boy";
        assertTrue(GamesExpo.canParticipateInQuiz(GamesExpo.age, GamesExpo.gender));
    }

    //Test 5: If the constant coefficients of the variable age take up the wrong value, then the user’s age will no longer be within the range to be eligible to compete in essay writing
    @Test
    void canParticipateInEssayWriting() {
        GamesExpo.age = (int)(0.5*10);
        GamesExpo.gender = "girl";
        assertFalse(GamesExpo.canParticipateInEssayWriting(GamesExpo.age, GamesExpo.gender));
    }

    //Test 6: If the user is a girl and is within the boundary domain of age 10-15 years old, then they should be able to compete in essay writing
    @Test
    void canParticipateInEssayWriting2() {
        GamesExpo.age = 12;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInEssayWriting(GamesExpo.age, GamesExpo.gender));
    }

    //Test 7: If the user is of age greater than 6, then they should not be able to compete in rhyming
    @Test
    void canParticipateInRhyming() {
        GamesExpo.age = 7;
        assertFalse(GamesExpo.canParticipateInRhyming(GamesExpo.age));
    }

    //Test 8: If the user is of age less than 6, then they should be able to compete in rhyming
    @Test
    void canParticipateInRhyming2() {
        GamesExpo.age = 5;
        assertTrue(GamesExpo.canParticipateInRhyming(GamesExpo.age));
    }

    //Test 9: If the user is of age less than 20, then they should not be able to compete in rhyming
    @Test
    void canParticipateInPoetry() {
        GamesExpo.age = 19;
        assertFalse(GamesExpo.canParticipateInPoetry(GamesExpo.age));
    }

    //Test 10: If the user is of age greater than 20, then they should be able to compete in rhyming
    @Test
    void canParticipateInPoetry2() {
        GamesExpo.age = 21;
        assertTrue(GamesExpo.canParticipateInPoetry(GamesExpo.age));
    }

    //Test 11: If the user is of age 17-19, then there are no competitions that they can be a part of
    @Test
    void canNotParticipate()
    {
        GamesExpo.age = 17;
        assertTrue(GamesExpo.canNotParticipate(GamesExpo.age));
    }

    @Test
    void boundaryVAStoryTelling() {
        GamesExpo.age = 6;
        GamesExpo.gender = "boy";
        assertFalse(GamesExpo.canParticipateInStorytelling(GamesExpo.age, GamesExpo.gender));

        GamesExpo.age = 7;
        GamesExpo.gender = "boy";
        assertTrue(GamesExpo.canParticipateInStorytelling(GamesExpo.age, GamesExpo.gender));

        GamesExpo.age = 11;
        GamesExpo.gender = "boy";
        assertFalse(GamesExpo.canParticipateInStorytelling(GamesExpo.age, GamesExpo.gender));

        GamesExpo.age = 10;
        GamesExpo.gender = "boy";
        assertTrue(GamesExpo.canParticipateInStorytelling(GamesExpo.age, GamesExpo.gender));


    }

    @Test
    void boundaryVADrawing() {
        GamesExpo.age = 6;
        GamesExpo.gender = "girl";
        assertFalse(GamesExpo.canParticipateInDrawing(GamesExpo.age, GamesExpo.gender));

        GamesExpo.age = 7;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInDrawing(GamesExpo.age, GamesExpo.gender));

        GamesExpo.age = 11;
        GamesExpo.gender = "girl";
        assertFalse(GamesExpo.canParticipateInDrawing(GamesExpo.age, GamesExpo.gender));

        GamesExpo.age = 10;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInDrawing(GamesExpo.age, GamesExpo.gender));

    }

    @Test
    void boundaryVARhyming() {
        GamesExpo.age = -1;
        assertFalse(GamesExpo.canParticipateInRhyming(GamesExpo.age));

        GamesExpo.age = 0;
        assertTrue(GamesExpo.canParticipateInRhyming(GamesExpo.age));

        GamesExpo.age = 7;
        assertFalse(GamesExpo.canParticipateInRhyming(GamesExpo.age));

        GamesExpo.age = 6;
        assertTrue(GamesExpo.canParticipateInRhyming(GamesExpo.age));


    }

    @Test
    void boundaryVAQuiz() {
        GamesExpo.age = 10;
        GamesExpo.gender = "boy";
        assertFalse(GamesExpo.canParticipateInQuiz(GamesExpo.age, GamesExpo.gender));

        GamesExpo.age = 11;
        GamesExpo.gender = "boy";
        assertTrue(GamesExpo.canParticipateInQuiz(GamesExpo.age, GamesExpo.gender));

        GamesExpo.age = 16;
        GamesExpo.gender = "boy";
        assertFalse(GamesExpo.canParticipateInQuiz(GamesExpo.age, GamesExpo.gender));

        GamesExpo.age = 15;
        GamesExpo.gender = "boy";
        assertTrue(GamesExpo.canParticipateInQuiz(GamesExpo.age, GamesExpo.gender));


    }

    @Test
    void boundaryVAEssay() {
        GamesExpo.age = 9;
        GamesExpo.gender = "girl";
        assertFalse(GamesExpo.canParticipateInEssayWriting(GamesExpo.age, GamesExpo.gender));

        GamesExpo.age = 10;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInEssayWriting(GamesExpo.age, GamesExpo.gender));

        GamesExpo.age = 16;
        GamesExpo.gender = "girl";
        assertFalse(GamesExpo.canParticipateInEssayWriting(GamesExpo.age, GamesExpo.gender));

        GamesExpo.age = 15;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInEssayWriting(GamesExpo.age, GamesExpo.gender));
    }

    @Test
    void boundaryVAPoetry() {
        GamesExpo.age = 19;
        assertFalse(GamesExpo.canParticipateInPoetry(GamesExpo.age));

        GamesExpo.age = 20;
        assertTrue(GamesExpo.canParticipateInPoetry(GamesExpo.age));

        GamesExpo.age = 100;
        assertTrue(GamesExpo.canParticipateInPoetry(GamesExpo.age));

    }

    @Test
    void equivalencePartitionStoryTelling() {
        GamesExpo.age = 8;
        GamesExpo.gender = "boy";
        assertTrue(GamesExpo.canParticipateInStorytelling(GamesExpo.age, GamesExpo.gender));
    }

    @Test
    void equivalencePartitionDrawing() {
        GamesExpo.age = 8;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInDrawing(GamesExpo.age, GamesExpo.gender));
    }

    @Test
    void equivalencePartitionRhyming() {
        GamesExpo.age = 4;
        assertTrue(GamesExpo.canParticipateInRhyming(GamesExpo.age));
    }

    @Test
    void equivalencePartitionQuiz() {
        GamesExpo.age = 13;
        GamesExpo.gender = "boy";
        assertTrue(GamesExpo.canParticipateInQuiz(GamesExpo.age, GamesExpo.gender));
    }

    @Test
    void equivalencePartitionEssay() {
        GamesExpo.age = 13;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInEssayWriting(GamesExpo.age, GamesExpo.gender));
    }

    @Test
    void equivalencePartitionPoetry() {
        GamesExpo.age = 40;
        assertTrue(GamesExpo.canParticipateInPoetry(GamesExpo.age));
    }

}