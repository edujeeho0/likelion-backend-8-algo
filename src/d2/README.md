# 정렬 알고리즘

[연습문제 링크](practice.md)

## Bubble Sort

앞뒤의 원소를 비교해가며, 큰 원소를 거품처럼 위로 올리는 정렬 알고리즘

1. 첫번째 원소부터 인접한 두 원소를 비교하여, 더 큰 원소를 뒤쪽으로
2. 마지막 두 원소의 비교가 끝나면 마지막 원소를 제외하고 반복


```java
public static void main(String[] args) {
    int[] arr = {36, 12, 18, 15, 41, 19};
    int n = arr.length;

    for(int i = 0; i < n - 1; i++){
        for(int j = 0; j < n - 1 - i; j++){
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }

    System.out.println(Arrays.toString(arr));
}
```

## Selection Sort

주어진 수 중에서 가장 작은 숫자를 앞으로 보내는 정렬 알고리즘

1. 주어진 자료에서 가장 작은 값을 제일 앞의 원소와 교환, 이 원소는 정렬된 상태가 된다.
2. 정렬되지 않은 제일 앞쪽 원소부터 반복한다.

미 정렬된 원소 중 제일 작은것을 앞으로 옮기는 Selection Algorithm

```java
public static void main(String[] args) {
    int[] arr = {25, 12, 18, 24, 2, 21};
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }

    System.out.println(Arrays.toString(arr));
}
```

## Counting Sort

정렬하고자 하는 자료가 전부 정수일 때, 각 원소가 등장하는 빈도를 바탕으로 정렬하는 알고리즘

1. 각 정수 항목의 최댓값 만큼의 공간을 가진 배열 `counts` 생성
2. 제일 앞쪽 원소의 값을 차례데로 뒤쪽 원소에 합해준다. (누적합)
3. 결과를 담을 `output` 배열에, 본래 배열을 순회하며, 각 데이터를 `data`라고 할때
   1. `counts[data]` 의 값을 저장 (`index`)
   2. `output[index]`에 `data` 할당
   3. `count[data]--`
   
위의 과정의 결과로 생긴 `output` 배열은 정렬된 배열이다.

```java
public static void main(String[] args) {
    int[] arr = {0, 1, 4, 4, 3, 0, 5, 2, 5, 1};
    int n = arr.length;

    int[] count = new int[6];
    for (int data : arr) {
        count[data]++;
    }

    for (int i = 0; i < 5; i++) {
        count[i + 1] += count[i];
    }
    System.out.println(Arrays.toString(count));

    int[] output = new int[n];
    for (int i = n - 1; i >= 0; i--) {
        count[arr[i]]--;
        int position = count[arr[i]];
        output[position] = arr[i];
    }

    System.out.println(Arrays.toString(output));
 }
```

