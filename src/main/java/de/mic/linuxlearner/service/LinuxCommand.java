package de.mic.linuxlearner.service;

public class LinuxCommand {

	private String command;
	private String source;
	private String schalter;
	private LinuxCommand pipe;

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public LinuxCommand getPipe() {
		return pipe;
	}

	public void setPipe(LinuxCommand pipe) {
		this.pipe = pipe;
	}

	public String getSchalter() {
		return schalter;
	}

	public void setSchalter(String schalter) {
		this.schalter = schalter;
	}

}
