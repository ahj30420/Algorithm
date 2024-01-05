package algorithm.sort;

//선택 정렬
public class SelectSort {
    public static void main(String[] args){

        int n = 10;
        int[] arr = {7,5,9,0,3,1,6,2,4,8};

        for(int i = 0; i < n; i++){
            int min = i;
            for(int j = i + 1; j < n; j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        for (int elem : arr) {
            System.out.print(elem);
        }

    }
}
