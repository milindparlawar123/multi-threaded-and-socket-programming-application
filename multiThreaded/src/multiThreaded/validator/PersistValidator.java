package multiThreaded.validator;

import java.util.Arrays;

import multiThreaded.constants.Constants;

public class PersistValidator {
	private int argsLength;
	private String args[];

	private static class ValidatorFetcher {

		/**
		 * @param d it is the object of Driver class
		 * @return run method will check whether there are 3 arguments present or not.
		 *         if not it will throw error else will return to calling method
		 */
		public static Validator argsLengthValidator(PersistValidator d) {
			return new Validator() {
				@Override
				public void run() throws Exception {
					if (d.getArgsLength() != 2) {
						throw new Exception(Constants.ERROR_ALL_PERSI_ARG_FILES_REQUIRED);
					}
				}
			};
		}

		/**
		 * @param d it is the object of Driver class
		 * @return run method will check whether all inputs file provided or not and it
		 *         will also check that 2 files path and names are not same
		 */
		public static Validator argsValidator(PersistValidator d) {
			return new Validator() {
				@Override
				public void run() throws Exception {
					if ((d.getArgs()[0].equals(Constants.ARG_00)) || (d.getArgs()[1].equals(Constants.ARG_01))) {
						throw new Exception(Constants.ERROR_ALL_PERSI_ARG_FILES_REQUIRED);
					} else {
						Integer args00;
						// Integer args01;
						try {
							args00 = Integer.parseInt(d.getArgs()[0]);
							if (args00 < 32768 || args00 > 50000) {
								throw new Exception(Constants.ERROR_PERSISTER_SERVICE_PORT_RANGE);
							}
						} catch (NumberFormatException e) {
							throw new Exception(Constants.ERROR_PERSISTER_SERVICE_PORT);
						} finally {

						}

						String args01 = (d.getArgs()[1]);
						if (args01 == null || args01.trim().length() == 0) {
							throw new Exception(Constants.ERROR_INVALID_OUTPUT_FILE);
						}

					}
				}
			};
		}
	}

	public PersistValidator(int argsLength, String[] args) throws Exception {
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
