package cscd212as9_Command;

public class LightOnCommand implements Command {
	Light light;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}
	
	public void execute() {
		light.on(); // Uses the on method from the Light class
	}
	
	public void undo() {
		light.off(); // Uses the off method from the Light class as Undo
	}
}
