package model;

public enum Status {
	NAO_INICIADO("NAO_INICIADO"),
	EM_DESENVOLVIMENTO("EM_DESENVOLVIMENTO"),
	FINALIZADO("FINALIZADO");
	
	String nameStatus;
	
	Status(String nameStatus){
		this.nameStatus = nameStatus;
	}
	
	public String getNameStatus() {
		return nameStatus;
	}
	
	
	public static Status fromString(String status) {
		if(status != null) {
			for(Status s: Status.values()){
				if(s.nameStatus.equalsIgnoreCase(status)) {
					return s;
				}
			}
		}
		throw new IllegalArgumentException("Status invalido. "+status);
	}
}
