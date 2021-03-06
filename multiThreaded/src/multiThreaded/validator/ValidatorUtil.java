package multiThreaded.validator;

/**
 * @author Milind 
 * @author Smriti
 */
public final class ValidatorUtil {

	public static void validate(String baseErrMsg, Validator... validators) throws Exception {
		for (Validator v : validators) {
			try {
				v.run();
			} catch (Exception e) {
				throw new Exception(baseErrMsg.concat(": " + e.getMessage()), e);
			} finally {

			}
		}

	}

}
