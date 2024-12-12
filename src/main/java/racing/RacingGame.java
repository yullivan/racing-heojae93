package racing;

import java.util.*;

public class RacingGame {

    // 자동차 이름의 최대 길이
    private static final int MAX_NAME_LENGTH = 10;

    // 주사위의 최대 값
    private static final int MAX_DICE_VALUE = 6;

    // 주사위의 최소 값
    private static final int MIN_DICE_VALUE = 1;

    // 전진 기준 값 (주사위 값이 3이상이면 전진)
    private static final int FORWARD_THRESHOLD = 3;

    public static void main(String[] args) {

        // 사용자 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 자동차 이름 입력 받기
        List<String> carNames = getCarNames(scanner);

        // 시행 횟수 입력 받기
        int numberOfRaces = getNumberOfRaces(scanner);

        // 레이스 진행
        conductRaces(carNames, numberOfRaces);
    }

            // 자동차 이름 입력 받기
            public static List<String> getCarNames(Scanner scanner) {
            while (true) {

            // 사용자에게 자동차 이름들을 쉼표(,)로 구분 및 입력
            System.out.print("레이스에 참가할 자동차들의 이름을 쉼표(,)로 구분하여 입력하세요.\n: ");
            String input = scanner.nextLine();

            // 입력된 문자열을 쉼표로 분리하여 리스트로 변환
            List<String> carNames = Arrays.asList(input.split(","));

            // 각 자동차 이름의 길이를 검증
            boolean isValid = true;
            for (String name : carNames) {

                // 이름이 최대 길이를 초과하는 경우 오류 메시지 출력
                if (name.length() > MAX_NAME_LENGTH) {
                    System.out.println("[ERROR] 자동차 이름은 10자를 초과할 수 없습니다.");
                    isValid = false;
                    break;
                }
            }

            // 모든 이름이 유효한 경우 리스트 반환
            if (isValid) {
                return carNames;
            } else {

                // 유효하지 않으면 다시 입력 받기
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

            // 시행 횟수 입력 받기
            public static int getNumberOfRaces(Scanner scanner) {
            while (true) {

            // 사용자에게 시행 횟수를 입력하도록 요청
            System.out.print("몇 회 시행할까요?\n: ");
            String input = scanner.nextLine();

            // 입력된 값이 숫자인지 확인
            if (!input.matches("\\d+")) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
                continue;
            }

            // 입력된 값을 정수로 변환
            int numberOfRaces = Integer.parseInt(input);

            // 시행 횟수가 0보다 큰지 확인
            if (numberOfRaces <= 0) {
                System.out.println("[ERROR] 시행 횟수는 0보다 커야 합니다.");
                continue;
            }

            // 유효한 시행 횟수 반환
            return numberOfRaces;
        }
    }

        // 레이스 진행
        public static void conductRaces(List<String> carNames, int numberOfRaces) {

        // 각 자동차의 위치를 저장할 맵
        Map<String, Integer> positions = new HashMap<>();

        // 초기 위치 설정 (모든 자동차는 0 위치에서 시작)
        for (String name : carNames) {
            positions.put(name, 0);
        }

        // 지정된 횟수만큼 레이스 진행
        for (int i = 1; i <= numberOfRaces; i++) {
            System.out.println("\n(" + i + ")");

            // 각 자동차에 대해 주사위를 굴리고 위치 업데이트
            for (String name : carNames) {

                // 주사위 굴리기
                int diceValue = rollDice();

                // 주사위 값에 따라 전진 또는 정지 결정
                if (diceValue >= FORWARD_THRESHOLD) {
                    positions.put(name, positions.get(name) + 1);
                }

                // 현재 위치 출력
                printCarPosition(name, positions.get(name));
            }
        }

        // 우승자 발표
        announceWinner(positions);
    }

        //주사위를 굴려서 1~6까지 반환하는 함수
        private static int rollDice() {

        //랜덤 함수 사용, 1~6사이 랜덤값을 생성하고 반환
        return new Random().nextInt(MAX_DICE_VALUE) + MIN_DICE_VALUE;
    }

        //자동차 이름, 위치를 받아서 그에 해당하는 위치를 출력하는 함수
        public static void printCarPosition(String name, int position) {
        System.out.println(name + "🚖" + "----".repeat(position));
    }

        // 우승자 발표
        public static void announceWinner(Map<String, Integer> positions) {

        // 모든 자동차의 위치 중 최대 값을 찾기
        int maxPosition = Collections.max(positions.values());

        // 공동 우승자 찾기
        List<String> winners = new ArrayList<>();

        //positions 맵의 각 항목을 순회하면서
        for (Map.Entry<String, Integer> entry : positions.entrySet()) {

            //현재 자동차의 위치가 최대 위치(maxPosition)와 같으면
            if (entry.getValue() == maxPosition) {

                // 우승자 리스트에 해당 자동차 이름을 추가
                winners.add(entry.getKey());
            }
        }

        // 우승자 출력
        System.out.println("\n🥇 우승자는 " + String.join(", ", winners) + " 🥇 ");
    }
}
