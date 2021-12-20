package cscd212as9_Command;

public class LightOffCommand implements Command {
	Light light;
	
	public LightOffCommand(Light light) {
		this.light = light;
	}
	
	public void execute() {
		light.off(); // Uses the off method from the Light class
	}
	
	public void undo() {
		light.on(); // Uses the on command from the Light class as Undo
	}
}
