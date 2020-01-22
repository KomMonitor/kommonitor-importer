package org.n52.kommonitor.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Definition of an uploaded file
 */
@ApiModel(description = "Definition of an uploaded file")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-22T08:50:34.193+01:00")

public class UploadedFileType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("contentType")
  private String contentType = null;

  public UploadedFileType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of the uploaded file
   * @return name
  **/
  @ApiModelProperty(required = true, value = "name of the uploaded file")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UploadedFileType contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
   * Content type of the uploaded files
   * @return contentType
  **/
  @ApiModelProperty(value = "Content type of the uploaded files")


  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadedFileType uploadedFileType = (UploadedFileType) o;
    return Objects.equals(this.name, uploadedFileType.name) &&
        Objects.equals(this.contentType, uploadedFileType.contentType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, contentType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadedFileType {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
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

