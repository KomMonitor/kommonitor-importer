package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-30T07:59:21.228371+02:00[Europe/Berlin]")
public class ImportResponseType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String uri;

  @Valid
  private List<String> importedFeatures;

  @Valid
  private List<String> errors;

  @Valid
  private List<String> warnings;

  public ImportResponseType uri(String uri) {
    this.uri = uri;
    return this;
  }

  /**
   * URIs of the newly created spatial unit resource
   * @return uri
  */
  
  @Schema(name = "uri", description = "URIs of the newly created spatial unit resource", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("uri")
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public ImportResponseType importedFeatures(List<String> importedFeatures) {
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
   * list of IDs that indicate those resource features that were imported succesfully
   * @return importedFeatures
  */
  
  @Schema(name = "importedFeatures", description = "list of IDs that indicate those resource features that were imported succesfully", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("importedFeatures")
  public List<String> getImportedFeatures() {
    return importedFeatures;
  }

  public void setImportedFeatures(List<String> importedFeatures) {
    this.importedFeatures = importedFeatures;
  }

  public ImportResponseType errors(List<String> errors) {
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
  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

  public ImportResponseType warnings(List<String> warnings) {
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
  public List<String> getWarnings() {
    return warnings;
  }

  public void setWarnings(List<String> warnings) {
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
        Objects.equals(this.errors, importResponseType.errors) &&
        Objects.equals(this.warnings, importResponseType.warnings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uri, importedFeatures, errors, warnings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportResponseType {\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    importedFeatures: ").append(toIndentedString(importedFeatures)).append("\n");
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

