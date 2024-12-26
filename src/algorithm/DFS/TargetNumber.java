package algorithm.DFS;

//타겟넘버
public class TargetNumber {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int idx, int sum){

        if(idx == numbers.length){
            return sum == target ? 1 : 0;
        }

        return dfs(numbers, target, idx+1, sum+numbers[idx])
            + dfs(numbers, target, idx+1, sum-numbers[idx]);
    }
}
