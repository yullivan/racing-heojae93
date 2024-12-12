package racing;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RacingGameTest {

    @Test
        // 사용자 입력, byete 단위로 문자열 배열 검증
        public void testGetCarNames_validInput() {
        String input = "car1,car2,car3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> carNames = RacingGame.getCarNames(new java.util.Scanner(System.in));

        assertEquals(3, carNames.size());
        assertTrue(carNames.contains("car1"));
        assertTrue(carNames.contains("car2"));
        assertTrue(carNames.contains("car3"));
    }

    @Test
        //이름이 너무 긴 경우 에러발생, byete 단위로 문자열 배열 검증
        public void testGetCarNames_invalidInput_tooLong() {
        String input = "car1,dfsfawerwwer,car3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> carNames = RacingGame.getCarNames(new java.util.Scanner(System.in));

        // 유효하지 않은 이름, 다시 입력
        assertEquals(0, carNames.size());
    }

    @Test
        // 올바른 시행 횟수 입력, byete 단위로 문자열 배열 검증
        public void testGetNumberOfRaces_validInput() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int numberOfRaces = RacingGame.getNumberOfRaces(new java.util.Scanner(System.in));

        assertEquals(5, numberOfRaces);
    }

    @Test
        // 숫자가 아닌 값 입력시 에러발생 , byete 단위로 문자열 배열 검증
        public void testGetNumberOfRaces_invalidInput_nonNumeric() {
        String input = "abc";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int numberOfRaces = RacingGame.getNumberOfRaces(new java.util.Scanner(System.in));

        // 숫자가 아니면 다시 입력
        assertEquals(0, numberOfRaces);
    }

    @Test
        // 0 또는 음수 입력시 에러발생, byete 단위로 문자열 배열 검증
        public void testGetNumberOfRaces_invalidInput_zeroOrNegative() {
        String input = "-5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int numberOfRaces = RacingGame.getNumberOfRaces(new java.util.Scanner(System.in));

        // 0보다 작거나 0이면 다시 입력
        assertEquals(0, numberOfRaces);
    }
}
