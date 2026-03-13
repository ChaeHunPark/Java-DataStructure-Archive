package week4.sorting;

import java.util.Arrays;
import java.util.Random;

import static week4.sorting.MySorting.*;

public class MySortingTest {
    public static void main(String[] args) {
        // 1. 테스트 데이터 준비 5,000개
        int size = 5000;
        int[] original = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            original[i] = random.nextInt(10000); // 0~9999 사이 랜덤값
        }

        // 각 정렬에 동일한 조건을 주기 위해 복사본 생성
        int[] data1 = original.clone();
        int[] data2 = original.clone();
        int[] data3 = original.clone();
        int[] data4 = original.clone();
        int[] data5 = original.clone();

        System.out.println("=== 정렬 성능 테스트 시작 (데이터 개수: " + size + "개) ===");

        // 2. 소요 시간 측정 (람다식을 이용해 메서드를 인자로 전달)
        measureTime("선택 정렬(Selection)", () -> MySelectionSort(data1));
        measureTime("삽입 정렬(Insertion)", () -> MyInsertionSort(data2));
        measureTime("버블 정렬(Bubble)   ", () -> MyBubbleSort(data3));
        measureTime("퀵 정렬(Quick)     ", () -> myQuickSort(data4, 0, data4.length - 1));
        measureTime("병합 정렬(merge)    ", () -> myMergeSort(data5, 0, data5.length - 1));

        // 3. 정렬이 잘 되었는지 확인 (퀵 정렬 결과만 살짝 확인)
        System.out.println("\n퀵 정렬 결과 상위 10개: ");
        for(int i=0; i<10; i++) System.out.print(data4[i] + " ");
        System.out.println("...");
    }

    /**
     * 시간 측정용 유틸리티 메서드
     * @param label 정렬 이름
     * @param task 실행할 정렬 로직 (람다식)
     */
    public static void measureTime(String label, Runnable task) {
        long startTime = System.nanoTime();

        task.run(); // 전달받은 정렬 메서드 실행

        long endTime = System.nanoTime();
        double durationMs = (endTime - startTime) / 1_000_000.0;

        System.out.printf("%s 소요 시간: %.4f ms%n", label, durationMs);
    }
}
