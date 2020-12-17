package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.n52.kommonitor.models.IndicatorPUTInputTypeValueMapping;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * IndicatorPUTInputTypeIndicatorValues
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-31T11:36:14.910+02:00")

public class IndicatorPUTInputTypeIndicatorValues  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("spatialReferenceKey")
  private String spatialReferenceKey = null;

  @JsonProperty("valueMapping")
  @Valid
  private List<IndicatorPUTInputTypeValueMapping> valueMapping = null;

  public IndicatorPUTInputTypeIndicatorValues spatialReferenceKey(String spatialReferenceKey) {
    this.spatialReferenceKey = spatialReferenceKey;
    return this;
  }

  /**
   * identifier (uuid) of the spatial feature to which the values shall be applied
   * @return spatialReferenceKey
  **/
  @ApiModelProperty(value = "identifier (uuid) of the spatial feature to which the values shall be applied")


  public String getSpatialReferenceKey() {
    return spatialReferenceKey;
  }

  public void setSpatialReferenceKey(String spatialReferenceKey) {
    this.spatialReferenceKey = spatialReferenceKey;
  }

  public IndicatorPUTInputTypeIndicatorValues valueMapping(List<IndicatorPUTInputTypeValueMapping> valueMapping) {
    this.valueMapping = valueMapping;
    return this;
  }

  public IndicatorPUTInputTypeIndicatorValues addValueMappingItem(IndicatorPUTInputTypeValueMapping valueMappingItem) {
    if (this.valueMapping == null) {
      this.valueMapping = new ArrayList<>();
    }
    this.valueMapping.add(valueMappingItem);
    return this;
  }

  /**
   * an array of entries mapping an indicator value to a timestamp as mapping key
   * @return valueMapping
  **/
  @ApiModelProperty(value = "an array of entries mapping an indicator value to a timestamp as mapping key")

  @Valid

  public List<IndicatorPUTInputTypeValueMapping> getValueMapping() {
    return valueMapping;
  }

  public void setValueMapping(List<IndicatorPUTInputTypeValueMapping> valueMapping) {
    this.valueMapping = valueMapping;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndicatorPUTInputTypeIndicatorValues indicatorPUTInputTypeIndicatorValues = (IndicatorPUTInputTypeIndicatorValues) o;
    return Objects.equals(this.spatialReferenceKey, indicatorPUTInputTypeIndicatorValues.spatialReferenceKey) &&
        Objects.equals(this.valueMapping, indicatorPUTInputTypeIndicatorValues.valueMapping);
  }

  @Override
  public int hashCode() {
    return Objects.hash(spatialReferenceKey, valueMapping);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndicatorPUTInputTypeIndicatorValues {\n");
    
    sb.append("    spatialReferenceKey: ").append(toIndentedString(spatialReferenceKey)).append("\n");
    sb.append("    valueMapping: ").append(toIndentedString(valueMapping)).append("\n");
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

