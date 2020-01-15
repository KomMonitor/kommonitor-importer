package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GeoresourcePUTInputType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-13T17:03:30.872+01:00")

public class GeoresourcePUTInputType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("periodOfValidity")
  private PeriodOfValidityType periodOfValidity = null;

  @JsonProperty("geoJsonString")
  private String geoJsonString = null;

  public GeoresourcePUTInputType periodOfValidity(PeriodOfValidityType periodOfValidity) {
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

  public GeoresourcePUTInputType geoJsonString(String geoJsonString) {
    this.geoJsonString = geoJsonString;
    return this;
  }

  /**
   * a valid GeoJSON string containing the features consisting of a geometry and properties specific to the dataset
   * @return geoJsonString
  **/
  @ApiModelProperty(required = true, value = "a valid GeoJSON string containing the features consisting of a geometry and properties specific to the dataset")


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
    GeoresourcePUTInputType georesourcePUTInputType = (GeoresourcePUTInputType) o;
    return Objects.equals(this.periodOfValidity, georesourcePUTInputType.periodOfValidity) &&
        Objects.equals(this.geoJsonString, georesourcePUTInputType.geoJsonString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(periodOfValidity, geoJsonString);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoresourcePUTInputType {\n");
    
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

