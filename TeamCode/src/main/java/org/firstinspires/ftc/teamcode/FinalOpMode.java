package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;//Imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;//Imports the TeleOp code
import com.qualcomm.robotcore.hardware.DcMotor;//Imports the code for the DcMotor
import com.qualcomm.robotcore.hardware.Servo;//Imports the code for the Servo

@TeleOp
public class FinalOpMode extends LinearOpMode {
    private DcMotor rightDriveMotor;//Makes variable for the right drive motor
    private DcMotor leftDriveMotor;//Makes variable for the left drive motor
    private DcMotor armMotor;
    private Servo wristServo;
    private Servo clawServo;

    @Override
    public void runOpMode(){
        rightDriveMotor = hardwareMap.get(DcMotor.class, "rightDriveMotor");//Gets the location of the rightDriveMotor
        leftDriveMotor = hardwareMap.get(DcMotor.class, "leftDriveMotor");//Gets the location of the leftDriveMotor
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        wristServo = hardwareMap.get(Servo.class, "wristServo");
        clawServo = hardwareMap.get(Servo.class, "clawServo");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();//Waits for driver to hit play on the drive station

        //Below two variables are for assigning motor power
        double rightMotorPower = 0;
        double leftMotorPower = 0;
        double armMotorPower = 0;
        double servoPosition = 0;
        while(opModeIsActive()){//Loop runs until the driver hits stop
            //Code for the drive train
            rightMotorPower = -this.gamepad1.right_stick_y;//Takes input from the right joy stick
            rightDriveMotor.setPower(rightMotorPower);//Makes right motor power equal to input from the right joy stick
            leftMotorPower = this.gamepad1.left_stick_y;//Takes input from the left joy stick
            leftDriveMotor.setPower(leftMotorPower);//Makes left motor power equal to input from the left joy stick

            //Code for the arm motor
            armMotorPower = -this.gamepad2.right_stick_y;
            //armMotorPower = armMotorPower/2;
            armMotor.setPower(armMotorPower);

            //Code for wrist servo
            servoPosition = wristServo.getPosition();
            if(gamepad2.left_stick_y > 0 && servoPosition > 0)
                servoPosition -= .005;
            else if(gamepad2.left_stick_y < 0 && servoPosition < 1)
                servoPosition += .005;
            wristServo.setPosition(servoPosition);

            //Code for the claw
            if(gamepad2.right_bumper)
                clawServo.setPosition(180);
            else if(gamepad2.left_bumper)
                clawServo.setPosition(0);

            //Telemetry update the variable values
            telemetry.addData("Status", "Running");
            telemetry.addData("rightDriveMotor", rightDriveMotor.getPower());
            telemetry.addData("Right Motor Power", rightMotorPower);
            telemetry.addData("leftDriveMotor", leftDriveMotor.getPower());
            telemetry.addData("Right Motor Power", leftMotorPower);
            telemetry.addData("armMotor", armMotor.getPower());
            telemetry.addData("Arm Motor Power", armMotorPower);
            telemetry.addData("wristServo", wristServo.getPosition());
            telemetry.addData("clawServo", clawServo.getPosition());
            telemetry.update();
        }
    }
}