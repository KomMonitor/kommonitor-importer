package org.n52.kommonitor.importer.geocoder.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * GeocodingStructuredBatchInputType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-05T20:53:57.529Z[GMT]")


public class GeocodingStructuredBatchInputType   {
  @JsonProperty("country")
  private String country = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("district")
  private String district = null;

  @JsonProperty("postcode")
  private String postcode = null;

  @JsonProperty("street")
  private String street = null;

  @JsonProperty("housenumber")
  private String housenumber = null;

  public GeocodingStructuredBatchInputType country(String country) {
    this.country = country;
    return this;
  }

  /**
   * optional country name
   * @return country
   **/
  
    public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public GeocodingStructuredBatchInputType state(String state) {
    this.state = state;
    return this;
  }

  /**
   * optional state name
   * @return state
   **/
  
    public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public GeocodingStructuredBatchInputType city(String city) {
    this.city = city;
    return this;
  }

  /**
   * optional city name
   * @return city
   **/
  
    public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public GeocodingStructuredBatchInputType district(String district) {
    this.district = district;
    return this;
  }

  /**
   * optional district name
   * @return district
   **/
  
    public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public GeocodingStructuredBatchInputType postcode(String postcode) {
    this.postcode = postcode;
    return this;
  }

  /**
   * optional postcode name
   * @return postcode
   **/
  
    public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public GeocodingStructuredBatchInputType street(String street) {
    this.street = street;
    return this;
  }

  /**
   * optional street name
   * @return street
   **/
  
    public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public GeocodingStructuredBatchInputType housenumber(String housenumber) {
    this.housenumber = housenumber;
    return this;
  }

  /**
   * optional housenumber name
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
    GeocodingStructuredBatchInputType geocodingStructuredBatchInputType = (GeocodingStructuredBatchInputType) o;
    return Objects.equals(this.country, geocodingStructuredBatchInputType.country) &&
        Objects.equals(this.state, geocodingStructuredBatchInputType.state) &&
        Objects.equals(this.city, geocodingStructuredBatchInputType.city) &&
        Objects.equals(this.district, geocodingStructuredBatchInputType.district) &&
        Objects.equals(this.postcode, geocodingStructuredBatchInputType.postcode) &&
        Objects.equals(this.street, geocodingStructuredBatchInputType.street) &&
        Objects.equals(this.housenumber, geocodingStructuredBatchInputType.housenumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(country, state, city, district, postcode, street, housenumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeocodingStructuredBatchInputType {\n");
    
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    district: ").append(toIndentedString(district)).append("\n");
    sb.append("    postcode: ").append(toIndentedString(postcode)).append("\n");
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
