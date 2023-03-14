package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Wrist extends SubsystemBase {

    public WPI_TalonFX wristMotor = new WPI_TalonFX(Constants.Wrist.Wrist);
    private DigitalInput level_3;
    private DigitalInput level_4;
    int state = 1;
    double autospeed = 0;

    public Wrist(){
        wristMotor.configFactoryDefault();
        wristMotor.setNeutralMode(NeutralMode.Brake);
        level_3 = new DigitalInput(3);
        level_4 = new DigitalInput(4);
        autospeed = 0;
        state = 1;
    }
    public int getState(){
        return state;
    }
    public double getAutoSpeed(){
        return autospeed;
    }
    public void wristStop(){
        wristMotor.set(0);
        autospeed = 0;
    } 
    public void wristUp(double POV){
        //System.err.println("******************* level 3" + level_3.get()+ "\n********************** level 4"+level_4.get()+"POV " + POV +  " autospeed " + autospeed + " state " + state);
        double speed = 0;
        if(POV == -180){
            speed = -.95;
        }
        else if(POV == 0){
            speed = 0.95;
        }
        else{ 
            speed = 0;
        }
        if(autospeed != 0){
            speed = autospeed;
        }
        if(level_3.get()  == false){ 
            wristStop();
            state = 1;   
        }
       
        else if(level_4.get()  == false){ 
            wristStop();
            state = 2;
            
        }
        if(state != 1 && speed<0){
            wristMotor.set(speed);
            state = 4;
    
        }
         else if(state !=2 && speed>0){
            wristMotor.set(speed);
            state = 5;
        }
        else{
            wristMotor.set(0);
        }
    }
    public void wristTop(){
        autospeed = .95;
    }

    public void wristDown(){
      autospeed = -.95; 
    }

}
