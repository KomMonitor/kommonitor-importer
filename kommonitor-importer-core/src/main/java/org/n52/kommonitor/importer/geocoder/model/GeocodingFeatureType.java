package org.n52.kommonitor.importer.geocoder.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * GeocodingFeatureType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-14T08:15:39.526Z[GMT]")


public class GeocodingFeatureType   {
  @JsonProperty("geometry")
  private GeocodingGeometryType geometry = null;

  @JsonProperty("properties")
  private GeocodingPropertiesType properties = null;

  public GeocodingFeatureType geometry(GeocodingGeometryType geometry) {
    this.geometry = geometry;
    return this;
  }

  /**
   * Get geometry
   * @return geometry
   **/
  
    @Valid
    public GeocodingGeometryType getGeometry() {
    return geometry;
  }

  public void setGeometry(GeocodingGeometryType geometry) {
    this.geometry = geometry;
  }

  public GeocodingFeatureType properties(GeocodingPropertiesType properties) {
    this.properties = properties;
    return this;
  }

  /**
   * Get properties
   * @return properties
   **/
  
    @Valid
    public GeocodingPropertiesType getProperties() {
    return properties;
  }

  public void setProperties(GeocodingPropertiesType properties) {
    this.properties = properties;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeocodingFeatureType geocodingFeatureType = (GeocodingFeatureType) o;
    return Objects.equals(this.geometry, geocodingFeatureType.geometry) &&
        Objects.equals(this.properties, geocodingFeatureType.properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(geometry, properties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeocodingFeatureType {\n");
    
    sb.append("    geometry: ").append(toIndentedString(geometry)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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
