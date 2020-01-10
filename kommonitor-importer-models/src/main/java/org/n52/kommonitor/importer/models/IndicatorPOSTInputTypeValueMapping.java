package org.n52.kommonitor.importer.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * IndicatorPOSTInputTypeValueMapping
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-10T12:37:10.215+01:00")

public class IndicatorPOSTInputTypeValueMapping  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("timestamp")
  private LocalDate timestamp = null;

  @JsonProperty("indicatorValue")
  private Float indicatorValue = null;

  public IndicatorPOSTInputTypeValueMapping timestamp(LocalDate timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * timestamp consisting of year, month and day according to ISO 8601 (e.g. 2018-01-30)
   * @return timestamp
  **/
  @ApiModelProperty(value = "timestamp consisting of year, month and day according to ISO 8601 (e.g. 2018-01-30)")

  @Valid

  public LocalDate getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDate timestamp) {
    this.timestamp = timestamp;
  }

  public IndicatorPOSTInputTypeValueMapping indicatorValue(Float indicatorValue) {
    this.indicatorValue = indicatorValue;
    return this;
  }

  /**
   * the numeric extent of the indicator for the timestamp
   * @return indicatorValue
  **/
  @ApiModelProperty(value = "the numeric extent of the indicator for the timestamp")


  public Float getIndicatorValue() {
    return indicatorValue;
  }

  public void setIndicatorValue(Float indicatorValue) {
    this.indicatorValue = indicatorValue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndicatorPOSTInputTypeValueMapping indicatorPOSTInputTypeValueMapping = (IndicatorPOSTInputTypeValueMapping) o;
    return Objects.equals(this.timestamp, indicatorPOSTInputTypeValueMapping.timestamp) &&
        Objects.equals(this.indicatorValue, indicatorPOSTInputTypeValueMapping.indicatorValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, indicatorValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndicatorPOSTInputTypeValueMapping {\n");
    
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    indicatorValue: ").append(toIndentedString(indicatorValue)).append("\n");
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

