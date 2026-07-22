package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
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
 * IndicatorPOSTInputTypeCategoricalValueMapping
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-07-21T15:22:03.721718300+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public class IndicatorPOSTInputTypeCategoricalValueMapping extends IndicatorPOSTInputTypeValueMapping implements Serializable {

  private static final long serialVersionUID = 1L;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate timestamp;

  private String indicatorValue;

  public IndicatorPOSTInputTypeCategoricalValueMapping() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public IndicatorPOSTInputTypeCategoricalValueMapping(LocalDate timestamp, String indicatorValue) {
    this.timestamp = timestamp;
    this.indicatorValue = indicatorValue;
  }

  public IndicatorPOSTInputTypeCategoricalValueMapping timestamp(LocalDate timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * timestamp consisting of year, month and day according to ISO 8601 (e.g. 2018-01-30)
   * @return timestamp
   */
  @NotNull @Valid 
  @Schema(name = "timestamp", description = "timestamp consisting of year, month and day according to ISO 8601 (e.g. 2018-01-30)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("timestamp")
  public LocalDate getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDate timestamp) {
    this.timestamp = timestamp;
  }

  public IndicatorPOSTInputTypeCategoricalValueMapping indicatorValue(String indicatorValue) {
    this.indicatorValue = indicatorValue;
    return this;
  }

  /**
   * the text-based categorical value of the indicator for the timestamp
   * @return indicatorValue
   */
  @NotNull 
  @Schema(name = "indicatorValue", example = "high", description = "the text-based categorical value of the indicator for the timestamp", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("indicatorValue")
  public String getIndicatorValue() {
    return indicatorValue;
  }

  public void setIndicatorValue(String indicatorValue) {
    this.indicatorValue = indicatorValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndicatorPOSTInputTypeCategoricalValueMapping indicatorPOSTInputTypeCategoricalValueMapping = (IndicatorPOSTInputTypeCategoricalValueMapping) o;
    return Objects.equals(this.timestamp, indicatorPOSTInputTypeCategoricalValueMapping.timestamp) &&
        Objects.equals(this.indicatorValue, indicatorPOSTInputTypeCategoricalValueMapping.indicatorValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, indicatorValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndicatorPOSTInputTypeCategoricalValueMapping {\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    indicatorValue: ").append(toIndentedString(indicatorValue)).append("\n");
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

