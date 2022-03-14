package org.n52.kommonitor.importer.geocoder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * output generated by a geocoding request. 0 or more records in the form of a GeoJSON FeatureCollection (if emtpy then the returned FeatureCollection has an empty features array)
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-14T08:15:39.526Z[GMT]")


public class GeocodingOutputType   {
  @JsonProperty("type")
  private String type = "FeatureCollection";

  @JsonProperty("features")
  @Valid
  private List<GeocodingFeatureType> features = null;

  public GeocodingOutputType type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  
    public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GeocodingOutputType features(List<GeocodingFeatureType> features) {
    this.features = features;
    return this;
  }

  public GeocodingOutputType addFeaturesItem(GeocodingFeatureType featuresItem) {
    if (this.features == null) {
      this.features = new ArrayList<GeocodingFeatureType>();
    }
    this.features.add(featuresItem);
    return this;
  }

  /**
   * Get features
   * @return features
   **/
      @Valid
    public List<GeocodingFeatureType> getFeatures() {
    return features;
  }

  public void setFeatures(List<GeocodingFeatureType> features) {
    this.features = features;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeocodingOutputType geocodingOutputType = (GeocodingOutputType) o;
    return Objects.equals(this.type, geocodingOutputType.type) &&
        Objects.equals(this.features, geocodingOutputType.features);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, features);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeocodingOutputType {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
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
