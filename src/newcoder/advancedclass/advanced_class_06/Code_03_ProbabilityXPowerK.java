package newcoder.advancedclass.advanced_class_06;
/*
假设函数Math.random()等概率随机返回一个在[0,1)范围上的数，那
么我们知道，在[0,x)区间上的数出现的概率为x（0<x≤1）。给定一
个大于0的整数k，并且可以使用Math.random()函数，请实现一个函数
依然返回在[0,1)范围上的数，但是在[0,x)区间上的数出现的概率为
x ^ k(0<x≤1)。
 */
public class Code_03_ProbabilityXPowerK {

	public static double randXPower2() {
		return Math.max(Math.random(), Math.random());
	}

	public static double randXPowerK(int k) {
		if (k < 1) {
			return 0;
		}
		double res = -1;
		for (int i = 0; i != k; i++) {
			res = Math.max(res, Math.random());
		}
		return res;
	}

	public static void main(String[] args) {
		double range = 0.5;
		int times = 5000000;
		int count = 0;
		for (int i = 0; i != times; i++) {
			if (randXPowerK(2) < range) {
				count++;
			}
		}
		double p = (double) count / (double) times;
		System.out.println("range [0," + range + "), probability: " + p);
	}
}
