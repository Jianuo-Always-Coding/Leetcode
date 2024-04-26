class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Write your solution here.
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null) {
      return result;
    }
    Arrays.sort(nums);
    List<Integer> layer = new ArrayList<>();
    helper(nums, layer, 0, result);
    return result;
  }

  private void helper(int[] array, List<Integer> layer, int index, List<List<Integer>> result) {
    // base case
    if (index == array.length) {
      result.add(new ArrayList<>(layer));
      return ;
    }
    
    // 加，加完去下一层
    int temp = array[index];
    layer.add(temp);
    helper(array, layer, index + 1, result);
    layer.remove(layer.size() - 1);
    while (index < array.length - 1 && array[index+1] == array[index]) {
      index++;
    }
    // 不加，永远不能加
    helper(array, layer, index+1, result);
  }
}
