/*
 * KomMonitor Geocoder Proxy
 * KomMonitor Geocoder Proxy that defines a common query and response interface for arbitrary geocoding services like nominatim, photon (datasource is OSM)
 *
 * OpenAPI spec version: 0.0.1
 * Contact: christian.danowski-buhren@hs-bochum.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package org.n52.kommonitor.importer.geocoder.model;

import java.io.IOException;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
/**
 * GeocodingPropertiesType
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2022-08-25T09:59:40.286Z[GMT]")
public class GeocodingPropertiesType {
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

  /**
   * evaluation of geocoding result (unresolved &#x3D; least accurate cause false street and/or city/postcode; low_accuracy &#x3D; more accurate due to same street and same city/postcode but no housenumber; high_accuracy &#x3D; most accurate due to same street and same city/postcode and same housenumber)
   */
  @JsonAdapter(GeocoderankEnum.Adapter.class)
  public enum GeocoderankEnum {
    UNRESOLVED("unresolved"),
    LOW_ACCURACY("low_accuracy"),
    HIGH_ACCURACY("high_accuracy");

    private String value;

    GeocoderankEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static GeocoderankEnum fromValue(String input) {
      for (GeocoderankEnum b : GeocoderankEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<GeocoderankEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final GeocoderankEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public GeocoderankEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return GeocoderankEnum.fromValue((String)(value));
      }
    }
  }  
  @JsonProperty("geocoderank")
  private GeocoderankEnum geocoderank = null;
  
  @JsonProperty("geocodedesc")
  private GeocoderankEnum geocodedesc = null;


  public GeocoderankEnum getGeocodedesc() {
	return geocodedesc;
}

public void setGeocodedesc(GeocoderankEnum geocodedesc) {
	this.geocodedesc = geocodedesc;
}

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

  public GeocodingPropertiesType geocoderank(GeocoderankEnum geocoderank) {
    this.geocoderank = geocoderank;
    return this;
  }

   /**
   * evaluation of geocoding result (0 &#x3D; least accurate cause at most same street; 1 &#x3D; more accurate due to same street and same city/postcode but no housenumber; 2 &#x3D; most accurate due to same street and same city/postcode and same housenumber)
   * @return geocoderank
  **/
  public GeocoderankEnum getGeocoderank() {
    return geocoderank;
  }

  public void setGeocoderank(GeocoderankEnum geocoderank) {
    this.geocoderank = geocoderank;
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
        Objects.equals(this.housenumber, geocodingPropertiesType.housenumber) &&
        Objects.equals(this.geocoderank, geocodingPropertiesType.geocoderank) &&
        Objects.equals(this.geocodedesc, geocodingPropertiesType.geocodedesc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, type, displayName, country, state, postcode, city, district, street, housenumber, geocoderank);
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
    sb.append("    geocoderank: ").append(toIndentedString(geocoderank)).append("\n");
    sb.append("    geocodedesc: ").append(toIndentedString(geocodedesc)).append("\n");
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
