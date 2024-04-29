class Solution {
    public int leastInterval(char[] tasks, int n) {
        int []taskFreqMp = new int[26];
        for(char c : tasks){
            taskFreqMp[c- 'A']++;
        }
        Arrays.sort(taskFreqMp);
        int maxTask = taskFreqMp[25]; // 最大的
        int width = maxTask--;
        int vacantSlots = width * n; // 间隔中的空位置
        for(int indx = 0; indx < 25; indx++){
            vacantSlots -= Math.min(taskFreqMp[indx], width); //能放的任务
        }
        return vacantSlots > 0 ? tasks.length + vacantSlots : tasks.length;
    }
}