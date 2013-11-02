package AI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseCost {

	private static List<Double> breakNums(String s) {
		String[] p = s.split(" ");

		List<Double> l = new ArrayList<Double>();
		for (String x : p)
			l.add(Double.parseDouble(x));

		return l;
	}

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		List<List<Double>> inputData = new ArrayList<List<Double>>();

		String input = in.nextLine();
		List<Double> nums = breakNums(input);

		int features = nums.get(0).intValue();
		int trainingSetSize = nums.get(1).intValue();

		List<Double> theta = new ArrayList<Double>();

		double theta0 = 1;
		for (int i = 0; i < features; i++)
			theta.add(1D);

		for (int i = 0; i < trainingSetSize; i++) {
			input = in.nextLine();
			nums = breakNums(input);
			inputData.add(nums);
		}

		int n = in.nextInt();
		in.nextLine();

		double alpha = 0.004;
		int runs = 100;
		
		for (int i = 0; i < runs; i++) {
			for (List<Double> inputSet : inputData) {
				double actualPrice = inputSet.get(features);

				double expectedPrice = theta0;
				for (int j = 0; j < features; j++)
					expectedPrice += nums.get(j) * theta.get(j);

				theta0 = theta0 + alpha * (actualPrice - expectedPrice);
				for (int j = 0; j < features; j++) {
					theta.set(j, theta.get(j) + alpha
							* (actualPrice - expectedPrice) * inputSet.get(j));
				}
			}
		}

		for (int i = 0; i < n; i++) {
			input = in.nextLine();
			nums = breakNums(input);

			double expectedPrice = theta0;
			for (int j = 0; j < features; j++) {
				expectedPrice += nums.get(j) * theta.get(j);
			}

			System.out.println(expectedPrice);
		}

		in.close();
	}
}
