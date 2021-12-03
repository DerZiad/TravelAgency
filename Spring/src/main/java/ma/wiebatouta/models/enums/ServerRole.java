package ma.wiebatouta.models.enums;

public enum ServerRole {
	ADMIN("ADMIN", "/admin"), CLIENT("CLIENT", "/client");

	private String role;
	private String path;

	private ServerRole(String role, String path) {
		this.role = role;
		this.path = path;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
