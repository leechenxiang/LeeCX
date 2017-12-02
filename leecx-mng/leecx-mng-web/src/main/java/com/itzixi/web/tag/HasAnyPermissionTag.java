package com.itzixi.web.tag;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.PermissionTag;

public class HasAnyPermissionTag extends PermissionTag {

    public HasAnyPermissionTag() {
    }

    protected boolean showTagBody(String permissions) {
            boolean hasAnyPermissions = false;

            Subject subject = getSubject();

            if (subject != null) {
                    for (String role : permissions.split(",")) {

                            if (subject.isPermitted(role.trim())) {
                                    hasAnyPermissions = true;
                                    break;
                            }
                    }
            }
            return hasAnyPermissions;
    }

}
