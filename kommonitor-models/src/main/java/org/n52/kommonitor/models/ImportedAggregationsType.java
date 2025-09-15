package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * Contains information about imported aggregated features
 */

@Schema(name = "ImportedAggregationsType", description = "Contains information about imported aggregated features")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-05T13:55:51.977247900+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public class ImportedAggregationsType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String spatialUnit;

  @Valid
  private List<String> importedFeatures;

  public ImportedAggregationsType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ImportedAggregationsType(String spatialUnit, List<String> importedFeatures) {
    this.spatialUnit = spatialUnit;
    this.importedFeatures = importedFeatures;
  }

  public ImportedAggregationsType spatialUnit(String spatialUnit) {
    this.spatialUnit = spatialUnit;
    return this;
  }

  /**
   * Name of the spatial unit for which features have been aggregated
   * @return spatialUnit
   */
  @NotNull 
  @Schema(name = "spatialUnit", description = "Name of the spatial unit for which features have been aggregated", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("spatialUnit")
  public String getSpatialUnit() {
    return spatialUnit;
  }

  public void setSpatialUnit(String spatialUnit) {
    this.spatialUnit = spatialUnit;
  }

  public ImportedAggregationsType importedFeatures(List<String> importedFeatures) {
    this.importedFeatures = importedFeatures;
    return this;
  }

  public ImportedAggregationsType addImportedFeaturesItem(String importedFeaturesItem) {
    if (this.importedFeatures == null) {
      this.importedFeatures = new ArrayList<>();
    }
    this.importedFeatures.add(importedFeaturesItem);
    return this;
  }

  /**
   * list of IDs that indicate those resource features of an aggregated spatial unit that were imported successfully
   * @return importedFeatures
   */
  @NotNull 
  @Schema(name = "importedFeatures", description = "list of IDs that indicate those resource features of an aggregated spatial unit that were imported successfully", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("importedFeatures")
  public List<String> getImportedFeatures() {
    return importedFeatures;
  }

  public void setImportedFeatures(List<String> importedFeatures) {
    this.importedFeatures = importedFeatures;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportedAggregationsType importedAggregationsType = (ImportedAggregationsType) o;
    return Objects.equals(this.spatialUnit, importedAggregationsType.spatialUnit) &&
        Objects.equals(this.importedFeatures, importedAggregationsType.importedFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(spatialUnit, importedFeatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportedAggregationsType {\n");
    sb.append("    spatialUnit: ").append(toIndentedString(spatialUnit)).append("\n");
    sb.append("    importedFeatures: ").append(toIndentedString(importedFeatures)).append("\n");
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

