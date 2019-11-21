package org.n52.kommonitor.importer.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.n52.kommonitor.importer.models.DatasetReferenceType;
import org.n52.kommonitor.importer.models.FormatType;
import org.n52.kommonitor.importer.models.PayloadType;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ImportDataSourceType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-21T17:13:28.580+01:00")

public class ImportDataSourceType  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * the source format from which geodata or indicator data can be extracted
   */
  public enum TypeEnum {
    WFS("WFS"),
    
    GEOJSON("GEOJSON"),
    
    SHAPE("SHAPE"),
    
    GML("GML"),
    
    EXCEL("EXCEL"),
    
    CSV("CSV");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("format")
  private FormatType format = null;

  @JsonProperty("payload")
  private PayloadType payload = null;

  @JsonProperty("datasetReference")
  private DatasetReferenceType datasetReference = null;

  public ImportDataSourceType type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * the source format from which geodata or indicator data can be extracted
   * @return type
  **/
  @ApiModelProperty(required = true, value = "the source format from which geodata or indicator data can be extracted")
  @NotNull


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ImportDataSourceType format(FormatType format) {
    this.format = format;
    return this;
  }

  /**
   * Get format
   * @return format
  **/
  @ApiModelProperty(value = "")

  @Valid

  public FormatType getFormat() {
    return format;
  }

  public void setFormat(FormatType format) {
    this.format = format;
  }

  public ImportDataSourceType payload(PayloadType payload) {
    this.payload = payload;
    return this;
  }

  /**
   * Get payload
   * @return payload
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public PayloadType getPayload() {
    return payload;
  }

  public void setPayload(PayloadType payload) {
    this.payload = payload;
  }

  public ImportDataSourceType datasetReference(DatasetReferenceType datasetReference) {
    this.datasetReference = datasetReference;
    return this;
  }

  /**
   * If the data source configured via sourceFormat and payload has more than one geodata source (e.g. multiple layers, featureTypes, database tables, etc.), the respective name/reference of the target feature dataset must be submitted here
   * @return datasetReference
  **/
  @ApiModelProperty(value = "If the data source configured via sourceFormat and payload has more than one geodata source (e.g. multiple layers, featureTypes, database tables, etc.), the respective name/reference of the target feature dataset must be submitted here")

  @Valid

  public DatasetReferenceType getDatasetReference() {
    return datasetReference;
  }

  public void setDatasetReference(DatasetReferenceType datasetReference) {
    this.datasetReference = datasetReference;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImportDataSourceType importDataSourceType = (ImportDataSourceType) o;
    return Objects.equals(this.type, importDataSourceType.type) &&
        Objects.equals(this.format, importDataSourceType.format) &&
        Objects.equals(this.payload, importDataSourceType.payload) &&
        Objects.equals(this.datasetReference, importDataSourceType.datasetReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, format, payload, datasetReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImportDataSourceType {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
    sb.append("    datasetReference: ").append(toIndentedString(datasetReference)).append("\n");
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

