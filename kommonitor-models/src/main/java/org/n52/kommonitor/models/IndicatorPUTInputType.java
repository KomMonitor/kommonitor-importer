package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.n52.kommonitor.models.DefaultClassificationMappingType;
import org.n52.kommonitor.models.IndicatorPUTInputTypeIndicatorValues;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * IndicatorPUTInputType
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-23T17:54:30.264884973+02:00[Europe/Berlin]")
public class IndicatorPUTInputType implements Serializable {

  private static final long serialVersionUID = 1L;

  @Valid
  private List<String> allowedRoles = new ArrayList<>();

  private String applicableSpatialUnit;

  private DefaultClassificationMappingType defaultClassificationMapping;

  @Valid
  private List<@Valid IndicatorPUTInputTypeIndicatorValues> indicatorValues = new ArrayList<>();

  /**
   * Default constructor
   * @deprecated Use {@link IndicatorPUTInputType#IndicatorPUTInputType(List<String>, String, List<@Valid IndicatorPUTInputTypeIndicatorValues>)}
   */
  @Deprecated
  public IndicatorPUTInputType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public IndicatorPUTInputType(List<String> allowedRoles, String applicableSpatialUnit, List<@Valid IndicatorPUTInputTypeIndicatorValues> indicatorValues) {
    this.allowedRoles = allowedRoles;
    this.applicableSpatialUnit = applicableSpatialUnit;
    this.indicatorValues = indicatorValues;
  }

  public IndicatorPUTInputType allowedRoles(List<String> allowedRoles) {
    this.allowedRoles = allowedRoles;
    return this;
  }

  public IndicatorPUTInputType addAllowedRolesItem(String allowedRolesItem) {
    if (this.allowedRoles == null) {
      this.allowedRoles = new ArrayList<>();
    }
    this.allowedRoles.add(allowedRolesItem);
    return this;
  }

  /**
   * list of role identifiers that have read access rights for this dataset
   * @return allowedRoles
  */
  @NotNull 
  @Schema(name = "allowedRoles", description = "list of role identifiers that have read access rights for this dataset", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("allowedRoles")
  public List<String> getAllowedRoles() {
    return allowedRoles;
  }

  public void setAllowedRoles(List<String> allowedRoles) {
    this.allowedRoles = allowedRoles;
  }

  public IndicatorPUTInputType applicableSpatialUnit(String applicableSpatialUnit) {
    this.applicableSpatialUnit = applicableSpatialUnit;
    return this;
  }

  /**
   * Get applicableSpatialUnit
   * @return applicableSpatialUnit
  */
  @NotNull 
  @Schema(name = "applicableSpatialUnit", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("applicableSpatialUnit")
  public String getApplicableSpatialUnit() {
    return applicableSpatialUnit;
  }

  public void setApplicableSpatialUnit(String applicableSpatialUnit) {
    this.applicableSpatialUnit = applicableSpatialUnit;
  }

  public IndicatorPUTInputType defaultClassificationMapping(DefaultClassificationMappingType defaultClassificationMapping) {
    this.defaultClassificationMapping = defaultClassificationMapping;
    return this;
  }

  /**
   * Get defaultClassificationMapping
   * @return defaultClassificationMapping
  */
  @Valid 
  @Schema(name = "defaultClassificationMapping", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("defaultClassificationMapping")
  public DefaultClassificationMappingType getDefaultClassificationMapping() {
    return defaultClassificationMapping;
  }

  public void setDefaultClassificationMapping(DefaultClassificationMappingType defaultClassificationMapping) {
    this.defaultClassificationMapping = defaultClassificationMapping;
  }

  public IndicatorPUTInputType indicatorValues(List<@Valid IndicatorPUTInputTypeIndicatorValues> indicatorValues) {
    this.indicatorValues = indicatorValues;
    return this;
  }

  public IndicatorPUTInputType addIndicatorValuesItem(IndicatorPUTInputTypeIndicatorValues indicatorValuesItem) {
    if (this.indicatorValues == null) {
      this.indicatorValues = new ArrayList<>();
    }
    this.indicatorValues.add(indicatorValuesItem);
    return this;
  }

  /**
   * an array of entries containing indicator values and mapping to spatial features via identifiers
   * @return indicatorValues
  */
  @NotNull @Valid 
  @Schema(name = "indicatorValues", description = "an array of entries containing indicator values and mapping to spatial features via identifiers", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("indicatorValues")
  public List<@Valid IndicatorPUTInputTypeIndicatorValues> getIndicatorValues() {
    return indicatorValues;
  }

  public void setIndicatorValues(List<@Valid IndicatorPUTInputTypeIndicatorValues> indicatorValues) {
    this.indicatorValues = indicatorValues;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndicatorPUTInputType indicatorPUTInputType = (IndicatorPUTInputType) o;
    return Objects.equals(this.allowedRoles, indicatorPUTInputType.allowedRoles) &&
        Objects.equals(this.applicableSpatialUnit, indicatorPUTInputType.applicableSpatialUnit) &&
        Objects.equals(this.defaultClassificationMapping, indicatorPUTInputType.defaultClassificationMapping) &&
        Objects.equals(this.indicatorValues, indicatorPUTInputType.indicatorValues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allowedRoles, applicableSpatialUnit, defaultClassificationMapping, indicatorValues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndicatorPUTInputType {\n");
    sb.append("    allowedRoles: ").append(toIndentedString(allowedRoles)).append("\n");
    sb.append("    applicableSpatialUnit: ").append(toIndentedString(applicableSpatialUnit)).append("\n");
    sb.append("    defaultClassificationMapping: ").append(toIndentedString(defaultClassificationMapping)).append("\n");
    sb.append("    indicatorValues: ").append(toIndentedString(indicatorValues)).append("\n");
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

