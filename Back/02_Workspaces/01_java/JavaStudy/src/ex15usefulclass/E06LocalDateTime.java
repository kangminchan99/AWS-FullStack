package ex15usefulclass;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class E06LocalDateTime {
    public static void main(String[] args) {
        // 날짜를 표현
        LocalDate localDate = LocalDate.now();
        System.out.println("today:" + localDate);

        // 시간을 표현
        LocalTime localTime = LocalTime.now();
        System.out.println("현재 시간:" + localTime);

        // 날짜와 시간을 동시에 표현
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("now" + localDateTime);

        // 날짜와 시간의 서식을 지정
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("오늘은 M월의 W번째주, d번째날, F번째 E요일");

        // 앞에서 지정한 서식을 날짜에 적용해서 출력
        System.out.println(localDateTime.format(format1));
        System.out.println(localDateTime.format(format2));
        System.out.println(localDateTime.format(format3));

        // 특정날짜 지정하기: LocalDate.of(년,월,일)
        LocalDate xMas = LocalDate.of(localDate.getYear(), 12, 25);
        // 앞에서 지정했던 날짜서식을 적용해서 출력
        System.out.println("xmas" + xMas.format(format1));

        /*
        Period 클래스: 두 날짜 사이의 간격을 나타낸다. ?개월 ?일 남음으로 표시할 수 있다.
         */
        Period period = Period.between(localDate, xMas);
        System.out.println(period.getMonths() + "개월" + period.getDays() + "일 남음");

        // ChronoUnit클래스: 특정 시간 단위로 날짜의 차이를 계산한다.
        // ?개월 남음: 남은 개월수를 표시
        System.out.println(ChronoUnit.MONTHS.between(localDate, xMas) + "개월 남음");
        // 남은 전체 일수를 표시
        System.out.println(ChronoUnit.DAYS.between(localDate, xMas) + "일 남음");

        // 현재를 기준으로 이전/이후의 날짜를 계산할 수 있다.
        System.out.println("5일전" + localDateTime.minusDays(5));
        System.out.println("3일 후" + localDateTime.plusDays(3));
        System.out.println("2개월 후" + localDateTime.plusMonths(2));
        System.out.println("1년 후" + localDateTime.plusYears(1));

        // 메서드 체인 형태로 호출할 수 있다.
        System.out.println("1년 2개월 3일후" + localDateTime.plusYears(1).plusMonths(2).plusDays(3));
    }
}
