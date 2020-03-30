package multiThreaded.validator;

import java.util.Arrays;

import multiThreaded.constants.Constants;;

/**
 * @author Milind below class is to validate arguments provided to driver class
 */
public class PrimeDetectorValidator {
	private int argsLength;
	private String args[];

	private static class ValidatorFetcher {

		/**
		 * @param d it is the object of Driver class
		 * @return run method will check whether there are 3 arguments present or not.
		 *         if not it will throw error else will return to calling method
		 */
		public static Validator argsLengthValidator(PrimeDetectorValidator d) {
			return new Validator() {
				@Override
				public void run() throws Exception {
					if (d.getArgsLength() != 6) {
						throw new Exception(Constants.ERROR_INVALID_ARGUMENTS);
					}
				}
			};
		}

		/**
		 * @param d it is the object of Driver class
		 * @return run method will check whether all inputs file provided or not and it
		 *         will also check that 2 files path and names are not same
		 */
		public static Validator argsValidator(PrimeDetectorValidator d) {
			return new Validator() {
				@Override
				public void run() throws Exception {
					if ((d.getArgs()[0].equals(Constants.ARG_0)) || (d.getArgs()[1].equals(Constants.ARG_1))
							|| (d.getArgs()[2].equals(Constants.ARG_2)) || (d.getArgs()[3].equals(Constants.ARG_3))
							|| (d.getArgs()[4].equals(Constants.ARG_4)) || (d.getArgs()[5].equals(Constants.ARG_5))) {
						throw new Exception(Constants.ERROR_ALL_PRIME_ARG_FILES_REQUIRED);
					} else {
						Integer args1;
						Integer args2;
						Integer args4;
						Integer args5;
						String args0 = (d.getArgs()[0]);
						if (args0 == null || args0.trim().length() == 0) {
							throw new Exception(Constants.ERROR_INVALID_INPUT_FILE);
						}

						try {
							args1 = Integer.parseInt(d.getArgs()[1]);
							if (args1 < 1 || args1 > 5) {
								throw new Exception(Constants.ERROR_NUM_THREADS_SIZE);
							}
						} catch (NumberFormatException e) {
							throw new Exception(Constants.ERROR_NUM_THREADS);
						}
						try {
							args2 = Integer.parseInt(d.getArgs()[2]);
							if (args2 < 1) {
								throw new Exception(Constants.ERROR_CAPACITY_SIZE);
							}
						} catch (NumberFormatException e) {
							throw new Exception(Constants.ERROR_CAPACITY);
						}
						try {
							args4 = Integer.parseInt(d.getArgs()[4]);
							if (args4 < 32768 || args4 > 50000) {
								throw new Exception(Constants.ERROR_PERSISTER_SERVICE_PORT_RANGE);
							}
						} catch (NumberFormatException e) {
							throw new Exception(Constants.ERROR_PERSISTER_SERVICE_PORT);
						}
						try {
							args5 = Integer.parseInt(d.getArgs()[5]);
							if (args5 < 1 || args5 > 4) {
								throw new Exception(Constants.ERROR_DEBUG_VALUE);
							}
						} catch (NumberFormatException e) {
							throw new Exception(Constants.ERROR_DEBUG);
						}

					}
				}
			};
		}
	}

	public PrimeDetectorValidator(int argsLength, String[] args) throws Exception {
		this.argsLength = argsLength;
		this.args = args;

		ValidatorUtil.validate("failed", ValidatorFetcher.argsLengthValidator(this),
				ValidatorFetcher.argsValidator(this));
	}

	public int getArgsLength() {
		return argsLength;
	}

	public void setArgsLength(int argsLength) {
		this.argsLength = argsLength;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	@Override
	public String toString() {
		return "Driver [argsLength=" + argsLength + ", args=" + Arrays.toString(args) + "]";
	}

}
