package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.n52.kommonitor.models.AttributeMappingType;
import org.n52.kommonitor.models.TimeseriesMappingType;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Definitions for mapping datasource properties to required properties for indicators
 */

@Schema(name = "IndicatorPropertyMappingType", description = "Definitions for mapping datasource properties to required properties for indicators")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-01T12:23:45.798187400+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public class IndicatorPropertyMappingType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String spatialReferenceKeyProperty;

  @Valid
  private List<@Valid TimeseriesMappingType> timeseriesMappings = new ArrayList<>();

  private Boolean keepMissingOrNullValueIndicator;

  @Valid
  private List<@Valid AttributeMappingType> attributeMappings = new ArrayList<>();

  public IndicatorPropertyMappingType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public IndicatorPropertyMappingType(String spatialReferenceKeyProperty, Boolean keepMissingOrNullValueIndicator) {
    this.spatialReferenceKeyProperty = spatialReferenceKeyProperty;
    this.keepMissingOrNullValueIndicator = keepMissingOrNullValueIndicator;
  }

  public IndicatorPropertyMappingType spatialReferenceKeyProperty(String spatialReferenceKeyProperty) {
    this.spatialReferenceKeyProperty = spatialReferenceKeyProperty;
    return this;
  }

  /**
   * property that contains the identifier of the spatial feature to which the values shall be applied
   * @return spatialReferenceKeyProperty
   */
  @NotNull 
  @Schema(name = "spatialReferenceKeyProperty", description = "property that contains the identifier of the spatial feature to which the values shall be applied", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("spatialReferenceKeyProperty")
  public String getSpatialReferenceKeyProperty() {
    return spatialReferenceKeyProperty;
  }

  public void setSpatialReferenceKeyProperty(String spatialReferenceKeyProperty) {
    this.spatialReferenceKeyProperty = spatialReferenceKeyProperty;
  }

  public IndicatorPropertyMappingType timeseriesMappings(List<@Valid TimeseriesMappingType> timeseriesMappings) {
    this.timeseriesMappings = timeseriesMappings;
    return this;
  }

  public IndicatorPropertyMappingType addTimeseriesMappingsItem(TimeseriesMappingType timeseriesMappingsItem) {
    if (this.timeseriesMappings == null) {
      this.timeseriesMappings = new ArrayList<>();
    }
    this.timeseriesMappings.add(timeseriesMappingsItem);
    return this;
  }

  /**
   * list of property mappings for timeseries values
   * @return timeseriesMappings
   */
  @Valid 
  @Schema(name = "timeseriesMappings", description = "list of property mappings for timeseries values", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timeseriesMappings")
  public List<@Valid TimeseriesMappingType> getTimeseriesMappings() {
    return timeseriesMappings;
  }

  public void setTimeseriesMappings(List<@Valid TimeseriesMappingType> timeseriesMappings) {
    this.timeseriesMappings = timeseriesMappings;
  }

  public IndicatorPropertyMappingType keepMissingOrNullValueIndicator(Boolean keepMissingOrNullValueIndicator) {
    this.keepMissingOrNullValueIndicator = keepMissingOrNullValueIndicator;
    return this;
  }

  /**
   * Indicates if missing Indicators or Indicators with a null value should be kept. Missing Indicators will be added with a null value and Indicators that hold a null value will be kept.
   * @return keepMissingOrNullValueIndicator
   */
  @NotNull 
  @Schema(name = "keepMissingOrNullValueIndicator", description = "Indicates if missing Indicators or Indicators with a null value should be kept. Missing Indicators will be added with a null value and Indicators that hold a null value will be kept.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("keepMissingOrNullValueIndicator")
  public Boolean getKeepMissingOrNullValueIndicator() {
    return keepMissingOrNullValueIndicator;
  }

  public void setKeepMissingOrNullValueIndicator(Boolean keepMissingOrNullValueIndicator) {
    this.keepMissingOrNullValueIndicator = keepMissingOrNullValueIndicator;
  }

  public IndicatorPropertyMappingType attributeMappings(List<@Valid AttributeMappingType> attributeMappings) {
    this.attributeMappings = attributeMappings;
    return this;
  }

  public IndicatorPropertyMappingType addAttributeMappingsItem(AttributeMappingType attributeMappingsItem) {
    if (this.attributeMappings == null) {
      this.attributeMappings = new ArrayList<>();
    }
    this.attributeMappings.add(attributeMappingsItem);
    return this;
  }

  /**
   * list of additional attribute mappings
   * @return attributeMappings
   */
  @Valid 
  @Schema(name = "attributeMappings", description = "list of additional attribute mappings", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("attributeMappings")
  public List<@Valid AttributeMappingType> getAttributeMappings() {
    return attributeMappings;
  }

  public void setAttributeMappings(List<@Valid AttributeMappingType> attributeMappings) {
    this.attributeMappings = attributeMappings;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndicatorPropertyMappingType indicatorPropertyMappingType = (IndicatorPropertyMappingType) o;
    return Objects.equals(this.spatialReferenceKeyProperty, indicatorPropertyMappingType.spatialReferenceKeyProperty) &&
        Objects.equals(this.timeseriesMappings, indicatorPropertyMappingType.timeseriesMappings) &&
        Objects.equals(this.keepMissingOrNullValueIndicator, indicatorPropertyMappingType.keepMissingOrNullValueIndicator) &&
        Objects.equals(this.attributeMappings, indicatorPropertyMappingType.attributeMappings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(spatialReferenceKeyProperty, timeseriesMappings, keepMissingOrNullValueIndicator, attributeMappings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndicatorPropertyMappingType {\n");
    sb.append("    spatialReferenceKeyProperty: ").append(toIndentedString(spatialReferenceKeyProperty)).append("\n");
    sb.append("    timeseriesMappings: ").append(toIndentedString(timeseriesMappings)).append("\n");
    sb.append("    keepMissingOrNullValueIndicator: ").append(toIndentedString(keepMissingOrNullValueIndicator)).append("\n");
    sb.append("    attributeMappings: ").append(toIndentedString(attributeMappings)).append("\n");
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

