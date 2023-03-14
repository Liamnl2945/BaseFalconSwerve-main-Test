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
    double wrist = -WristController.getRawAxis(0);
    Wrist.wristUp(wrist);
}
}
