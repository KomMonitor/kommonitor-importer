package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Contains information about imported resource features
 */
@ApiModel(description = "Contains information about imported resource features")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-28T13:12:59.357+01:00")

public class ImportResponseType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("uri")
  private String uri = null;

  @JsonProperty("importedFeatures")
  @Valid
  private List<String> importedFeatures = null;

  @JsonProperty("errors")
  @Valid
  private List<String> errors = null;

  public ImportResponseType uri(String uri) {
    this.uri = uri;
    return this;
  }

  /**
   * URIs of the newly created spatial unit resource
   * @return uri
  **/
  @ApiModelProperty(value = "URIs of the newly created spatial unit resource")


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
  **/
  @ApiModelProperty(value = "list of IDs that indicate those resource features that were imported succesfully")


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
  **/
  @ApiModelProperty(value = "List of error messages that occurred during the import")


  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportResponseType importResponseType = (ImportResponseType) o;
    return Objects.equals(this.uri, importResponseType.uri) &&
        Objects.equals(this.importedFeatures, importResponseType.importedFeatures) &&
        Objects.equals(this.errors, importResponseType.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uri, importedFeatures, errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportResponseType {\n");
    
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    importedFeatures: ").append(toIndentedString(importedFeatures)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

