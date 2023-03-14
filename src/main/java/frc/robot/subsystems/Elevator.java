package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


import frc.robot.Constants;
import frc.robot.RobotContainer;
public class Elevator extends SubsystemBase{
    public WPI_TalonFX elevatorMain = new WPI_TalonFX(Constants.Elevator.elevatorMotor);
    private DigitalInput level_0;
    private DigitalInput level_1;
    private DigitalInput level_2;
    int state = 1;
    

    public Elevator(){
        elevatorMain.configFactoryDefault();
        elevatorMain.setNeutralMode(NeutralMode.Brake);   
        level_0 = new DigitalInput(0);
        level_1 = new DigitalInput(1);
        level_2 = new DigitalInput(2);
    }
    public void elevatorLevelOne() {
        //elevatorMain.set(speed);
        if(state != 1 && level_0.get() == false ){
            elevatorDown(.1);
        }
        else{
            elevatorStop();
            state = 1;
            System.out.println("Elevator is level ONE");
        }        
    }
    public void elevatorLevelTwo(){
        if(state == 1 && level_1.get() == true){
            elevatorUp(.1);
        }
        else if(state == 3 && level_1.get() == true){
            elevatorDown(.1);
        }
        else{
            elevatorStop();
            state = 2;
            System.out.println("Elveator is level 2");
        }
        
    }
    public void elevatorLevelThree(){
        if(state != 3 && level_2.get()  == true){
            elevatorUp(.1);
        }
        else{
            elevatorStop();
            state = 3;
            System.out.println("elevator levl 3");
        }
    }
    public void elevatorStop(){
        elevatorMain.set(0);
    }
    public void elevatorUp(double speed){
        //elevatorMain.set(speed);
        System.err.println("*******************" + level_2.get());
        if(level_2.get()  == false){ 
            elevatorStop();
            state = 3;
            return;
        }
        else if(level_0.get()  == false){ 
            elevatorStop();
            state = 1;
            return;
        }
        if(state != 1 && speed<0){
            elevatorMain.set(speed);
    
        }
         else if(state !=3 && speed>0){
            elevatorMain.set(speed);
        }
        else{
           elevatorMain.set(speed);
        }
    
    }
    public void elevatorDown(double speed){
        elevatorMain.set(-speed);
    }
    
    
    
}
