package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.n52.kommonitor.models.PeriodOfValidityType;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SpatialUnitPUTInputType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-13T18:38:01.029+01:00")

public class SpatialUnitPUTInputType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("periodOfValidity")
  private PeriodOfValidityType periodOfValidity = null;

  @JsonProperty("geoJsonString")
  private String geoJsonString = null;

  public SpatialUnitPUTInputType periodOfValidity(PeriodOfValidityType periodOfValidity) {
    this.periodOfValidity = periodOfValidity;
    return this;
  }

  /**
   * Get periodOfValidity
   * @return periodOfValidity
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public PeriodOfValidityType getPeriodOfValidity() {
    return periodOfValidity;
  }

  public void setPeriodOfValidity(PeriodOfValidityType periodOfValidity) {
    this.periodOfValidity = periodOfValidity;
  }

  public SpatialUnitPUTInputType geoJsonString(String geoJsonString) {
    this.geoJsonString = geoJsonString;
    return this;
  }

  /**
   * a valid GeoJSON string containing the features consisting of a geometry and a unique identifier as property 'uuid'
   * @return geoJsonString
  **/
  @ApiModelProperty(required = true, value = "a valid GeoJSON string containing the features consisting of a geometry and a unique identifier as property 'uuid'")


  public String getGeoJsonString() {
    return geoJsonString;
  }

  public void setGeoJsonString(String geoJsonString) {
    this.geoJsonString = geoJsonString;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpatialUnitPUTInputType spatialUnitPUTInputType = (SpatialUnitPUTInputType) o;
    return Objects.equals(this.periodOfValidity, spatialUnitPUTInputType.periodOfValidity) &&
        Objects.equals(this.geoJsonString, spatialUnitPUTInputType.geoJsonString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(periodOfValidity, geoJsonString);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpatialUnitPUTInputType {\n");
    
    sb.append("    periodOfValidity: ").append(toIndentedString(periodOfValidity)).append("\n");
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

