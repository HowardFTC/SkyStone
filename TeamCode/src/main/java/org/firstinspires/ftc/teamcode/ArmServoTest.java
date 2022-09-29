package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class ArmServoTest extends LinearOpMode{
    private Servo armServo;

    @Override
    public void runOpMode(){
        armServo = hardwareMap.get(Servo.class, "armServo");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while(opModeIsActive()){
            if(gamepad1.a)
                armServo.setPosition(0);
            else if(gamepad1.b)
                armServo.setPosition(0);
            else if(gamepad1.y)
                armServo.setPosition(-1);
            else if(gamepad1.x)
                armServo.setPosition(1);

            telemetry.addData("Status", "Running");
            telemetry.addData("armServo", armServo.getPosition());
            telemetry.update();
        }
    }
}