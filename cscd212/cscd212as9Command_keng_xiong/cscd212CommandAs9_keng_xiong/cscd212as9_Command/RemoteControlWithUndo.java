package cscd212as9_Command;

public class RemoteControlWithUndo {
	Command[] onCommands;
	Command[] offCommands;
	Command undoCommand;
	
	public RemoteControlWithUndo() {
		onCommands = new Command[7]; // Creates Command array for onCommands with default size of 7
		offCommands = new Command[7]; // Creates Command array for offCommands with default size of 7
		
		Command noCommand = new NoCommand();
		for(int i = 0; i < 7; i++) {
			onCommands[i] = noCommand; // sets onCommands as noCommand by default
			offCommands[i] = noCommand; // sets offCommands as noCommand by default
		}
		undoCommand = noCommand; // sets Undo command as noCommand by default
	}
	
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand; // Takes in onCommand from parameters and assigns it to selected slot
		offCommands[slot] = offCommand; // Takes in offCommand from parameters and assigns it to selected slot
	}
	
	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute(); // Uses execute method for selected slot
		undoCommand = onCommands[slot]; // Assigns that slot to undoCommand variable
	}
	
	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute(); // Uses execute method for selected slot
		undoCommand = offCommands[slot]; // Assigns that slot to undoCommand variable
	}
	
	public void undoButtonWasPushed() {
		undoCommand.undo(); // Accesses undo method
	}
	
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control ------\n");
		for(int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "   " + offCommands[i].getClass().getName() + "\n");
		}
		
		return stringBuff.toString(); // Returns RemoteControlWithUndo toString
	}
}
