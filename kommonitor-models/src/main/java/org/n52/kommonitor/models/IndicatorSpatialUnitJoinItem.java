package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.n52.kommonitor.models.PermissionLevelType;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * IndicatorSpatialUnitJoinItem
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-26T07:42:31.257276800+01:00[Europe/Berlin]")
public class IndicatorSpatialUnitJoinItem implements Serializable {

  private static final long serialVersionUID = 1L;

  @Valid
  private List<String> permissions;

  private String ownerId;

  private String spatialUnitId;

  private String spatialUnitName;

  @Valid
  private List<PermissionLevelType> userPermissions;

  private Boolean isPublic;

  public IndicatorSpatialUnitJoinItem() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public IndicatorSpatialUnitJoinItem(String spatialUnitId, String spatialUnitName) {
    this.spatialUnitId = spatialUnitId;
    this.spatialUnitName = spatialUnitName;
  }

  public IndicatorSpatialUnitJoinItem permissions(List<String> permissions) {
    this.permissions = permissions;
    return this;
  }

  public IndicatorSpatialUnitJoinItem addPermissionsItem(String permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * list of permissions on this entity
   * @return permissions
  */
  
  @Schema(name = "permissions", description = "list of permissions on this entity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("permissions")
  public List<String> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<String> permissions) {
    this.permissions = permissions;
  }

  public IndicatorSpatialUnitJoinItem ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  /**
   * identifier of the owning group
   * @return ownerId
  */
  
  @Schema(name = "ownerId", description = "identifier of the owning group", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ownerId")
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public IndicatorSpatialUnitJoinItem spatialUnitId(String spatialUnitId) {
    this.spatialUnitId = spatialUnitId;
    return this;
  }

  /**
   * ID of the applicable spatial unit
   * @return spatialUnitId
  */
  @NotNull 
  @Schema(name = "spatialUnitId", description = "ID of the applicable spatial unit", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("spatialUnitId")
  public String getSpatialUnitId() {
    return spatialUnitId;
  }

  public void setSpatialUnitId(String spatialUnitId) {
    this.spatialUnitId = spatialUnitId;
  }

  public IndicatorSpatialUnitJoinItem spatialUnitName(String spatialUnitName) {
    this.spatialUnitName = spatialUnitName;
    return this;
  }

  /**
   * name of the applicable spatial unit
   * @return spatialUnitName
  */
  @NotNull 
  @Schema(name = "spatialUnitName", description = "name of the applicable spatial unit", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("spatialUnitName")
  public String getSpatialUnitName() {
    return spatialUnitName;
  }

  public void setSpatialUnitName(String spatialUnitName) {
    this.spatialUnitName = spatialUnitName;
  }

  public IndicatorSpatialUnitJoinItem userPermissions(List<PermissionLevelType> userPermissions) {
    this.userPermissions = userPermissions;
    return this;
  }

  public IndicatorSpatialUnitJoinItem addUserPermissionsItem(PermissionLevelType userPermissionsItem) {
    if (this.userPermissions == null) {
      this.userPermissions = new ArrayList<>();
    }
    this.userPermissions.add(userPermissionsItem);
    return this;
  }

  /**
   * list of permissions that are effective on this dataset for the current user
   * @return userPermissions
  */
  @Valid 
  @Schema(name = "userPermissions", description = "list of permissions that are effective on this dataset for the current user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userPermissions")
  public List<PermissionLevelType> getUserPermissions() {
    return userPermissions;
  }

  public void setUserPermissions(List<PermissionLevelType> userPermissions) {
    this.userPermissions = userPermissions;
  }

  public IndicatorSpatialUnitJoinItem isPublic(Boolean isPublic) {
    this.isPublic = isPublic;
    return this;
  }

  /**
   * flag whether the resource is publicly accessible
   * @return isPublic
  */
  
  @Schema(name = "isPublic", description = "flag whether the resource is publicly accessible", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isPublic")
  public Boolean getIsPublic() {
    return isPublic;
  }

  public void setIsPublic(Boolean isPublic) {
    this.isPublic = isPublic;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndicatorSpatialUnitJoinItem indicatorSpatialUnitJoinItem = (IndicatorSpatialUnitJoinItem) o;
    return Objects.equals(this.permissions, indicatorSpatialUnitJoinItem.permissions) &&
        Objects.equals(this.ownerId, indicatorSpatialUnitJoinItem.ownerId) &&
        Objects.equals(this.spatialUnitId, indicatorSpatialUnitJoinItem.spatialUnitId) &&
        Objects.equals(this.spatialUnitName, indicatorSpatialUnitJoinItem.spatialUnitName) &&
        Objects.equals(this.userPermissions, indicatorSpatialUnitJoinItem.userPermissions) &&
        Objects.equals(this.isPublic, indicatorSpatialUnitJoinItem.isPublic);
  }

  @Override
  public int hashCode() {
    return Objects.hash(permissions, ownerId, spatialUnitId, spatialUnitName, userPermissions, isPublic);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndicatorSpatialUnitJoinItem {\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    spatialUnitId: ").append(toIndentedString(spatialUnitId)).append("\n");
    sb.append("    spatialUnitName: ").append(toIndentedString(spatialUnitName)).append("\n");
    sb.append("    userPermissions: ").append(toIndentedString(userPermissions)).append("\n");
    sb.append("    isPublic: ").append(toIndentedString(isPublic)).append("\n");
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

