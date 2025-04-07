package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Task {
	private final SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
	
	private String taskName;
	private Status statusTask;
	private Date startDate;
	private Date endDate;
	private String description;
	
	public Task() {}
	public Task(String taskName, String description) {
		this.taskName = taskName;
		statusTask = Status.NAO_INICIADO;	
		this.description = description;
	}
	public Task(String taskName, String description, Status statusTask, Date startDate) {
		this.taskName = taskName;
		this.statusTask = statusTask;
		this.startDate = startDate;
		this.description = description;
	}
	
	
	public String getTaskName() { return taskName; }
	public void setTaskName(String taskName) { this.taskName = taskName; }

	public Status getStatusTask() { return statusTask; }

	public String getStartDate() { return (startDate != null) ? sdf.format(startDate) : "Não Iniciada"; }

	public String getEndDate() { return (endDate != null) ? sdf.format(endDate) : "Não Finalizada"; }

	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public void statusChange() throws ParseException {
		LocalDate ld = LocalDate.now();
		String currentDate = "";
		
		currentDate = String.format("%02d/%d", ld.getMonthValue(), ld.getYear());
		
		if(getStatusTask() == Status.NAO_INICIADO) {
			statusTask = Status.EM_DESENVOLVIMENTO;
			startDate = sdf.parse(currentDate);
		}else if (getStatusTask() == Status.EM_DESENVOLVIMENTO) {
			statusTask = Status.FINALIZADO;
			endDate = sdf.parse(currentDate);
		}
	}
	
	@Override
	public String toString() {
		return "Titulo: "+getTaskName()+"\nStatus: "+getStatusTask()+"\nDescrição: "+getDescription()+"\nData Inicio: "+getStartDate()+"\tData Fim: "+getEndDate();
	}
}