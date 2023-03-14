package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Wrist;

public class WristCommand extends CommandBase{
    private final Wrist Wrist;
    private Joystick WristController;
    


public WristCommand(Wrist wrist, Joystick WristController){

    this.Wrist = wrist;
    this.WristController = WristController;

    addRequirements(wrist);

}

@Override
public void execute(){
   // System.err.println("********************* get_state= " + Wrist.getState());
    /*if(WristController.getRawButton(3) && Wrist.getState() == 1){
        Wrist.wristTop();
    }
    else if(WristController.getRawButton(4) && Wrist.getState() == 2){
        Wrist.wristDown();
    }*/
    double wrist = -WristController.getPOV(0);
    Wrist.wristUp(wrist);
}

}
