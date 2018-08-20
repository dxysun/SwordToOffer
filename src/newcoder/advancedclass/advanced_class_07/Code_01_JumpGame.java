package newcoder.advancedclass.advanced_class_07;

public class Code_01_JumpGame {

	public static int jump(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int jump = 0;   //最少步数0 -》m - 1
		int cur = 0;  //跳jump步下的，目前的边界
		int next = 0;   //加一步，右边界
		for (int i = 0; i < arr.length; i++) {
			if (cur < i) {
				jump++;
				cur = next;
			}
			next = Math.max(next, i + arr[i]);
		}
		return jump;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 2, 3, 1, 1, 4 };
		System.out.println(jump(arr));

	}

}
