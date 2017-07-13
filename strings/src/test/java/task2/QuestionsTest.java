package task2;

import lombok.SneakyThrows;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class QuestionsTest {

    @Test
    void testRussian() {
        Questions questions = new Questions(new Locale("ru"));
        MatcherAssert.assertThat("Столица Великобритании?", Is.is(questions.getQuestion(1)));
        MatcherAssert.assertThat("Лондон", Is.is(questions.getAnswer(1)));
        MatcherAssert.assertThat("Как дела?", Is.is(questions.getQuestion(2)));
        MatcherAssert.assertThat("Хорошо", Is.is(questions.getAnswer(2)));
    }

    @Test
    void testEnglish() {
        Questions questions = new Questions(Locale.ENGLISH);
        MatcherAssert.assertThat("What's the capital of Great Britain?", Is.is(questions.getQuestion(1)));
        MatcherAssert.assertThat("London", Is.is(questions.getAnswer(1)));
        MatcherAssert.assertThat("How are you?", Is.is(questions.getQuestion(2)));
        MatcherAssert.assertThat("Fine", Is.is(questions.getAnswer(2)));
    }
}