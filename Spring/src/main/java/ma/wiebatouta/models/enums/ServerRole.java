package ma.wiebatouta.models.enums;

public enum ServerRole {
	ADMIN("ADMIN", "/admin"), CLIENT("CLIENT", "/");

	private String role;
	private String space;

	private ServerRole(String role, String space) {
		this.role = role;
		this.space = space;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

}
