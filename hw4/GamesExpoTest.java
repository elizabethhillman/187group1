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

    //Test 2: To test the domain using boundary values analysis for boys who can participate in storytelling
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

    //Test 3: To test the domain using EP technique for boys who can participate in storytelling.
    @Test
    void equivalencePartitionStoryTelling() {
        GamesExpo.age = 8;
        GamesExpo.gender = "boy";
        assertTrue(GamesExpo.canParticipateInStorytelling(GamesExpo.age, GamesExpo.gender));
    }

    //Test 4: If the user is a girls and has an age on the inclusive boundary, then they should be able to compete in drawing
    @Test
    void canParticipateInDrawing() {
        GamesExpo.age = 7;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInDrawing(GamesExpo.age, GamesExpo.gender));
    }

    //Test 5: To test the domain using boundary values analysis for girls who can participate in drawing
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

    //Test 6: To test the domain using EP technique for boys who can participate in drawing.
    @Test
    void equivalencePartitionDrawing() {
        GamesExpo.age = 8;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInDrawing(GamesExpo.age, GamesExpo.gender));
    }

    //Test 7: If the user is of age greater than 6, then they should not be able to compete in rhyming
    @Test
    void canParticipateInRhyming() {
        GamesExpo.age = 7;
        assertFalse(GamesExpo.canParticipateInRhyming(GamesExpo.age));
    }

    //Test 8: To test the domain using boundary values analysis for boys and girls who can participate in Rhyming
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

    //Test 9: To test the domain using EP technique for boys and girls who can participate in storytelling.
    @Test
    void equivalencePartitionRhyming() {
        GamesExpo.age = 4;
        assertTrue(GamesExpo.canParticipateInRhyming(GamesExpo.age));
    }

    //Test 10: If the user is a boy and has an age on the inclusive boundary, then they should be able to compete in quiz
    @Test
    void canParticipateInQuiz() {
        GamesExpo.age = 11;
        GamesExpo.gender = "boy";
        assertTrue(GamesExpo.canParticipateInQuiz(GamesExpo.age, GamesExpo.gender));
    }

    //Test 11: To test the domain using boundary values analysis for boys who can participate in quiz
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

    //Test 12: To test the domain using EP technique for boys who can participate in a quiz.
    @Test
    void equivalencePartitionQuiz() {
        GamesExpo.age = 13;
        GamesExpo.gender = "boy";
        assertTrue(GamesExpo.canParticipateInQuiz(GamesExpo.age, GamesExpo.gender));
    }

    //Test 13: If the user is a girl and has an age on the inclusive boundary, then they should be able to compete in essay writing
    @Test
    void canParticipateInEssayWriting() {
        GamesExpo.age = 10;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInEssayWriting(GamesExpo.age, GamesExpo.gender));
    }

    //Test 14: To test the domain using boundary values analysis for girls who can participate in essay writing
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

    //Test 15: To test the domain using EP technique for boys who can participate in storytelling.
    @Test
    void equivalencePartitionEssay() {
        GamesExpo.age = 13;
        GamesExpo.gender = "girl";
        assertTrue(GamesExpo.canParticipateInEssayWriting(GamesExpo.age, GamesExpo.gender));
    }

    //Test 16: If the user is any gender and has an age on the inclusive boundary, then they should be able to compete in poetry
    @Test
    void canParticipateInPoetry() {
        GamesExpo.age = 20;
        assertTrue(GamesExpo.canParticipateInPoetry(GamesExpo.age));
    }

    //Test 17: To test the domain using boundary values analysis for girls who can participate in poetry
    @Test
    void boundaryVAPoetry() {
        GamesExpo.age = 19;
        assertFalse(GamesExpo.canParticipateInPoetry(GamesExpo.age));

        GamesExpo.age = 20;
        assertTrue(GamesExpo.canParticipateInPoetry(GamesExpo.age));

        GamesExpo.age = 100;
        assertTrue(GamesExpo.canParticipateInPoetry(GamesExpo.age));
    }

    //Test 18: To test the domain using EP technique for boys who can participate in storytelling.
    @Test
    void equivalencePartitionPoetry() {
        GamesExpo.age = 40;
        assertTrue(GamesExpo.canParticipateInPoetry(GamesExpo.age));
    }

    //Test 19: If the user is any gender and has an age on the inclusive boundary, then they should be told that there are no events they can compete in
    @Test
    void canNotParticipate() {
        GamesExpo.age = 16;
        assertTrue(GamesExpo.canNotParticipate(GamesExpo.age));
    }

    //Test 20: To test the domain using boundary value analysis for any gender user who can not participate in any event
    @Test
    void boundaryVACanNotParticipate() {
        GamesExpo.age = 15;
        assertFalse(GamesExpo.canNotParticipate(GamesExpo.age));

        GamesExpo.age = 17;
        assertTrue(GamesExpo.canNotParticipate(GamesExpo.age));

        GamesExpo.age = 20;
        assertFalse(GamesExpo.canNotParticipate(GamesExpo.age));
    }

    //Test 21: To test the domain using EP technique for any gender user who can not participate in any competition
    @Test
    void equivalencePartitionCanNotParticipate() {
        GamesExpo.age = 18;
        assertTrue(GamesExpo.canNotParticipate(GamesExpo.age));
    }
}