package multiThreaded.primeNumber;

import multiThreaded.primeNumber.PrimeI;

/**
 * @author Milind and Smriti
 * Below singleton class is to check given number is prime or not
 *
 */
public class PrimeNumber implements PrimeI {

	/**
	 * primeNumber object will be used across application
	 */
	private static PrimeNumber primeNumber = new PrimeNumber();

	private PrimeNumber() {
	}

	public static PrimeNumber getInstance() {
		return primeNumber;
	}

	/**
	 *if number is prime then return true else false
	 */
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
