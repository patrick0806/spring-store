package tech.patricknicezi.Spring.Store.internal.entities;

public enum UserRoles {
    ADMIN("admin"),
    CUSTOMER("customer");

    private String role;

    UserRoles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
