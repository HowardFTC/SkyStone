package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class MyFIRSTJavaOpMode extends LinearOpMode {
    private Gyroscope imu;
    private DcMotor motorTest;

    @Override
    public void runOpMode(){
        motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start(driver presses PLAY)
        waitForStart();
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()){
            motorTest.setPower(.5);
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}
/*
try {
            imu = hardwareMap.get(Gyroscope.class, "imu");//Lines of code
        } catch(Exception e) {
            System.out.println(e);// or System.out.println("motor not work");// Outprints error message
            throw new NullPointerException() ;//Stops Code
        }
*/