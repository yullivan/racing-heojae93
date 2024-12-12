package racing;

import java.util.*;

public class RacingGame {
    private static final int MAX_NAME_LENGTH = 10; // 자동차 이름 최대 길이
    private static final int MAX_DICE_VALUE = 6; // 주사위 최대 값
    private static final int MIN_DICE_VALUE = 1; // 주사위 최소 값
    private static final int FORWARD_THRESHOLD = 3; // 전진 기준

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 자동차 이름 입력 받기
        List<String> carNames = getCarNames(scanner);

        // 시행 횟수 입력 받기
        int numberOfRaces = getNumberOfRaces(scanner);

        // 레이스 진행
        conductRaces(carNames, numberOfRaces);
    }

    //사용자에게 자동차 이름을 " , " 로 구분하여 입력받기
    private static List<String> getCarNames(Scanner scanner) {
        while (true) {
            System.out.print("레이스에 참가할 자동차들의 이름을 쉼표(,)로 구분하여 입력하세요.\n: ");
            String input = scanner.nextLine();

            // 입력된 이름을 " , " 로 구분하여 리스트로 변환
            List<String> carNames = Arrays.asList(input.split(","));

            // 각 자동차 이름의 길이를 검증
            boolean isValid = true;
            for (String name : carNames) {
                if (name.length() > MAX_NAME_LENGTH) {

                    //10자 초과시
                    System.out.println("[ERROR] 자동차 이름은 10자를 초과할 수 없습니다.");
                    isValid = false;
                    break;
                }
            }
            //이름이 유효한 경우 리스트 반환
            if (isValid) {
                return carNames;
            }
        }
    }
}