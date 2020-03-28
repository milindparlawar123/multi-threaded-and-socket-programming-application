package multiThreaded.driver;

public class PrimeNumber {

	private static PrimeNumber primeNumber = new PrimeNumber();

	private PrimeNumber() {
	}

	public static PrimeNumber getInstance() {
		return primeNumber;
	}

	public boolean isPrime(Integer number) {
		boolean flag = false;
		if (number == 1) {
			return false;
		}
		for (int k = 2; k <= number / 2; ++k) {

			if (number % k == 0) {
				flag = true;
				break;
			}
		}

		if (!flag)
			return true;
		else
			return false;
	}

}
