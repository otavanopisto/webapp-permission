package fi.otavanopisto.security;

import fi.otavanopisto.security.Permit.Style;

public class PermitUtils {

  public static boolean hasPermission(Identity identity, String[] permissions, ContextReference permitContext, Style style) {
    boolean permitted = false;

    switch (style) {
      case OR:
        // For or we break when permit is true
        for (String permission : permissions) {
          if (permitted = identity.hasPermission(permission, permitContext))
            break;
        }
      break;
      
      case AND:
        // And is true by default (as long as at least one permission exists) and breaks if permit hits false
        permitted = permissions.length > 0;
        
        for (String permission : permissions) {
          if (permitted = identity.hasPermission(permission, permitContext))
            break;
        }
      break;
    }

    return permitted;
  }
  
}
