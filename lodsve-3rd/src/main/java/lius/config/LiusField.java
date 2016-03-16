

import java.io.InputStreamReader;

/**
 * Classe repr�sentant le bean LiusField
 * <br/><br/>
 * Class representing LiusField bean.
 * @author Rida Benjelloun (ridabenjelloun@gmail.com)
 */
public class LiusField {

  private String name;
  private String xpathSelect;
  private String type;
  private String value;
  private String ocurSep;
  private long dateLong;
  private Date date;
  private String dateFormat;
  private String getMethod;
  private String get;
  private InputStreamReader valueInputStreamReader;
  private Reader valueReader;
  private String label;
  private String[] values = null;
  private float boost;
  private boolean isBoostedB;
  private String fragmenter;

  /**
   * M�thode permettant de r�cup�rer la valeur de name.
   * <br/><br/>
   * Method for getting name value.
   */
  public String getName() {
    return name;
  }

  /** M�thode permettant d'initialiser la  valeur de name.
   * <br/><br/>
   * Method for initializing the name value.
   */
  public void setName(String name) {
    this.name = name;
  }

  /** M�thode permettant de r�cup�rer la valeur de xpathSelect.
   * <br/><br/>
   * Method for getting xpathSelect value.
   */
  public String getXpathSelect() {
    return xpathSelect;
  }

  /**
   * M�thode permettant d'initialiser la  valeur de xpathSelect.
   * <br/><br/>
   * Method for initializing the xpathSelect value.
   */
  public void setXpathSelect(String xpathSelect) {
    this.xpathSelect = xpathSelect;
  }

  /** M�thode permettant de r�cup�rer la valeur de type.
   * <br/><br/>
   * Method for getting type value.
   */
  public String getType() {
    return type;
  }

  /** M�thode permettant d'initialiser la  valeur de type.
   * <br/><br/>
   * Method for initializing the type value.
   */
  public void setType(String type) {
    this.type = type;
  }

  /** M�thode permettant de r�cup�rer la valeur de Value.
   * <br/><br/>
   * Method for getting value value.
   */
  public String getValue() {
    return value;
  }

  /** M�thode permettant d'initialiser la  valeur de value.
   * <br/><br/>
   * Method for initializing the value of value.
   */
  public void setValue(String value) {
    this.value = value;
  }

  /** M�thode permettant de r�cup�rer la valeur du s�parateur d'occurance.
   * <br/><br/>
   * Method for getting the hit separator value.
   */
  public String getOcurSep() {
    return ocurSep;
  }

  /** M�thode permettant d'initialiser la  valeur du s�parateur d'occurance.
   * <br/><br/>
   * Method for initializing the hit separator value.
   */
  public void setOcurSep(String ocurSep) {
    this.ocurSep = ocurSep;
  }

  /** M�thode permettant d'initialiser la  valeur de date.
   * <br/><br/>
   * Method for initializing the date value.
   */
  public void setDateLong(long dateLong) {
    this.dateLong = dateLong;
  }

  /** M�thode permettant de r�cup�rer la valeur de date.
   * <br/><br/>
   * Method for getting the date value.
   */
  public long getDateLong() {
    return dateLong;
  }

  /** M�thode permettant d'initialiser la  valeur de date.
   * <br/><br/>
   * Method for initializing the date value.
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /** M�thode permettant de r�cup�rer la valeur de date.
   * <br/><br/>
   * Method for getting the date value.
   */
  public Date getDate() {
    return date;
  }

  //nouveau tout ce qui suit
  /**M�thode utils�e pour l'indexation du Java Beans.
   *  Elle initialise le nom de la m�thode get utilis�e avec la r�flexion en Java pour
   *  r�cup�rer le contenu du champs*/
  public void setGetMethod(String getMethod) {
    this.getMethod = getMethod;
  }

  /**
   * Permet de r�cuperer le nom de la m�thode get (utilis�e pour l'indexation du Java
   * Bean) � partir du fichier de configuration de Lius.
   * <br/><br/>
   * Gets the get method (used for JavaBean indexation) from Lius configuration file.
   */
  public String getGetMethod() {
    return getMethod;
  }

  public void setGet(String get) {
    this.get = get;
  }

  public String getGet() {
    return get;
  }

  /**
   * Utilis� pour intialiser le InputStreamReader pour l'indexation du PDF.
   * <br/><br/>
   * Uses for initializing the InputStreamReader for PDF indexation.
   */
  public void setValueInputStreamReader(InputStreamReader
                                        valueInputStreamReader) {
    this.valueInputStreamReader = valueInputStreamReader;
  }

  /**
   * Permet de r�cup�rer le InputStreamReader utilis� pour l'indexation du PDF.
   * <br/><br/>
   * Method for getting the InputStreamReader used for PDF indexation.
   */
  public InputStreamReader getValueInputStreamReader() {
    return valueInputStreamReader;
  }

  /**
   * Utilis� pour intialiser le Reader pour l'indexation du HTML.
   * <br/><br/>
   * Used for initializing the Reader for HTML indexation.
   */
  public void setValueReader(Reader valueReader) {
    this.valueReader = valueReader;
  }

  /**
   * Permet de r�cup�rer le Reader utilis� pour l'indexation du HTML.
   * <br/><br/>
   * Method for getting the Reader used for HTML indexation.
   */
  public Reader getValueReader() {
    return valueReader;
  }

  /**
   * Permet d'initialiser le label du r�sultat de recherche � partir du
   * fichier de configuration.
   * <br/><br/>
   * Initialize the label of search result from configuration file.
   */
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * Permet de r�cup�rer le label du r�sultat de recherche � partir du
   * fichier de configuration.
   * <br/><br/>
   * Gets the search result label from configuration file.
   *
   */
  public String getLabel() {
    return label;
  }

  public void setDateFormat(String dateFormat) {
    this.dateFormat = dateFormat;
  }

  public String getDateFormat() {
    return dateFormat;
  }

  public void setBoost(float boost) {
    this.boost = boost;
  }

  public float getBoost() {
    return boost;
  }

  public void setIsBoosted(boolean isBoostedB) {
    this.isBoostedB = isBoostedB;
  }


  public boolean getIsBoosted(){
    return isBoostedB;
  }

  public void setFragmenter(String fragmenter){
    this.fragmenter=fragmenter;
  }

  public String getFragmenter(){
    return fragmenter;
  }

}