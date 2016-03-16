/*

import java.io.*;



import org.apache.log4j.Logger;



/**
 * Classe utilisant des Threads pour indexer des documents.
 * <br/><br/>
 * Class using threads for indexing documents.
 *
 * @author Rida Benjelloun (ridabenjelloun@gmail.com)
 */
public class ThreadIndexing
    extends Thread {
  static Logger logger = Logger.getRootLogger();
  private String toIndex = null;
  private String indexDir = "";
  private String fichierXMLConfig = "";

  public ThreadIndexing(String toIndex,
                        String indexDir,
                        String fichierXMLConfig) {
    this.toIndex = toIndex;
    this.indexDir = indexDir;
    this.fichierXMLConfig = fichierXMLConfig;
  }
  public ThreadIndexing(String toIndex,
                        String indexDir,
                        String fichierXMLConfig,
                        String type) {
    this.toIndex = toIndex;
    this.indexDir = indexDir;
    this.fichierXMLConfig = fichierXMLConfig;
  }


  public void run() {

    try {
      LuceneActions.getSingletonInstance().index(toIndex, indexDir,
                                                 fichierXMLConfig);
      try {
        Thread.sleep(1000);
      }
      catch (InterruptedException ex) {
        logger.error(ex.getMessage());
      }
    }
    catch (LiusException e) {
      logger.error(e.getMessage());
    }
    catch (IOException e) {
      logger.error(e.getMessage());
    }

  }
}