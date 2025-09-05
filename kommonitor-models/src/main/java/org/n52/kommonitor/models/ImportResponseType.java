package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.n52.kommonitor.models.ImportedAggregationsType;
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
 * Contains information about imported resource features
 */

@Schema(name = "ImportResponseType", description = "Contains information about imported resource features")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-05T13:50:32.126009500+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public class ImportResponseType implements Serializable {

  private static final long serialVersionUID = 1L;

  private @Nullable String uri;

  @Valid
  private @Nullable List<String> importedFeatures;

  @Valid
  private @Nullable List<@Valid ImportedAggregationsType> importedAggregations;

  @Valid
  private @Nullable List<String> errors;

  @Valid
  private @Nullable List<String> warnings;

  public ImportResponseType uri(@Nullable String uri) {
    this.uri = uri;
    return this;
  }

  /**
   * URIs of the newly created spatial unit resource
   * @return uri
   */
  
  @Schema(name = "uri", description = "URIs of the newly created spatial unit resource", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("uri")
  public @Nullable String getUri() {
    return uri;
  }

  public void setUri(@Nullable String uri) {
    this.uri = uri;
  }

  public ImportResponseType importedFeatures(@Nullable List<String> importedFeatures) {
    this.importedFeatures = importedFeatures;
    return this;
  }

  public ImportResponseType addImportedFeaturesItem(String importedFeaturesItem) {
    if (this.importedFeatures == null) {
      this.importedFeatures = new ArrayList<>();
    }
    this.importedFeatures.add(importedFeaturesItem);
    return this;
  }

  /**
   * list of IDs that indicate those resource features that were imported successfully
   * @return importedFeatures
   */
  
  @Schema(name = "importedFeatures", description = "list of IDs that indicate those resource features that were imported successfully", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("importedFeatures")
  public @Nullable List<String> getImportedFeatures() {
    return importedFeatures;
  }

  public void setImportedFeatures(@Nullable List<String> importedFeatures) {
    this.importedFeatures = importedFeatures;
  }

  public ImportResponseType importedAggregations(@Nullable List<@Valid ImportedAggregationsType> importedAggregations) {
    this.importedAggregations = importedAggregations;
    return this;
  }

  public ImportResponseType addImportedAggregationsItem(ImportedAggregationsType importedAggregationsItem) {
    if (this.importedAggregations == null) {
      this.importedAggregations = new ArrayList<>();
    }
    this.importedAggregations.add(importedAggregationsItem);
    return this;
  }

  /**
   * Get importedAggregations
   * @return importedAggregations
   */
  @Valid 
  @Schema(name = "importedAggregations", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("importedAggregations")
  public @Nullable List<@Valid ImportedAggregationsType> getImportedAggregations() {
    return importedAggregations;
  }

  public void setImportedAggregations(@Nullable List<@Valid ImportedAggregationsType> importedAggregations) {
    this.importedAggregations = importedAggregations;
  }

  public ImportResponseType errors(@Nullable List<String> errors) {
    this.errors = errors;
    return this;
  }

  public ImportResponseType addErrorsItem(String errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * List of error messages that occurred during the import
   * @return errors
   */
  
  @Schema(name = "errors", description = "List of error messages that occurred during the import", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errors")
  public @Nullable List<String> getErrors() {
    return errors;
  }

  public void setErrors(@Nullable List<String> errors) {
    this.errors = errors;
  }

  public ImportResponseType warnings(@Nullable List<String> warnings) {
    this.warnings = warnings;
    return this;
  }

  public ImportResponseType addWarningsItem(String warningsItem) {
    if (this.warnings == null) {
      this.warnings = new ArrayList<>();
    }
    this.warnings.add(warningsItem);
    return this;
  }

  /**
   * List of warning messages that occurred during the import
   * @return warnings
   */
  
  @Schema(name = "warnings", description = "List of warning messages that occurred during the import", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("warnings")
  public @Nullable List<String> getWarnings() {
    return warnings;
  }

  public void setWarnings(@Nullable List<String> warnings) {
    this.warnings = warnings;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportResponseType importResponseType = (ImportResponseType) o;
    return Objects.equals(this.uri, importResponseType.uri) &&
        Objects.equals(this.importedFeatures, importResponseType.importedFeatures) &&
        Objects.equals(this.importedAggregations, importResponseType.importedAggregations) &&
        Objects.equals(this.errors, importResponseType.errors) &&
        Objects.equals(this.warnings, importResponseType.warnings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uri, importedFeatures, importedAggregations, errors, warnings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportResponseType {\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    importedFeatures: ").append(toIndentedString(importedFeatures)).append("\n");
    sb.append("    importedAggregations: ").append(toIndentedString(importedAggregations)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    warnings: ").append(toIndentedString(warnings)).append("\n");
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

