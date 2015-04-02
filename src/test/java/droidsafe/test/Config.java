package droidsafe.test;

import org.apache.commons.cli.Options;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Class to store and configure test options and variables.
 */
public class Config {

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Public Static Fields
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public final static String TEST_RESULTS_DIR = "test-reports";
  public final static String TEST_PREFIX = "TEST-droidsafe.test.";
  public final static String SPECDUMP_TEST_NAME = "SpecdumpTestCase";

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Private Static Fields
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  private final static Logger logger = LoggerFactory.getLogger(Config.class);
	private static Config config;

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Singleton Pattern
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  protected Config (){
    // prevent instantiation
  }

  /*
   * Instantiate singleton lazily
   */
	public static Config v() {
    if (config == null){
      config = new Config();
    }
		return config;
	}

}
