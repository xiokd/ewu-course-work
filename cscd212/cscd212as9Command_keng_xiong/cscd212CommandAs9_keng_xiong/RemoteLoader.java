import cscd212as9_Command.*;

public class RemoteLoader {

	public static void main(String[] args) {
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo(); // Creates RemoteControlWithUndo object

		Light livingRoomLight = new Light("Living Room"); // Creates Light object

		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight); // Creates new LightOnCommand
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight); // Creates new LightOffCommand

		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff); // Uses RemoteControlWithUndo object's set command method while passing parameters

		remoteControl.onButtonWasPushed(0); // Uses onButtonWasPushed method with passed parameter
		remoteControl.offButtonWasPushed(0); // Uses offButtonWasPushed method with passed parameter
		System.out.println(remoteControl); // Prints out toString method for RemoteControlWithUndo object
		remoteControl.undoButtonWasPushed(); // Uses undoButtonWasPushed method
		remoteControl.offButtonWasPushed(0); // Uses offButtonWasPushed method with passed parameter
		remoteControl.onButtonWasPushed(0); // Uses onButtonWasPushed method with passed parameter
		System.out.println(remoteControl); // Prints out toString method for the RemoteControlWithUndo object
		remoteControl.undoButtonWasPushed(); // Uses undoButtomWasPushed method

	}

}
