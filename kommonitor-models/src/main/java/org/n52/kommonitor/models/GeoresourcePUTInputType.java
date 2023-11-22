package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.n52.kommonitor.models.PeriodOfValidityType;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * GeoresourcePUTInputType
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-23T17:54:30.264884973+02:00[Europe/Berlin]")
public class GeoresourcePUTInputType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String geoJsonString;

  private PeriodOfValidityType periodOfValidity;

  private Boolean isPartialUpdate;

  /**
   * Default constructor
   * @deprecated Use {@link GeoresourcePUTInputType#GeoresourcePUTInputType(String, PeriodOfValidityType, Boolean)}
   */
  @Deprecated
  public GeoresourcePUTInputType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GeoresourcePUTInputType(String geoJsonString, PeriodOfValidityType periodOfValidity, Boolean isPartialUpdate) {
    this.geoJsonString = geoJsonString;
    this.periodOfValidity = periodOfValidity;
    this.isPartialUpdate = isPartialUpdate;
  }

  public GeoresourcePUTInputType geoJsonString(String geoJsonString) {
    this.geoJsonString = geoJsonString;
    return this;
  }

  /**
   * a valid GeoJSON string containing the features consisting of a geometry and properties specific to the dataset
   * @return geoJsonString
  */
  @NotNull 
  @Schema(name = "geoJsonString", description = "a valid GeoJSON string containing the features consisting of a geometry and properties specific to the dataset", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("geoJsonString")
  public String getGeoJsonString() {
    return geoJsonString;
  }

  public void setGeoJsonString(String geoJsonString) {
    this.geoJsonString = geoJsonString;
  }

  public GeoresourcePUTInputType periodOfValidity(PeriodOfValidityType periodOfValidity) {
    this.periodOfValidity = periodOfValidity;
    return this;
  }

  /**
   * Get periodOfValidity
   * @return periodOfValidity
  */
  @NotNull @Valid 
  @Schema(name = "periodOfValidity", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("periodOfValidity")
  public PeriodOfValidityType getPeriodOfValidity() {
    return periodOfValidity;
  }

  public void setPeriodOfValidity(PeriodOfValidityType periodOfValidity) {
    this.periodOfValidity = periodOfValidity;
  }

  public GeoresourcePUTInputType isPartialUpdate(Boolean isPartialUpdate) {
    this.isPartialUpdate = isPartialUpdate;
    return this;
  }

  /**
   * if set to TRUE, then a partial upload of geometries is possible. Missing features that are already in the database will then not be deleted
   * @return isPartialUpdate
  */
  @NotNull 
  @Schema(name = "isPartialUpdate", description = "if set to TRUE, then a partial upload of geometries is possible. Missing features that are already in the database will then not be deleted", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("isPartialUpdate")
  public Boolean getIsPartialUpdate() {
    return isPartialUpdate;
  }

  public void setIsPartialUpdate(Boolean isPartialUpdate) {
    this.isPartialUpdate = isPartialUpdate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoresourcePUTInputType georesourcePUTInputType = (GeoresourcePUTInputType) o;
    return Objects.equals(this.geoJsonString, georesourcePUTInputType.geoJsonString) &&
        Objects.equals(this.periodOfValidity, georesourcePUTInputType.periodOfValidity) &&
        Objects.equals(this.isPartialUpdate, georesourcePUTInputType.isPartialUpdate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(geoJsonString, periodOfValidity, isPartialUpdate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoresourcePUTInputType {\n");
    sb.append("    geoJsonString: ").append(toIndentedString(geoJsonString)).append("\n");
    sb.append("    periodOfValidity: ").append(toIndentedString(periodOfValidity)).append("\n");
    sb.append("    isPartialUpdate: ").append(toIndentedString(isPartialUpdate)).append("\n");
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

