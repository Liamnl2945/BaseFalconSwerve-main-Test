package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Elevator;
import frc.robot.RobotContainer;
public class ElevatorCommand extends CommandBase {
   private final Elevator Elevator; 
   private Joystick elevatorController;
   
   

public ElevatorCommand(Elevator elevator, Joystick elevatorController){

   this.Elevator = elevator;
   this.elevatorController = elevatorController;
   
   
   addRequirements(elevator);

}

@Override
public void execute(){
   double elevatorMain = -elevatorController.getRawAxis(1);
   Elevator.elevatorUp(elevatorMain);
   /*if(elevatorController.getRawButton(0)){
      System.err.println("elevator button 0"  );
      Elevator.elevatorLevelOne();
      
   }
   if(elevatorController.getRawButton(1)){
      Elevator.elevatorLevelTwo();
      System.err.println("elevator button 1");
   }
   if(elevatorController.getRawButton(2)){
      Elevator.elevatorLevelThree();
      System.err.println("elevator button 2"  );
   }*/
}
   



}
