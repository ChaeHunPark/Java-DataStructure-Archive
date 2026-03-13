package week4.sorting;

import java.util.Arrays;

public class MySorting {

    // 전체에서 가장 작은 수를 찾아서 정렬 안 된 부분의 맨 앞이랑 바꾼다.
    public static void MySelectionSort(int[] arr) {
        int selectidx;
        for (int i = 0; i < arr.length-1; i++) {
            selectidx = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[selectidx]) selectidx = j;
            }
            swap(arr ,i, selectidx);
        }
    }

    public static void MyInsertionSort(int[] arr){
        int target = 1; // 두 번째 카드부터 시작

        while (target < arr.length) {
            int startCard = target;

            // 0번 까지만 비교한다.
            while (startCard > 0) {
                // 내 왼쪽 보다 크면 스왑
                if(arr[startCard] < arr[startCard -1]) {
                    swap(arr, startCard, startCard -1);
                    startCard--;
                }else {
                    break;
                }
            }
            target++;
        }

    }

    // 인접한 두 수를 비교해서 오른쪽으로 보낸다.
    public static void MyBubbleSort(int[] arr){

        // i는 정렬이 완료된 숫자의 개수
        for (int i = 0; i < arr.length-1; i++) {
            // j는 처음 부터 정렬이 안된 부분까지 올라감
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // j > j+1 이면 교체!
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        // 가장 크면 제일 오른쪽으로 넘어가기 때문에 오른쪽 보다 크지 않으면 break;
    }

    /*
    * 퀵 정렬(Quick Sort)
    *  - Pivot 이라는 기준점을 세워놓고, 그보다 작은 수는 왼쪽, 큰 수는 오른쪽으로 보내는 편 가르기
    *
    * 핵심 로직
    *  1. 기준 정하기: 요소를 정하고 pivot이라고 칭하자
    *  2. 포인트 이동 :
    *  - i (작은 수의 구역): 피벖보다 작은 수를 발견할 때마다 한 칸씩 전진하며 자리 만들기
    *  - j (탐사대): 배열을 쭉 훑으면서 피벗보다 작은 수가 있는지 찾는다.
    *  3. 교환: 피벗보다 작은 수를 찾으면 i구역으로 소환
    *  4. 피벗 안착: 한 바퀴 다 돌면 i 구역 바로 다음 칸에 넣기, 이제 피벗 왼쪽은 무조건 피벗보다 작고
    *  오른쪽 보다 크다
    *
    * */


    public static void myQuickSort(int[] arr, int low, int high){
        if(low < high) { // 더 이상 쪼갤 수 없을 때 까지
            // 1. partition으로 피벗 위치 찾기
            //
            int pivotIdx = partition(arr, low, high);

            // 2. 피벗 왼쪽 그룹(작은 수들)을 다시 퀵 정렬,
            // 원래 피벗의 왼쪽 값들의 새로운 피벗을 정해서
            // 새로운 피벗의 왼쪽은 작은 값들, 오른쪽은 큰 값들로 정렬
            myQuickSort(arr, low, pivotIdx - 1);

            // 3. 피벗 오른쪽 그룹(큰 수들)을 다시 퀵 정렬
            myQuickSort(arr, pivotIdx + 1, high);


        }
    }

    // partition의 pivot은 중간 값이 될 값
    // i는 pivot들 보다 작은 값이 들어갈 경계선
    // pivot 기준으로 왼쪽은 작은 수들, 오른쪽은 큰 수들이 정렬됨.
    private static int partition(int[] arr, int low, int high) {
        // 1. 맨 오른쪽 수를 피벗으로 지정
        int pivot = arr[high];
        int i = (low - 1); // 작은 수들이 들어갈 구역의 경계선

        for (int j = low; j < high; j++) {
            // 2. 현재 숫자가 피벗보다 작으면?
            if(arr[j] < pivot) {
                i++; // 작은 수 구역 한 칸 확장
                swap(arr, i, j);
            }
        }

        // 3. 다 끝났으면 피벗을 제자리(작은 수들 바로 다음)로
        swap(arr, i + 1, high);
        return i + 1;

    }


    /*
    * 병합 정렬(Merge Sort)
    * - 무조건 반으로 쪼개고, 합치면서 정렬한다.
    *  1. 배열을 더 이상 쪼갤 수 없을 때까지(원소가 1개일 때까지) 반으로 자른다
    *  2. 쪼개진 두 그룹을 합칠 때, 각 그룹의 맨 앞 숫자끼리 비교해서 더 작은 수를 먼저 새 배열에 담는다.
    * */

    public static void myMergeSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2; // 반으로 쪼개기 위한 중간 지점

            myMergeSort(arr, low, mid); // 왼쪽을 반으로 쪼갠다.
            myMergeSort(arr, mid + 1, high); // 오른 쪽을 반으로 쪼갠다.

            merge(arr, low, mid, high);


        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        // 1. 왼쪽 배열 오른 쪽 배열 크기를 계산해서 임시 배열 생성
        int[] leftArr = Arrays.copyOfRange(arr, low, mid +1);
        int[] rightArr = Arrays.copyOfRange(arr, mid +1, high +1);

        int i = 0; // 왼쪽의 포인터
        int j = 0; // 오른쪽의 포인터
        int k = low; // 원본 배열에 채워 넣을 위치 인덱스

        // 2. 양쪽 배열 맨 앞 인덱스 끼리 비교해서 더 작은 수를 원본에 넣기
        while(i < leftArr.length && j < rightArr.length) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // 한쪽 배열이 먼저 소모 되었으면 남은 배열을 다 삽입하기
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

    }


    private static void swap(int arr[], int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
