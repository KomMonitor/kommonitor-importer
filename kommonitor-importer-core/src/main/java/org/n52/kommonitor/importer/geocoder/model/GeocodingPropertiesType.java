package org.n52.kommonitor.importer.geocoder.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * GeocodingPropertiesType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-14T08:15:39.526Z[GMT]")


public class GeocodingPropertiesType   {
  @JsonProperty("category")
  private String category = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("display_name")
  private String displayName = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("postcode")
  private String postcode = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("district")
  private String district = null;

  @JsonProperty("street")
  private String street = null;

  @JsonProperty("housenumber")
  private String housenumber = null;

  public GeocodingPropertiesType category(String category) {
    this.category = category;
    return this;
  }

  /**
   * category of response (osm_key)
   * @return category
   **/
  
    public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public GeocodingPropertiesType type(String type) {
    this.type = type;
    return this;
  }

  /**
   * type within category (osm_value)
   * @return type
   **/
  
    public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GeocodingPropertiesType displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * a descriptive string combining several address details within one string (i.e. for display popup purposes)
   * @return displayName
   **/
  
    public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public GeocodingPropertiesType country(String country) {
    this.country = country;
    return this;
  }

  /**
   * name of the country
   * @return country
   **/
  
    public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public GeocodingPropertiesType state(String state) {
    this.state = state;
    return this;
  }

  /**
   * name of the state
   * @return state
   **/
  
    public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public GeocodingPropertiesType postcode(String postcode) {
    this.postcode = postcode;
    return this;
  }

  /**
   * postal code
   * @return postcode
   **/
  
    public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public GeocodingPropertiesType city(String city) {
    this.city = city;
    return this;
  }

  /**
   * name of the city
   * @return city
   **/
  
    public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public GeocodingPropertiesType district(String district) {
    this.district = district;
    return this;
  }

  /**
   * name of the city district
   * @return district
   **/
  
    public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public GeocodingPropertiesType street(String street) {
    this.street = street;
    return this;
  }

  /**
   * name of the street
   * @return street
   **/
  
    public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public GeocodingPropertiesType housenumber(String housenumber) {
    this.housenumber = housenumber;
    return this;
  }

  /**
   * house number (including any suffix) if available
   * @return housenumber
   **/
  
    public String getHousenumber() {
    return housenumber;
  }

  public void setHousenumber(String housenumber) {
    this.housenumber = housenumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeocodingPropertiesType geocodingPropertiesType = (GeocodingPropertiesType) o;
    return Objects.equals(this.category, geocodingPropertiesType.category) &&
        Objects.equals(this.type, geocodingPropertiesType.type) &&
        Objects.equals(this.displayName, geocodingPropertiesType.displayName) &&
        Objects.equals(this.country, geocodingPropertiesType.country) &&
        Objects.equals(this.state, geocodingPropertiesType.state) &&
        Objects.equals(this.postcode, geocodingPropertiesType.postcode) &&
        Objects.equals(this.city, geocodingPropertiesType.city) &&
        Objects.equals(this.district, geocodingPropertiesType.district) &&
        Objects.equals(this.street, geocodingPropertiesType.street) &&
        Objects.equals(this.housenumber, geocodingPropertiesType.housenumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, type, displayName, country, state, postcode, city, district, street, housenumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeocodingPropertiesType {\n");
    
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    postcode: ").append(toIndentedString(postcode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    district: ").append(toIndentedString(district)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    housenumber: ").append(toIndentedString(housenumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
