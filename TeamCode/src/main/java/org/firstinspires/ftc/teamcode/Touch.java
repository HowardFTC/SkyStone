package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;//Imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;//Imports the TeleOp code
import com.qualcomm.robotcore.hardware.Servo;//Imports the code for the Servo
import com.qualcomm.robotcore.hardware.DigitalChannel;

@TeleOp
public class Touch extends LinearOpMode {
    private DigitalChannel digitalTouch;
    private Servo servo;

    @Override
    public void runOpMode() {
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while(opModeIsActive()){
            if (digitalTouch.getState() == false) {
                // button is pressed.
                servo.setPosition(1);
                telemetry.addData("Button", "PRESSED");
            }else{
                // button is not pressed.
                servo.setPosition(0);
                telemetry.addData("Button", "NOT PRESSED");
            }

            telemetry.addData("Status", "Running");
            telemetry.addData("servo", servo.getPosition());
            telemetry.update();
        }
    }
}