package fi.otavanopisto.security;

public interface PermissionFeatureHandler {

  /**
   * Allows permission feature to explicitly approve given 
   * allowance or change it in any way it needs to.
   * 
   * @param perm
   * @param userEntity
   * @param contextReference
   * @param allowed
   * @return
   */
  boolean hasPermission(String permission, User userEntity, ContextReference contextReference, boolean allowed);
}
