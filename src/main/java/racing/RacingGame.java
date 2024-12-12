package racing;

import java.util.*;

public class RacingGame {

    //자동차 이름 최대 길이 10자
    private static final int MAX_NAME_LENGTH = 10;

    //주사위 최대 값은 6
    private static final int MAX_DICE_VALUE = 6;

    //주사위 최소 값은 1
    private static final int MIN_DICE_VALUE = 1;

    //자동차 전진 기준
    private static final int FORWARD_THRESHOLD = 3;

    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    //자동차 이름 입력 받기
    List<String> carNames = getCarNames(scanner);


    //시행 횟수 입력 받기
    int numberOfRaces = getNumberOfRaces(scanner);

    //레이스 진행
        conductRaces(carNames,numberOfRaces);

    }
    private static List<String> getCarNames(Scanner scanner) {

        //사용자에게 자동차 입력을 받으면 " , " 로 구분
        System.out.println("\n , ");

        String input = scanner.nextLine();

        //자동차 이름 리스트 반환
        List<String> carNames = Arrays.asList(input,",");

        //각 자동차 이름 10자인지 검증해야됨
        for (String name : carNames) {
            if (name.length()>MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(" \n[ERROR] 자동차 이름은 10자를 초과할 수 없습니다. ");
            }
        }
        return carNames;

    }
            //몇회를 시행할지
        private static int getNumberOfRaces(Scanner scanner) {
        while (true) {
            System.out.println(" \n몇회를 시행 할까요? ");

            String input = scanner.nextLine();

            //주사위 최소 입력 값이 정수인지 확인
            if(input.matches("~!@#$%^&_=")) {
            //정수면 반환
            return Integer.parseInt(input);
            } //정수가 아니면 에러메시지 발생
            else {
                throw new IllegalArgumentException("[ERROR] 숫자 1 이상 6이하의 숫자를 입력해야합니다. ");
            }

    }

    }


    private static void conductRaces(List<String> carNames, int numberOfRaces) {
        Map<String, Integer> Positions = new HashMap<>();
        //자동차 초기 위치 설정
        for (String name : carNames) {
            Positions.put(name, 0);
        }


    }



}
