package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * IndicatorPropertiesWithoutGeomType
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-30T10:55:32.223531300+01:00[Europe/Berlin]")
public class IndicatorPropertiesWithoutGeomType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  private String name;

  private String validStartDate;

  private String validEndDate;

  /**
   * Default constructor
   * @deprecated Use {@link IndicatorPropertiesWithoutGeomType#IndicatorPropertiesWithoutGeomType(String, String, String, String)}
   */
  @Deprecated
  public IndicatorPropertiesWithoutGeomType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public IndicatorPropertiesWithoutGeomType(String id, String name, String validStartDate, String validEndDate) {
    this.id = id;
    this.name = name;
    this.validStartDate = validStartDate;
    this.validEndDate = validEndDate;
  }

  public IndicatorPropertiesWithoutGeomType id(String id) {
    this.id = id;
    return this;
  }

  /**
   * the id of the spatial feature
   * @return id
  */
  @NotNull 
  @Schema(name = "id", description = "the id of the spatial feature", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public IndicatorPropertiesWithoutGeomType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * the name of the spatial feature
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "the name of the spatial feature", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public IndicatorPropertiesWithoutGeomType validStartDate(String validStartDate) {
    this.validStartDate = validStartDate;
    return this;
  }

  /**
   * the start date from which on the spatial feature is valid
   * @return validStartDate
  */
  @NotNull 
  @Schema(name = "validStartDate", description = "the start date from which on the spatial feature is valid", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("validStartDate")
  public String getValidStartDate() {
    return validStartDate;
  }

  public void setValidStartDate(String validStartDate) {
    this.validStartDate = validStartDate;
  }

  public IndicatorPropertiesWithoutGeomType validEndDate(String validEndDate) {
    this.validEndDate = validEndDate;
    return this;
  }

  /**
   * the end date until the spatial feature is valid - or null if not set
   * @return validEndDate
  */
  @NotNull 
  @Schema(name = "validEndDate", description = "the end date until the spatial feature is valid - or null if not set", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("validEndDate")
  public String getValidEndDate() {
    return validEndDate;
  }

  public void setValidEndDate(String validEndDate) {
    this.validEndDate = validEndDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndicatorPropertiesWithoutGeomType indicatorPropertiesWithoutGeomType = (IndicatorPropertiesWithoutGeomType) o;
    return Objects.equals(this.id, indicatorPropertiesWithoutGeomType.id) &&
        Objects.equals(this.name, indicatorPropertiesWithoutGeomType.name) &&
        Objects.equals(this.validStartDate, indicatorPropertiesWithoutGeomType.validStartDate) &&
        Objects.equals(this.validEndDate, indicatorPropertiesWithoutGeomType.validEndDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, validStartDate, validEndDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndicatorPropertiesWithoutGeomType {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    validStartDate: ").append(toIndentedString(validStartDate)).append("\n");
    sb.append("    validEndDate: ").append(toIndentedString(validEndDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

