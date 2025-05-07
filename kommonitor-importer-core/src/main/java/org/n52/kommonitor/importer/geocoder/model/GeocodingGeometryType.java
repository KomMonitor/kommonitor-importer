package org.n52.kommonitor.importer.geocoder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * GeocodingGeometryType
 */
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-14T08:15:39.526Z[GMT]")


public class GeocodingGeometryType   {
  @JsonProperty("type")
  private String type = "Point";

  @JsonProperty("coordinates")
  @Valid
  private List<Float> coordinates = null;

  public GeocodingGeometryType type(String type) {
    this.type = type;
    return this;
  }

  /**
   * the geometry type of the feature - here in geocoding context it is always point
   * @return type
   **/
  
    public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GeocodingGeometryType coordinates(List<Float> coordinates) {
    this.coordinates = coordinates;
    return this;
  }

  public GeocodingGeometryType addCoordinatesItem(Float coordinatesItem) {
    if (this.coordinates == null) {
      this.coordinates = new ArrayList<Float>();
    }
    this.coordinates.add(coordinatesItem);
    return this;
  }

  /**
   * coordinate array of feature point geometry using longitude, latitude
   * @return coordinates
   **/
  
    public List<Float> getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(List<Float> coordinates) {
    this.coordinates = coordinates;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeocodingGeometryType geocodingGeometryType = (GeocodingGeometryType) o;
    return Objects.equals(this.type, geocodingGeometryType.type) &&
        Objects.equals(this.coordinates, geocodingGeometryType.coordinates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, coordinates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeocodingGeometryType {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
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
