package org.n52.kommonitor.importer.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.n52.kommonitor.importer.models.ImporterParameterType;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Importer that enables the decoding of a certain dataset format into the KomMonitor specific format of georesources, spatial units and indicators
 */
@ApiModel(description = "Importer that enables the decoding of a certain dataset format into the KomMonitor specific format of georesources, spatial units and indicators")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-29T14:02:28.735+01:00")

public class ImporterType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("mimeType")
  @Valid
  private List<String> mimeType = new ArrayList<String>();

  @JsonProperty("schemas")
  @Valid
  private List<String> schemas = null;

  @JsonProperty("encodings")
  @Valid
  private List<String> encodings = null;

  @JsonProperty("parameters")
  @Valid
  private List<ImporterParameterType> parameters = null;

  public ImporterType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * unique name of the importer
   * @return name
  **/
  @ApiModelProperty(required = true, value = "unique name of the importer")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ImporterType mimeType(List<String> mimeType) {
    this.mimeType = mimeType;
    return this;
  }

  public ImporterType addMimeTypeItem(String mimeTypeItem) {
    this.mimeType.add(mimeTypeItem);
    return this;
  }

  /**
   * list of MIME-types of the source format according to https://www.iana.org/assignments/media-types/media-types.xhtml that are supported by the importer
   * @return mimeType
  **/
  @ApiModelProperty(required = true, value = "list of MIME-types of the source format according to https://www.iana.org/assignments/media-types/media-types.xhtml that are supported by the importer")
  @NotNull


  public List<String> getMimeType() {
    return mimeType;
  }

  public void setMimeType(List<String> mimeType) {
    this.mimeType = mimeType;
  }

  public ImporterType schemas(List<String> schemas) {
    this.schemas = schemas;
    return this;
  }

  public ImporterType addSchemasItem(String schemasItem) {
    if (this.schemas == null) {
      this.schemas = new ArrayList<String>();
    }
    this.schemas.add(schemasItem);
    return this;
  }

  /**
   * list of schemas of the source format (e.g. http://schemas.opengis.net/gml/3.0.0/base/feature.xsd for MIME-type text/xml) that are supported by the importer
   * @return schemas
  **/
  @ApiModelProperty(value = "list of schemas of the source format (e.g. http://schemas.opengis.net/gml/3.0.0/base/feature.xsd for MIME-type text/xml) that are supported by the importer")


  public List<String> getSchemas() {
    return schemas;
  }

  public void setSchemas(List<String> schemas) {
    this.schemas = schemas;
  }

  public ImporterType encodings(List<String> encodings) {
    this.encodings = encodings;
    return this;
  }

  public ImporterType addEncodingsItem(String encodingsItem) {
    if (this.encodings == null) {
      this.encodings = new ArrayList<String>();
    }
    this.encodings.add(encodingsItem);
    return this;
  }

  /**
   * list of encodings that are supported by the importer
   * @return encodings
  **/
  @ApiModelProperty(value = "list of encodings that are supported by the importer")


  public List<String> getEncodings() {
    return encodings;
  }

  public void setEncodings(List<String> encodings) {
    this.encodings = encodings;
  }

  public ImporterType parameters(List<ImporterParameterType> parameters) {
    this.parameters = parameters;
    return this;
  }

  public ImporterType addParametersItem(ImporterParameterType parametersItem) {
    if (this.parameters == null) {
      this.parameters = new ArrayList<ImporterParameterType>();
    }
    this.parameters.add(parametersItem);
    return this;
  }

  /**
   * list of additional parameters that are required for decoding a certain dataset format
   * @return parameters
  **/
  @ApiModelProperty(value = "list of additional parameters that are required for decoding a certain dataset format")

  @Valid

  public List<ImporterParameterType> getParameters() {
    return parameters;
  }

  public void setParameters(List<ImporterParameterType> parameters) {
    this.parameters = parameters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImporterType importerType = (ImporterType) o;
    return Objects.equals(this.name, importerType.name) &&
        Objects.equals(this.mimeType, importerType.mimeType) &&
        Objects.equals(this.schemas, importerType.schemas) &&
        Objects.equals(this.encodings, importerType.encodings) &&
        Objects.equals(this.parameters, importerType.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, mimeType, schemas, encodings, parameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImporterType {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    schemas: ").append(toIndentedString(schemas)).append("\n");
    sb.append("    encodings: ").append(toIndentedString(encodings)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
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

